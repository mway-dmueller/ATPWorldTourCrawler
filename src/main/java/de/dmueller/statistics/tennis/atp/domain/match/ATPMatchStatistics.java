package de.dmueller.statistics.tennis.atp.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ATPMatchStatistics {

	@JsonProperty("setNum")
	private long setNumber;

	@JsonProperty("playerStats")
	private ATPPlayerStatistics playerStatistics;
	@JsonProperty("opponentStats")
	private ATPPlayerStatistics opponentStats;

	public long getSetNumber() {
		return setNumber;
	}

	public void setSetNumber(final long setNumber) {
		this.setNumber = setNumber;
	}

	public ATPPlayerStatistics getPlayerStatistics() {
		return playerStatistics;
	}

	public void setPlayerStatistics(final ATPPlayerStatistics playerStatistics) {
		this.playerStatistics = playerStatistics;
	}

	public ATPPlayerStatistics getOpponentStats() {
		return opponentStats;
	}

	public void setOpponentStats(final ATPPlayerStatistics opponentStats) {
		this.opponentStats = opponentStats;
	}
}
