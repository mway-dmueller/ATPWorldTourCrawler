import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import de.dmueller.statistics.tennis.atp.crawler.ATPResultsArchiveCrawler;
import de.dmueller.statistics.tennis.atp.domain.match.ATPMatch;
import de.dmueller.statistics.tennis.atp.domain.tournament.ATPTournament;
import de.dmueller.statistics.tennis.atp.domain.tournament.ATPTournamentEvent;

public class ScoreUtils {

	// private static final String TOURNAMENT_RESOURCE_HTML = "score_brisbane_339_2016.html";
	// private static final String TOURNAMENT_RESOURCE_HTML = "score_rio-de-janeiro_96_2016.html";
	private static final String TOURNAMENT_RESOURCE_HTML = "score_rio-de-janeiro_6932_2016.html";

	public static void main(final String[] args) {

		final ATPTournament tournament = new ATPTournament("6932", "rio-de-janeiro");

		final ATPTournamentEvent tournamentEvent = new ATPTournamentEvent();
		tournamentEvent.setTournament(tournament);
		tournamentEvent.setYear("2016");

		Set<ATPMatch> matches = null;
		try (InputStream is = ScoreUtils.class.getResourceAsStream(TOURNAMENT_RESOURCE_HTML)) {
			final Document document = Jsoup.parse(IOUtils.toString(is, "UTF-8"));

			final ATPResultsArchiveCrawler crawler = new ATPResultsArchiveCrawler();
			matches = crawler.getMatches(tournamentEvent, document);
		} catch (final IOException e) {
			System.err.println(e.getMessage());
		}

		assert matches.size() == 43;

		System.out.println(tournamentEvent.toString());
		for (final ATPMatch match : matches) {
			System.out.println(match);
		}
	}
}
