package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPMatchStatistics {

	private Integer totalSetsPlayed;
	private Integer totalGamesPlayed;
	private Integer totalPointsPlayed;

	private ATPPlayerStatistics playerOneStatistics;
	private ATPPlayerStatistics playerTwoStatistics;

	public Integer getTotalSetsPlayed() {
		return totalSetsPlayed;
	}

	public void setTotalSetsPlayed(final Integer totalSetsPlayed) {
		this.totalSetsPlayed = totalSetsPlayed;
	}

	public Integer getTotalGamesPlayed() {
		return totalGamesPlayed;
	}

	public void setTotalGamesPlayed(final Integer totalGamesPlayed) {
		this.totalGamesPlayed = totalGamesPlayed;
	}

	public Integer getTotalPointsPlayed() {
		return totalPointsPlayed;
	}

	public void setTotalPointsPlayed(final Integer totalPointsPlayed) {
		this.totalPointsPlayed = totalPointsPlayed;
	}

	public ATPPlayerStatistics getPlayerOneStatistics() {
		return playerOneStatistics;
	}

	public void setPlayerOneStatistics(final ATPPlayerStatistics playerOneStatistics) {
		this.playerOneStatistics = playerOneStatistics;
	}

	public ATPPlayerStatistics getPlayerTwoStatistics() {
		return playerTwoStatistics;
	}

	public void setPlayerTwoStatistics(final ATPPlayerStatistics playerTwoStatistics) {
		this.playerTwoStatistics = playerTwoStatistics;
	}
}
