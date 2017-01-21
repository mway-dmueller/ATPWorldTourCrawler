package de.dmueller.statistics.tennis.atp.crawler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.dmueller.statistics.tennis.atp.crawler.util.DateUtils;
import de.dmueller.statistics.tennis.atp.crawler.util.PlayerUtils;
import de.dmueller.statistics.tennis.atp.domain.player.ATPPlayer;
import de.dmueller.statistics.tennis.atp.util.Attributes;
import de.dmueller.statistics.tennis.atp.util.CrawlerConstants;
import de.dmueller.statistics.tennis.atp.util.Tags;

public class ATPPlayersCrawler {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");

	private static final String PLAYER_URL_PATTERN = CrawlerConstants.ATP_WORLD_TOUR_URL
			+ "/en/rankings/singles?rankDate=%s&rankRange=1-5000";

	private int timeout = 30000; // 30 seconds
	private int maxBodySize = 0; // unlimited body size

	public ATPPlayersCrawler() {
		// use the default connection settings
	}

	public ATPPlayersCrawler(final int timeout, final int maxBodySize) {
		this.timeout = timeout;
		this.maxBodySize = maxBodySize;
	}

	public List<Date> getDates() {

		final List<Date> dates = new ArrayList<>();

		final Calendar calendar = DateUtils.getLastMonday();

		final Date startDate = new GregorianCalendar(1996, 0, 1).getTime(); // 1995.01.01
		Date date;
		while ((date = calendar.getTime()).after(startDate)) {
			dates.add(date);

			calendar.add(Calendar.DAY_OF_YEAR, -7);
		}

		return dates;
	}

	public Set<ATPPlayer> getAllPlayers() {

		final Map<String, ATPPlayer> allPlayers = new LinkedHashMap<>();

		final List<Date> dates = getDates();
		for (final Date date : dates) {
			final Set<ATPPlayer> players = getPlayers(date);
			for (final ATPPlayer player : players) {
				final String playerCode = player.getCode();

				if (allPlayers.containsKey(playerCode)) {
					final ATPPlayer currentPlayer = allPlayers.get(playerCode);
					currentPlayer.getRankings().putAll(player.getRankings());
				} else {
					allPlayers.put(playerCode, player);
				}
			}
		}

		return new LinkedHashSet<>(allPlayers.values());
	}

	public Set<ATPPlayer> getPlayers(final Date date) {

		final Set<ATPPlayer> players = new LinkedHashSet<>();
		try {
			final Connection connection = Jsoup.connect(String.format(PLAYER_URL_PATTERN, DATE_FORMAT.format(date)));
			connection.timeout(timeout); // 30 seconds
			connection.maxBodySize(maxBodySize); // unlimited
			final Document document = connection.get();

			final Element singlesRanking = document.getElementById("singlesRanking");
			assert Tags.DIV.equalsIgnoreCase(singlesRanking.tagName());

			final Element rankingDetailAjaxContainer = singlesRanking.getElementById("rankingDetailAjaxContainer");
			assert Tags.DIV.equalsIgnoreCase(rankingDetailAjaxContainer.tagName());
			assert rankingDetailAjaxContainer.children().size() > 0;

			final Element rankingTable = rankingDetailAjaxContainer.child(0);
			assert Tags.TABLE.equalsIgnoreCase(rankingTable.tagName());
			assert "mega-table".equals(rankingTable.className());
			assert rankingTable.children().size() == 2;

			final Element rankingTableHead = rankingTable.child(0);
			assert Tags.THEAD.equalsIgnoreCase(rankingTableHead.tagName());

			final Element rankingTableBody = rankingTable.child(1);
			assert Tags.TBODY.equalsIgnoreCase(rankingTableBody.tagName());

			final Elements tableRows = rankingTableBody.children();
			for (final Element tableRow : tableRows) {
				final ATPPlayer player = new ATPPlayer();

				final Elements tableCells = tableRow.children();
				for (final Element tableCell : tableCells) {
					final String tagName = tableCell.tagName();
					assert Tags.TD.equalsIgnoreCase(tagName);

					final String className = tableCell.className();
					assert className.endsWith("-cell");

					switch (className) {
					case "rank-cell":
						assert tableCell.hasText();

						String rank = tableCell.text().trim();
						if (rank.endsWith("T")) {
							rank = rank.substring(0, rank.length() - 1);
						}

						player.getRankings().put(date, Integer.valueOf(rank));
						break;
					case "move-cell":
						player.setMove(getMove(tableCell));
						break;
					case "country-cell":
						player.setCountry(getCountry(tableCell));
						break;
					case "player-cell":
						setPlayerDetails(player, tableCell);
						break;
					case "age-cell":
						player.setAge(getAge(tableCell));
						break;
					case "points-cell":
						player.setPoints(getPoints(tableCell));
						break;
					case "tourn-cell":
						player.setTournamentsPlayed(getTournamentsPlayed(tableCell));
						break;
					case "pts-cell":
						player.setPointsDropping(getIntValue(tableCell));
						break;
					case "next-cell":
						player.setNextBest(getIntValue(tableCell));
						break;
					default:
						assert false : "unknown class " + className;
						break;
					}
				}

				players.add(player);
			}
		} catch (final IOException e) {
			System.out.println(e.getMessage());
		}

		return players;
	}

