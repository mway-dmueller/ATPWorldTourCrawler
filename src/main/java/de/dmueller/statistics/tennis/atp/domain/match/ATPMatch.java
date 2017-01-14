package de.dmueller.statistics.tennis.atp.domain.match;

import de.dmueller.statistics.tennis.atp.domain.player.ATPPlayer;
import de.dmueller.statistics.tennis.atp.domain.tournament.ATPTournamentEvent;

public class ATPMatch {

	private String id;
	private String link;
	private ATPTournamentEvent event;
	private ATPPlayer winner;
	private ATPPlayer loser;
	private ATPResult result;
	private ATPMatchStatistics statistics;
	private String round;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	public ATPTournamentEvent getEvent() {
		return event;
	}

	public void setEvent(final ATPTournamentEvent event) {
		this.event = event;
	}

	public ATPPlayer getWinner() {
		return winner;
	}

	public void setWinner(final ATPPlayer winner) {
		this.winner = winner;
	}

	public ATPPlayer getLoser() {
		return loser;
	}

	public void setLoser(final ATPPlayer loser) {
		this.loser = loser;
	}

	public ATPResult getResult() {
		return result;
	}

	public void setResult(final ATPResult result) {
		this.result = result;
	}

	public ATPMatchStatistics getStatistics() {
		return statistics;
	}

	public void setStatistics(final ATPMatchStatistics statistics) {
		this.statistics = statistics;
	}

	public String getRound() {
		return round;
	}

	public void setRound(final String round) {
		this.round = round;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ATPMatch [");
		builder.append("\n\tid=");
		builder.append(id);
		builder.append("\n\tlink=");
		builder.append(link);
		builder.append("\n\twinner=");
		builder.append(winner);
		builder.append(",\n\tloser=");
		builder.append(loser);
		builder.append(",\n\tresult=");
		builder.append(result);
		builder.append(",\n\tround=");
		builder.append(round);
		builder.append("]");
		return builder.toString();
	}
}
