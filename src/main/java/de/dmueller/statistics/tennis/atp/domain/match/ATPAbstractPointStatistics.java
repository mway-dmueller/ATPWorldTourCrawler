package de.dmueller.statistics.tennis.atp.domain.match;

public abstract class ATPAbstractPointStatistics extends ATPPointStatistics {

	private Integer firstServePointsWon;
	private Integer firstServePointsLost;
	private Integer firstServePointsPlayed;

	private Integer secondServePointsWon;
	private Integer secondServePointsLost;
	private Integer secondServePointsPlayed;

	public Integer getFirstServePointsWon() {
		return firstServePointsWon;
	}

	public void setFirstServePointsWon(final Integer firstServePointsWon) {
		this.firstServePointsWon = firstServePointsWon;
	}

	public Integer getFirstServePointsLost() {
		return firstServePointsLost;
	}

	public void setFirstServePointsLost(final Integer firstServePointsLost) {
		this.firstServePointsLost = firstServePointsLost;
	}

	public Integer getFirstServePointsPlayed() {
		return firstServePointsPlayed;
	}

	public void setFirstServePointsPlayed(final Integer firstServePointsPlayed) {
		this.firstServePointsPlayed = firstServePointsPlayed;
	}

	public Integer getSecondServePointsWon() {
		return secondServePointsWon;
	}

	public void setSecondServePointsWon(final Integer secondServePointsWon) {
		this.secondServePointsWon = secondServePointsWon;
	}

	public Integer getSecondServePointsLost() {
		return secondServePointsLost;
	}

	public void setSecondServePointsLost(final Integer secondServePointsLost) {
		this.secondServePointsLost = secondServePointsLost;
	}

	public Integer getSecondServePointsPlayed() {
		return secondServePointsPlayed;
	}

	public void setSecondServePointsPlayed(final Integer secondServePointsPlayed) {
		this.secondServePointsPlayed = secondServePointsPlayed;
	}
}