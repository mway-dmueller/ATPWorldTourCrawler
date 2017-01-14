package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPSetStatistics {

	private Integer setsWon;
	private Integer setsLost;
	private Integer setsPlayed;

	public Integer getSetsWon() {
		return setsWon;
	}

	public void setSetsWon(final Integer setsWon) {
		this.setsWon = setsWon;
	}

	public Integer getSetsLost() {
		return setsLost;
	}

	public void setSetsLost(final Integer setsLost) {
		this.setsLost = setsLost;
	}

	public Integer getSetsPlayed() {
		return setsPlayed;
	}

	public void setSetsPlayed(final Integer setsPlayed) {
		this.setsPlayed = setsPlayed;
	}
}