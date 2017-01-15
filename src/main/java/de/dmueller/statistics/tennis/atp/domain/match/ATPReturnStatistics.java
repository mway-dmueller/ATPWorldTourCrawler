package de.dmueller.statistics.tennis.atp.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ATPReturnStatistics {

	@JsonProperty("FirstServeReturnPointsPercentage")
	private Long firstServePointsWonPercentage;
	@JsonProperty("FirstServeReturnPointsDividend")
	private Long firstServePointsWon;
	@JsonProperty("FirstServeReturnPointsDivisor")
	private Long firstServePointsPlayed;

	@JsonProperty("SecondServePointsPercentage")
	private Long secondServePointsWonPercentage;
	@JsonProperty("SecondServePointsDividend")
	private Long secondServePointsWon;
	@JsonProperty("SecondServePointsDivisor")
	private Long secondServePointsPlayed;

	@JsonProperty("BreakPointsConvertedPercentage")
	private Long breakPointsConvertedPercentage;
	@JsonProperty("BreakPointsConvertedDividend")
	private Long breakPointsConverted;
	@JsonProperty("BreakPointsConvertedDivisor")
	private Long breakPointsPlayed;

	@JsonProperty("ReturnGamesPlayedPercentage")
	private Long returnGamesPlayedPercentage;
	@JsonProperty("ReturnGamesPlayed")
	private Long returnGamesPlayed;

	@JsonProperty("TotalReturnPointsWonPercentage")
	private Long totalReturnPointsWonPercentage;
	@JsonProperty("TotalReturnPointsWonDividend")
	private Long totalReturnPointsWon;
	@JsonProperty("TotalReturnPointsWonDivisor")
	private Long totalReturnPointsPlayed;

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

	public Long getBreakPointsConvertedPercentage() {
		return breakPointsConvertedPercentage;
	}

	public void setBreakPointsConvertedPercentage(final Long breakPointsConvertedPercentage) {
		this.breakPointsConvertedPercentage = breakPointsConvertedPercentage;
	}

	public Long getBreakPointsConverted() {
		return breakPointsConverted;
	}

	public void setBreakPointsConverted(final Long breakPointsConverted) {
		this.breakPointsConverted = breakPointsConverted;
	}

	public Long getBreakPointsPlayed() {
		return breakPointsPlayed;
	}

	public void setBreakPointsPlayed(final Long breakPointsPlayed) {
		this.breakPointsPlayed = breakPointsPlayed;
	}

	public Long getReturnGamesPlayedPercentage() {
		return returnGamesPlayedPercentage;
	}

	public void setReturnGamesPlayedPercentage(final Long returnGamesPlayedPercentage) {
		this.returnGamesPlayedPercentage = returnGamesPlayedPercentage;
	}

	public Long getReturnGamesPlayed() {
		return returnGamesPlayed;
	}

	public void setReturnGamesPlayed(final Long returnGamesPlayed) {
		this.returnGamesPlayed = returnGamesPlayed;
	}

	public Long getTotalReturnPointsWonPercentage() {
		return totalReturnPointsWonPercentage;
	}

	public void setTotalReturnPointsWonPercentage(final Long totalReturnPointsWonPercentage) {
		this.totalReturnPointsWonPercentage = totalReturnPointsWonPercentage;
	}

	public Long getTotalReturnPointsWon() {
		return totalReturnPointsWon;
	}

	public void setTotalReturnPointsWon(final Long totalReturnPointsWon) {
		this.totalReturnPointsWon = totalReturnPointsWon;
	}

	public Long getTotalReturnPointsPlayed() {
		return totalReturnPointsPlayed;
	}

	public void setTotalReturnPointsPlayed(final Long totalReturnPointsPlayed) {
		this.totalReturnPointsPlayed = totalReturnPointsPlayed;
	}
}
