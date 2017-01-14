package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPReturnPointStatistics extends ATPAbstractPointStatistics {

	private Integer breakPointsConverted;
	private Integer breakPointsLost;
	private Integer breakPointsPlayed;

	public Integer getBreakPointsConverted() {
		return breakPointsConverted;
	}

	public void setBreakPointsConverted(final Integer breakPointsConverted) {
		this.breakPointsConverted = breakPointsConverted;
	}

	public Integer getBreakPointsLost() {
		return breakPointsLost;
	}

	public void setBreakPointsLost(final Integer breakPointsLost) {
		this.breakPointsLost = breakPointsLost;
	}

	public Integer getBreakPointsPlayed() {
		return breakPointsPlayed;
	}

	public void setBreakPointsPlayed(final Integer breakPointsPlayed) {
		this.breakPointsPlayed = breakPointsPlayed;
	}
}