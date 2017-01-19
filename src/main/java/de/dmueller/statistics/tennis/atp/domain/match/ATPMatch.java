package de.dmueller.statistics.tennis.atp.domain.match;

import de.dmueller.statistics.tennis.atp.domain.tournament.ATPTournamentEvent;

public class ATPMatch {

	private String id;
	private String link;
	private ATPTournamentEvent event;
	private ATPMatchPlayer winningPlayer;
	private ATPMatchPlayer losingPlayer;
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

	public ATPMatchPlayer getWinningPlayer() {
		return winningPlayer;
	}

	public void setWinningPlayer(final ATPMatchPlayer winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	public ATPMatchPlayer getLosingPlayer() {
		return losingPlayer;
	}

	public void setLosingPlayer(final ATPMatchPlayer losingPlayer) {
		this.losingPlayer = losingPlayer;
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
		builder.append("\n\twinningPlayer=");
		builder.append(winningPlayer);
		builder.append(",\n\tlosingPlayer=");
		builder.append(losingPlayer);
		builder.append(",\n\tresult=");
		builder.append(result);
		builder.append(",\n\tround=");
		builder.append(round);
		builder.append("]");
		return builder.toString();
	}
}
