package de.dmueller.statistics.tennis.atp.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ATPPlayerStatistics {

	@JsonProperty("IsSetActive")
	private boolean setActive;
	@JsonProperty("Time")
	private String time;

	@JsonProperty("TotalPointsWonPercentage")
	private Long totalPointsWonPercentage;
	@JsonProperty("TotalPointsWonDividend")
	private Long totalPointsWon;
	@JsonProperty("TotalPointsWonDivisor")
	private Long totalPointsPlayed;

	@JsonUnwrapped
	private ATPServiceStatistics serviceStatistics;
	@JsonUnwrapped
	private ATPReturnStatistics returnStatistics;

	public boolean isSetActive() {
		return setActive;
	}

	public void setSetActive(final boolean setActive) {
		this.setActive = setActive;
	}

	public String getTime() {
		return time;
	}

	public void setTime(final String time) {
		this.time = time;
	}

	public Long getTotalPointsWonPercentage() {
		return totalPointsWonPercentage;
	}

	public void setTotalPointsWonPercentage(final Long totalPointsWonPercentage) {
		this.totalPointsWonPercentage = totalPointsWonPercentage;
	}

	public Long getTotalPointsWon() {
		return totalPointsWon;
	}

	public void setTotalPointsWon(final Long totalPointsWon) {
		this.totalPointsWon = totalPointsWon;
	}

	public Long getTotalPointsPlayed() {
		return totalPointsPlayed;
	}

	public void setTotalPointsPlayed(final Long totalPointsPlayed) {
		this.totalPointsPlayed = totalPointsPlayed;
	}

	public ATPServiceStatistics getServiceStatistics() {
		return serviceStatistics;
	}

	public void setServiceStatistics(final ATPServiceStatistics serviceStatistics) {
		this.serviceStatistics = serviceStatistics;
	}

	public ATPReturnStatistics getReturnStatistics() {
		return returnStatistics;
	}

	public void setReturnStatistics(final ATPReturnStatistics returnStatistics) {
		this.returnStatistics = returnStatistics;
	}
}