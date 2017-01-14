package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPPointStatistics {

	private Integer pointsWon;
	private Integer pointsLost;
	private Integer pointsPlayed;

	public Integer getPointsWon() {
		return pointsWon;
	}

	public void setPointsWon(final Integer pointsWon) {
		this.pointsWon = pointsWon;
	}

	public Integer getPointsLost() {
		return pointsLost;
	}

	public void setPointsLost(final Integer pointsLost) {
		this.pointsLost = pointsLost;
	}

	public Integer getPointsPlayed() {
		return pointsPlayed;
	}

	public void setPointsPlayed(final Integer pointsPlayed) {
		this.pointsPlayed = pointsPlayed;
	}
}