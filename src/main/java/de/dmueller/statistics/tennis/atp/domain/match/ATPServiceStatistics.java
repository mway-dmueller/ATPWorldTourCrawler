package de.dmueller.statistics.tennis.atp.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ATPServiceStatistics {

	@JsonProperty("Aces")
	private Long aces;
	@JsonProperty("AcesPercentage")
	private Double acesPercentage;

	@JsonProperty("DoubleFaults")
	private Long doubleFaults;
	@JsonProperty("DoubleFaultsPercentage")
	private Long doubleFaultsPercentage;

	@JsonProperty("FirstServePercentage")
	private Long firstServesPercentage;
	@JsonProperty("FirstServeDividend")
	private Long firstServes;
	@JsonProperty("FirstServeDivisor")
	private Long firstServesPlayed;

	@JsonProperty("FirstServePointsWonPercentage")
	private Long firstServePointsWonPercentage;
	@JsonProperty("FirstServePointsWonDividend")
	private Long firstServePointsWon;
	@JsonProperty("FirstServePointsWonDivisor")
	private Long firstServePointsPlayed;

	@JsonProperty("SecondServePointsWonPercentage")
	private Long secondServePointsWonPercentage;
	@JsonProperty("SecondServePointsWonDividend")
	private Long secondServePointsWon;
	@JsonProperty("SecondServePointsWonDivisor")
	private Long secondServePointsPlayed;

	@JsonProperty("BreakPointsSavedPercentage")
	private Long breakPointsSavedPercentage;
	@JsonProperty("BreakPointsSavedDividend")
	private Long breakPointsSaved;
	@JsonProperty("BreakPointsSavedDivisor")
	private Long breakPointsSuffered;

	@JsonProperty("ServiceGamesPlayed")
	private Long serviceGamesPlayed;
	@JsonProperty("ServiceGamesPlayedPercentage")
	private Long serviceGamesPlayedPercentage;

	@JsonProperty("TotalServicePointsWonPercentage")
	private Long totalServicePointsWonPercentage;
	@JsonProperty("TotalServicePointsWonDividend")
	private Long totalServicePointsWon;
	@JsonProperty("TotalServicePointsWonDivisor")
	private Long totalServicePointsPlayed;

	public Long getAces() {
		return aces;
	}

	public void setAces(final Long aces) {
		this.aces = aces;
	}

	public Double getAcesPercentage() {
		return acesPercentage;
	}

	public void setAcesPercentage(final Double acesPercentage) {
		this.acesPercentage = acesPercentage;
	}

	public Long getDoubleFaults() {
		return doubleFaults;
	}

	public void setDoubleFaults(final Long doubleFaults) {
		this.doubleFaults = doubleFaults;
	}

	public Long getDoubleFaultsPercentage() {
		return doubleFaultsPercentage;
	}

	public void setDoubleFaultsPercentage(final Long doubleFaultsPercentage) {
		this.doubleFaultsPercentage = doubleFaultsPercentage;
	}

	public Long getFirstServesPercentage() {
		return firstServesPercentage;
	}

	public void setFirstServesPercentage(final Long firstServesPercentage) {
		this.firstServesPercentage = firstServesPercentage;
	}

	public Long getFirstServes() {
		return firstServes;
	}

	public void setFirstServes(final Long firstServes) {
		this.firstServes = firstServes;
	}

	public Long getFirstServesPlayed() {
		return firstServesPlayed;
	}

	public void setFirstServesPlayed(final Long firstServesPlayed) {
		this.firstServesPlayed = firstServesPlayed;
	}

	public Long getFirstServePointsWonPercentage() {
		return firstServePointsWonPercentage;
	}

	public void setFirstServePointsWonPercentage(final Long firstServePointsWonPercentage) {
		this.firstServePointsWonPercentage = firstServePointsWonPercentage;
	}

	public Long getFirstServePointsWon() {
		return firstServePointsWon;
	}

	public void setFirstServePointsWon(final Long firstServePointsWon) {
		this.firstServePointsWon = firstServePointsWon;
	}

	public Long getFirstServePointsPlayed() {
		return firstServePointsPlayed;
	}

	public void setFirstServePointsPlayed(final Long firstServePointsPlayed) {
		this.firstServePointsPlayed = firstServePointsPlayed;
	}

	public Long getSecondServePointsWonPercentage() {
		return secondServePointsWonPercentage;
	}

	public void setSecondServePointsWonPercentage(final Long secondServePointsWonPercentage) {
		this.secondServePointsWonPercentage = secondServePointsWonPercentage;
	}

	public Long getSecondServePointsWon() {
		return secondServePointsWon;
	}

	public void setSecondServePointsWon(final Long secondServePointsWon) {
		this.secondServePointsWon = secondServePointsWon;
	}

	public Long getSecondServePointsPlayed() {
		return secondServePointsPlayed;
	}

	public void setSecondServePointsPlayed(final Long secondServePointsPlayed) {
		this.secondServePointsPlayed = secondServePointsPlayed;
	}

	public Long getBreakPointsSavedPercentage() {
		return breakPointsSavedPercentage;
	}

	public void setBreakPointsSavedPercentage(final Long breakPointsSavedPercentage) {
		this.breakPointsSavedPercentage = breakPointsSavedPercentage;
	}

	public Long getBreakPointsSaved() {
		return breakPointsSaved;
	}

	public void setBreakPointsSaved(final Long breakPointsSaved) {
		this.breakPointsSaved = breakPointsSaved;
	}

	public Long getBreakPointsSuffered() {
		return breakPointsSuffered;
	}

	public void setBreakPointsSuffered(final Long breakPointsSuffered) {
		this.breakPointsSuffered = breakPointsSuffered;
	}

	public Long getServiceGamesPlayed() {
		return serviceGamesPlayed;
	}

	public void setServiceGamesPlayed(final Long serviceGamesPlayed) {
		this.serviceGamesPlayed = serviceGamesPlayed;
	}

	public Long getServiceGamesPlayedPercentage() {
		return serviceGamesPlayedPercentage;
	}

	public void setServiceGamesPlayedPercentage(final Long serviceGamesPlayedPercentage) {
		this.serviceGamesPlayedPercentage = serviceGamesPlayedPercentage;
	}

	public Long getTotalServicePointsWonPercentage() {
		return totalServicePointsWonPercentage;
	}

	public void setTotalServicePointsWonPercentage(final Long totalServicePointsWonPercentage) {
		this.totalServicePointsWonPercentage = totalServicePointsWonPercentage;
	}

	public Long getTotalServicePointsWon() {
		return totalServicePointsWon;
	}

	public void setTotalServicePointsWon(final Long totalServicePointsWon) {
		this.totalServicePointsWon = totalServicePointsWon;
	}

	public Long getTotalServicePointsPlayed() {
		return totalServicePointsPlayed;
	}

	public void setTotalServicePointsPlayed(final Long totalServicePointsPlayed) {
		this.totalServicePointsPlayed = totalServicePointsPlayed;
	}
}