	private int getMove(final Element tableCell) {
		assert tableCell.children().size() == 2;

		final Element moveDirection = tableCell.child(0);
		assert Tags.DIV.equalsIgnoreCase(moveDirection.tagName());

		final String className = moveDirection.className();
		if ("move-none".equals(className)) {
			return 0;
		}

		final Element moveText = tableCell.child(1);
		assert Tags.DIV.equalsIgnoreCase(moveText.tagName());
		assert "move-text".equals(moveText.className());
		assert moveText.hasText();

		final int move = Integer.valueOf(moveText.text().trim());

		return "move-up".equals(className) ? move : Math.negateExact(move);
	}

	private String getCountry(final Element tableCell) {
		assert tableCell.children().size() == 1;

		final Element countryInner = tableCell.child(0);
		assert Tags.DIV.equalsIgnoreCase(countryInner.tagName());
		assert "country-inner".equals(countryInner.className());
		assert countryInner.children().size() == 1;

		final Element countryItem = countryInner.child(0);
		assert Tags.DIV.equalsIgnoreCase(countryItem.tagName());
		assert "country-item".equals(countryItem.className());
		assert countryItem.children().size() == 1;

		final Element image = countryItem.child(0);
		assert Tags.IMG.equalsIgnoreCase(image.tagName());
		assert image.hasAttr(Attributes.ALT);

		return image.attr(Attributes.ALT);
	}

	private void setPlayerDetails(final ATPPlayer atpPlayer, final Element tableCell) {
		assert tableCell.children().size() == 1;

		final Element anchor = tableCell.child(0);
		assert Tags.A.equalsIgnoreCase(anchor.tagName());
		assert anchor.hasAttr(Attributes.HREF);

		final String href = anchor.attr(Attributes.HREF);

		atpPlayer.setCode(PlayerUtils.extractPlayerCode(href));
		atpPlayer.setLink(href);
		atpPlayer.setName(anchor.text());
	}

	private int getAge(final Element tableCell) {
		assert tableCell.hasText();

		return Integer.valueOf(tableCell.text().trim());
	}

	private int getPoints(final Element tableCell) {
		assert tableCell.children().size() == 1;

		final Element anchor = tableCell.child(0);
		assert Tags.A.equalsIgnoreCase(anchor.tagName());

		return getIntValue(anchor.html());
	}

	private int getTournamentsPlayed(final Element tableCell) {
		assert tableCell.children().size() == 1;

		final Element anchor = tableCell.child(0);
		assert Tags.A.equalsIgnoreCase(anchor.tagName());

		return getIntValue(anchor.html());
	}

	private int getIntValue(final Element tableCell) {
		assert tableCell.hasText();

		return getIntValue(tableCell.text());
	}

	private int getIntValue(final String value) {
		return Integer.valueOf(value.trim().replace(",", "").replace(".", ""));
	}

	public static void main(final String[] args) {
		final List<Date> dates = new ATPPlayersCrawler().getDates();
		for (final Date date : dates) {
			System.out.println(DATE_FORMAT.format(date));
		}

		final ATPPlayersCrawler crawler = new ATPPlayersCrawler();
		final Set<ATPPlayer> players = crawler.getPlayers(new GregorianCalendar(2017, 0, 16).getTime());
		for (final ATPPlayer player : players) {
			System.out.println(player);
		}
	}
}
