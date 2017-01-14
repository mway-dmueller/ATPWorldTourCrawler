package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPGameStatistics {

	private Integer gamesWon;
	private Integer gamesLost;
	private Integer gamesPlayed;

	public Integer getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(final Integer gamesWon) {
		this.gamesWon = gamesWon;
	}

	public Integer getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(final Integer gamesLost) {
		this.gamesLost = gamesLost;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(final Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
}