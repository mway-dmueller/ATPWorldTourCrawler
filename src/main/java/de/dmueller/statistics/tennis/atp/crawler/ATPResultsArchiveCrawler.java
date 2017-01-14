package de.dmueller.statistics.tennis.atp.crawler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.ImmutableList;

import de.dmueller.statistics.tennis.atp.domain.TournamentArchiveForYear;
import de.dmueller.statistics.tennis.atp.domain.match.ATPMatch;
import de.dmueller.statistics.tennis.atp.domain.match.ATPMatchStatistics;
import de.dmueller.statistics.tennis.atp.domain.match.ATPResult;
import de.dmueller.statistics.tennis.atp.domain.match.ATPSet;
import de.dmueller.statistics.tennis.atp.domain.player.ATPPlayer;
import de.dmueller.statistics.tennis.atp.domain.tournament.ATPCourt;
import de.dmueller.statistics.tennis.atp.domain.tournament.ATPTotalFinancialCommitment;
import de.dmueller.statistics.tennis.atp.domain.tournament.ATPTournament;
import de.dmueller.statistics.tennis.atp.domain.tournament.ATPTournamentEvent;
import de.dmueller.statistics.tennis.atp.util.Attributes;
import de.dmueller.statistics.tennis.atp.util.Tags;

public class ATPResultsArchiveCrawler implements Runnable {

	private static final String WALKOVER = "(W/O)";
	private static final String RETIRED = "(RET)";

	// private static final List<String> YEARS = ImmutableList.<String> of("1996", "1997", "1998",
	// "1999", "2000", "2001",
	// "2002", "2003", "2004", "2005", "2006", "2007", "2006", "2007", "2008", "2009", "2010",
	// "2011", "2012",
	// "2013", "2014", "2015", "2016"// , "2017"
	// );
	private static final List<String> YEARS = ImmutableList.<String> of("2016");

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");

	private static final String ATP_WORLD_TOUR_URL = "http://www.atpworldtour.com";
	private static final String YEAR_URL_PATTERN = ATP_WORLD_TOUR_URL + "/-/ajax/Scores/GetTournamentArchiveForYear/%s";
	private static final String TOURNAMENT_URL_PATTERN = ATP_WORLD_TOUR_URL + "/en/scores/archive/%s/%s/%s/results";

	/*
	 * pattern: /en/players/<player-name>/<player-id>/overview
	 */
	private static final Pattern PLAYER_OVERVIEW_PATTERN = Pattern.compile("/en/players/([\\w\\-]+)/([\\w]+)/overview");

	/*
	 * pattern:
	 * /en/tournaments/<tournament-name>/<tournament-id>/<year>/match-stats/<winner-id>/<loser-id>/
	 * live/<match-id>/match-stats
	 */
	private static final Pattern MATCH_STATISTICS_PATTERN = Pattern.compile(
			"/en/tournaments/([^/]+)/([0-9]+)/([0-9]+)/match-stats/([\\w]+)/([\\w]+)/live/([\\w]+)/match-stats");

	private final Map<String, ATPTournament> tournaments = new HashMap<>();

	public static void main(final String[] args) {
		final Thread thread = new Thread(new ATPResultsArchiveCrawler());
		thread.start();
	}

