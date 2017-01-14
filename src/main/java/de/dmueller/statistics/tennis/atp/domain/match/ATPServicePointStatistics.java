package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPServicePointStatistics extends ATPAbstractPointStatistics {

	private Integer aces;
	private Integer doubleFaults;

	private Integer firstServes;
	private Integer firstServesPlayed;

	private Integer secondServes;
	private Integer secondServesPlayed;

	private Integer breakPointsSaved;
	private Integer breakPointsLost;
	private Integer breakPointsPlayed;

	public Integer getAces() {
		return aces;
	}

	public void setAces(final Integer aces) {
		this.aces = aces;
	}

	public Integer getDoubleFaults() {
		return doubleFaults;
	}

	public void setDoubleFaults(final Integer doubleFaults) {
		this.doubleFaults = doubleFaults;
	}

	public Integer getFirstServes() {
		return firstServes;
	}

	public void setFirstServes(final Integer firstServes) {
		this.firstServes = firstServes;
	}

	public Integer getFirstServesPlayed() {
		return firstServesPlayed;
	}

	public void setFirstServesPlayed(final Integer firstServesPlayed) {
		this.firstServesPlayed = firstServesPlayed;
	}

	public Integer getSecondServes() {
		return secondServes;
	}

	public void setSecondServes(final Integer secondServes) {
		this.secondServes = secondServes;
	}

	public Integer getSecondServesPlayed() {
		return secondServesPlayed;
	}

	public void setSecondServesPlayed(final Integer secondServesPlayed) {
		this.secondServesPlayed = secondServesPlayed;
	}

	public Integer getBreakPointsSaved() {
		return breakPointsSaved;
	}

	public void setBreakPointsSaved(final Integer breakPointsSaved) {
		this.breakPointsSaved = breakPointsSaved;
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