	@Override
	public void run() {
		for (final String year : YEARS) {
			final Client client = ClientBuilder.newClient();
			final WebTarget webTarget = client.target(String.format(YEAR_URL_PATTERN, year));

			final Builder builder = webTarget.request("text/json");
			final List<TournamentArchiveForYear> wrapper = builder
					.get(new GenericType<List<TournamentArchiveForYear>>() {
					});

			for (final TournamentArchiveForYear tournament : wrapper) {
				try {
					final ATPTournamentEvent tournamentEvent = getTournamentEvent(tournament, year);

					System.out.println(tournamentEvent.toString());
				} catch (final IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public ATPTournamentEvent getTournamentEvent(final TournamentArchiveForYear tournamentArchiveForYear,
			final String year) throws IOException {
		final String tournamentId = tournamentArchiveForYear.getValue();
		final String tournamentDescriptor = tournamentArchiveForYear.getDataAttributes().getDescriptor();

		if (!tournaments.containsKey(tournamentId)) {
			tournaments.put(tournamentId, new ATPTournament(tournamentId, tournamentDescriptor));
		}
		final ATPTournament tournament = tournaments.get(tournamentId);

		final ATPTournamentEvent tournamentEvent = new ATPTournamentEvent();
		tournamentEvent.setTournament(tournament);
		tournamentEvent.setYear(year);
		tournamentEvent.setMatches(getMatches(tournamentEvent));

		return tournamentEvent;
	}

	public Set<ATPMatch> getMatches(final ATPTournamentEvent tournamentEvent) throws IOException {

		final ATPTournament tournament = tournamentEvent.getTournament();

		final String url = String.format(TOURNAMENT_URL_PATTERN, tournament.getDescriptor(), tournament.getId(),
				tournamentEvent.getYear());

		final Connection connection = Jsoup.connect(url);
		final Document document = connection.get();

		return getMatches(tournamentEvent, document);
	}

	public Set<ATPMatch> getMatches(final ATPTournamentEvent tournamentEvent, final Document document)
			throws IOException {
		/*
		 * General information
		 */
		setTournamentDetails(document, tournamentEvent);

		/*
		 * Scores
		 */
		final Element scoresResultsContent = document.getElementById("scoresResultsContent");
		assert Tags.DIV.equalsIgnoreCase(scoresResultsContent.tagName());

		final Element dayTableWrapper = scoresResultsContent.getElementsByClass("day-table-wrapper").first();
		assert Tags.DIV.equalsIgnoreCase(dayTableWrapper.tagName());

		final Element dayTable = dayTableWrapper.getElementsByClass("day-table").first();
		assert Tags.TABLE.equalsIgnoreCase(dayTable.tagName());

		final Set<ATPMatch> matches = new LinkedHashSet<>();

		Optional<String> round = Optional.empty();

		final Elements children = dayTable.children();
		for (final Element child : children) {
			final String childTagName = child.tagName();
			if (Tags.THEAD.equalsIgnoreCase(childTagName)) {
				final Element tableRow = child.child(0);
				assert Tags.TR.equalsIgnoreCase(tableRow.tagName());
				final Element tableColumn = tableRow.child(0);
				assert Tags.TH.equalsIgnoreCase(tableColumn.tagName())
						|| Tags.TD.equalsIgnoreCase(tableColumn.tagName());
				assert tableColumn.hasText();

				round = Optional.of(tableColumn.text());
			} else if (Tags.TBODY.equalsIgnoreCase(childTagName)) {
				assert round.isPresent();

				final Elements tableRows = child.children();
				for (final Element tableRow : tableRows) {
					assert Tags.TR.equalsIgnoreCase(tableRow.tagName());

					final ATPMatch match = new ATPMatch();

					setMatchDetails(match, tableRow);

					match.setEvent(tournamentEvent);
					match.setWinner(getWinner(tableRow));
					match.setLoser(getLoser(tableRow));
					match.setResult(getResult(tableRow));

					final String link = match.getLink();
					if (StringUtils.isNotEmpty(link)) {
						match.setStatistics(getMatchStatistics(link));
					}

					match.setRound(round.get());

					matches.add(match);
				}

				round = Optional.empty();
			}
		}

		return matches;
	}

	private void setTournamentDetails(final Document document, final ATPTournamentEvent tournamentEvent) {
		final ATPTournament tournament = tournamentEvent.getTournament();

		final Element lastEventsPlayedStandAloneNoSlider = document
				.getElementById("lastEventsPlayedStandAloneNoSlider");
		assert Tags.DIV.equalsIgnoreCase(lastEventsPlayedStandAloneNoSlider.tagName());
		final Element titleContent = lastEventsPlayedStandAloneNoSlider.getElementsByClass("title-content").first();
		assert Tags.TD.equalsIgnoreCase(titleContent.tagName());
		final Element tourneyDetailsTableWrapper = lastEventsPlayedStandAloneNoSlider
				.getElementsByClass("tourney-details-table-wrapper").first();
		assert Tags.TD.equalsIgnoreCase(tourneyDetailsTableWrapper.tagName());

		assert titleContent.children().size() >= 3;

		// Tournament name
		final Element tournamentNameDetails = titleContent.child(0);
		assert Tags.A.equalsIgnoreCase(tournamentNameDetails.tagName());
		assert tournamentNameDetails.hasText();
		final String tournamentName = tournamentNameDetails.text();

		tournament.setName(tournamentName);

		// Tournament location
		final Element locationDetails = titleContent.child(1);
		assert Tags.SPAN.equalsIgnoreCase(locationDetails.tagName());
		assert "tourney-location".equals(locationDetails.className());
		assert locationDetails.hasText();
		final String location = locationDetails.text();

		final String[] locationTokens = location.split(",");
		assert locationTokens.length == 2;

		tournament.setCity(StringUtils.trim(locationTokens[0]));
		tournament.setCountry(StringUtils.trim(locationTokens[1]));

		// Tournament period
		final Element periodDetails = titleContent.child(2);
		assert Tags.SPAN.equalsIgnoreCase(periodDetails.tagName());
		assert "tourney-dates".equals(periodDetails.className());
		assert periodDetails.hasText();
		final String period = periodDetails.text();

		final String[] dateTokens = period.split("-");
		assert dateTokens.length == 2;

		try {
			tournamentEvent.setFromDate(DATE_FORMAT.parse(StringUtils.trim(dateTokens[0])));
			tournamentEvent.setToDate(DATE_FORMAT.parse(StringUtils.trim(dateTokens[1])));
		} catch (final ParseException e) {
			System.err.println(e.getMessage());
		}

		final Element tourneyDetailsTable = tourneyDetailsTableWrapper.child(0);
		assert Tags.TABLE.equalsIgnoreCase(tourneyDetailsTable.tagName());
		final Element tourneyDetailsTableBody = tourneyDetailsTable.child(0);
		assert Tags.TBODY.equalsIgnoreCase(tourneyDetailsTableBody.tagName());

		final Element tourneyDetailsTableRow = tourneyDetailsTableBody.child(0);
		assert Tags.TR.equalsIgnoreCase(tourneyDetailsTableRow.tagName());

		tournamentEvent.setCourt(getCourt(tourneyDetailsTableRow));
		tournamentEvent.setTotalFinancialCommitment(getTotalFinancialCommitment(tourneyDetailsTableRow));
	}

	private ATPCourt getCourt(final Element tourneyDetailsTableRow) {
		final Element courtDetails = tourneyDetailsTableRow.child(1);
		assert Tags.TD.equalsIgnoreCase(courtDetails.tagName());
		assert "tourney-details".equals(courtDetails.className());

		final Element courtInfoArea = courtDetails.child(1);
		assert Tags.DIV.equalsIgnoreCase(courtInfoArea.tagName());
		assert "info-area".equals(courtInfoArea.className());

		final Element courtItemDetails = courtInfoArea.child(0);
		assert Tags.DIV.equalsIgnoreCase(courtItemDetails.tagName());
		assert "item-details".equals(courtItemDetails.className());

		final Element courtItemValue = courtItemDetails.child(0);
		assert Tags.SPAN.equalsIgnoreCase(courtItemValue.tagName());
		assert "item-value".equals(courtItemValue.className());
		assert courtItemValue.hasText();

		return ATPCourt.fromValue(courtItemValue.text());
	}

	private ATPTotalFinancialCommitment getTotalFinancialCommitment(final Element tourneyDetailsTableRow) {
		final Element prizeDetails = tourneyDetailsTableRow.child(tourneyDetailsTableRow.children().size() - 1);
		assert Tags.TD.equalsIgnoreCase(prizeDetails.tagName());
		assert "tourney-details fin-commit".equals(prizeDetails.className());

		final Element prizeIconArea = prizeDetails.child(0);
		assert Tags.DIV.equalsIgnoreCase(prizeIconArea.tagName());
		assert "icon-area".equals(prizeIconArea.className());
		assert prizeIconArea.children().size() >= 2;

		final Element prizeIconItemDetails = prizeIconArea.child(1);
		assert Tags.DIV.equalsIgnoreCase(prizeIconItemDetails.tagName());
		assert "item-details".equals(prizeIconItemDetails.className());
		assert prizeIconItemDetails.hasText();
		assert "Total Financial Commitment".equals(StringUtils.trim(prizeIconItemDetails.text()));

		final Element prizeInfoArea = prizeDetails.child(1);
		assert Tags.DIV.equalsIgnoreCase(prizeInfoArea.tagName());
		assert "info-area".equals(prizeInfoArea.className());

		final Element prizeItemDetails = prizeInfoArea.child(0);
		assert Tags.DIV.equalsIgnoreCase(prizeItemDetails.tagName());
		assert "item-details".equals(prizeItemDetails.className());

		final Element prizeItemValue = prizeItemDetails.child(0);
		assert Tags.SPAN.equalsIgnoreCase(prizeItemValue.tagName());
		assert "item-value".equals(prizeItemValue.className());
		assert prizeItemValue.hasText();

		final String prize = StringUtils.trim(prizeItemValue.text());
		if (StringUtils.isBlank(prize)) {
			final String currency = prize.substring(0, 1);
			final int value = NumberUtils.toInt(prize.substring(1).replace(".", "").replace(",", ""), 0);

			new ATPTotalFinancialCommitment(currency, value);
		}

		return new ATPTotalFinancialCommitment();
	}

	private void setMatchDetails(final ATPMatch match, final Element tableRow) {
		final Element score = tableRow.child(7);
		assert Tags.TD.equalsIgnoreCase(score.tagName());
		assert "day-table-score".equals(score.className());

		final Element a = score.child(0);
		assert Tags.A.equalsIgnoreCase(a.tagName());

		if (!WALKOVER.equalsIgnoreCase(StringUtils.trim(a.html()))) {
			assert a.hasAttr(Attributes.HREF);

			final String href = a.attr(Attributes.HREF);

			final Matcher matcher = MATCH_STATISTICS_PATTERN.matcher(href);
			assert matcher.find();

			match.setId(matcher.group(6));
			match.setLink(matcher.group());
		}
	}

	private ATPPlayer getWinner(final Element tableRow) {
		final Element seed = tableRow.child(0);
		assert Tags.TD.equalsIgnoreCase(seed.tagName());
		assert "day-table-seed".equals(seed.className());

		final Element flag = tableRow.child(1);
		assert Tags.TD.equalsIgnoreCase(flag.tagName());
		assert "day-table-flag".equals(flag.className());

		final Element name = tableRow.child(2);
		assert Tags.TD.equalsIgnoreCase(name.tagName());
		assert "day-table-name".equals(name.className());
		assert name.hasText();

		return getPlayer(seed, flag, name);
	}

	private ATPPlayer getLoser(final Element tableRow) {
		final Element seed = tableRow.child(4);
		assert Tags.TD.equalsIgnoreCase(seed.tagName());
		assert "day-table-seed".equals(seed.className());

		final Element flag = tableRow.child(5);
		assert Tags.TD.equalsIgnoreCase(flag.tagName());
		assert "day-table-flag".equals(flag.className());

		final Element name = tableRow.child(6);
		assert Tags.TD.equalsIgnoreCase(name.tagName());
		assert "day-table-name".equals(name.className());
		assert name.hasText();

		return getPlayer(seed, flag, name);
	}

	private ATPPlayer getPlayer(final Element seed, final Element flag, final Element name) {
		final ATPPlayer player = new ATPPlayer();

		if (seed.children().size() > 0) {
			final Element span = seed.child(0);
			assert Tags.SPAN.equalsIgnoreCase(span.tagName());
			assert span.hasText();

			player.setSeed(span.text().trim().replace("(", "").replace(")", ""));
		}
		player.setNationality(getCountryCode(flag));

		// player details
		final Element a = name.child(0);
		assert Tags.A.equalsIgnoreCase(a.tagName());
		assert a.hasAttr(Attributes.HREF);

		final String href = a.attr(Attributes.HREF);

		final Matcher matcher = PLAYER_OVERVIEW_PATTERN.matcher(href);
		if (matcher.find()) {
			player.setId(StringUtils.upperCase(matcher.group(2)));
			player.setLink(matcher.group(0));
		}

		player.setName(StringUtils.trim(a.text()));

		return player;
	}

	private String getCountryCode(final Element flag) {
		final Element image = flag.child(0);
		assert Tags.IMG.equalsIgnoreCase(image.tagName());

		return image.attr(Attributes.ALT);
	}

	private ATPResult getResult(final Element tableRow) {
		final Element score = tableRow.child(7);
		assert Tags.TD.equalsIgnoreCase(score.tagName());
		assert "day-table-score".equals(score.className());

		final Element a = score.child(0);
		assert Tags.A.equalsIgnoreCase(a.tagName());

		final String result = StringUtils.trim(a.html());

		return calculateResult(result);
	}

	private ATPResult calculateResult(final String value) {
		final ATPResult atpResult = new ATPResult();

		String result = value;
		while (result.contains("<sup>")) {
			final int start = result.indexOf("<sup>");
			final int end = result.indexOf("</sup>") + 6;

			result = result.substring(0, start) + result.substring(end, result.length());
		}

		final Set<ATPSet> sets = new LinkedHashSet<>();

		final String[] setTokens = result.split(" ");
		for (final String set : setTokens) {
			if (WALKOVER.equalsIgnoreCase(set) || RETIRED.equalsIgnoreCase(set)) {
				// one of the players has retired
				atpResult.setWalkover(true);
			} else if (set.length() > 2) {
				// only happens for specific Grand Slam tournaments in which no deciding Tie-Break
				// is played
				final int middle = set.length() % 2 == 0 ? set.length() / 2 : (set.length() / 2) + 1;

				try {
					final int first = Integer.valueOf(set.substring(0, middle));
					final int second = Integer.valueOf(set.substring(middle));

					sets.add(new ATPSet(first, second));
				} catch (final NumberFormatException e) {
					System.err.println(e.getMessage());
				}
			} else {
				// default case
				try {
					final int first = Character.getNumericValue(set.charAt(0));
					final int second = Character.getNumericValue(set.charAt(1));

					sets.add(new ATPSet(first, second));
				} catch (final NumberFormatException e) {
					System.err.println(e.getMessage());
				}
			}
		}

		// either player has retired or between 2 to 5 sets have been played
		assert atpResult.isWalkover() || (sets.size() >= 2 && sets.size() <= 5);

		atpResult.setSets(sets);

		return atpResult;
	}

	private ATPMatchStatistics getMatchStatistics(final String url) throws IOException {
		final ATPMatchStatistics matchStatistics = new ATPMatchStatistics();

		// TODO: fill with life
		final Connection connection = Jsoup.connect(ATP_WORLD_TOUR_URL + url);
		final Document document = connection.get();

		final Element matchStatsContainer = document.getElementById("matchStatsContainer");
		assert Tags.DIV.equalsIgnoreCase(matchStatsContainer.tagName());

		final Element matchStatsTable = matchStatsContainer.child(0);
		assert Tags.TABLE.equalsIgnoreCase(matchStatsTable.tagName());
		assert "match-stats-table".equals(matchStatsTable.className());

		final Element matchStatsTableBody = matchStatsTable.child(0);
		assert Tags.TBODY.equalsIgnoreCase(matchStatsTableBody.tagName());

		return matchStatistics;
	}
}
