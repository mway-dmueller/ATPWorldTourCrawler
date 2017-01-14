package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPPlayerStatistics {

	private String playerId;

	private ATPSetStatistics setStatistics;

	private ATPGameStatistics serviceGameStatistics;
	private ATPGameStatistics returnGameStatistics;
	private ATPGameStatistics totalGameStatistics;

	private ATPServicePointStatistics servicePointStatistics;
	private ATPReturnPointStatistics returnPointStatistics;
	private ATPPointStatistics totalPointStatistics;

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(final String playerId) {
		this.playerId = playerId;
	}

	public ATPSetStatistics getSetStatistics() {
		return setStatistics;
	}

	public void setSetStatistics(final ATPSetStatistics setStatistics) {
		this.setStatistics = setStatistics;
	}

	public ATPGameStatistics getServiceGameStatistics() {
		return serviceGameStatistics;
	}

	public void setServiceGameStatistics(final ATPGameStatistics serviceGameStatistics) {
		this.serviceGameStatistics = serviceGameStatistics;
	}

	public ATPGameStatistics getReturnGameStatistics() {
		return returnGameStatistics;
	}

	public void setReturnGameStatistics(final ATPGameStatistics returnGameStatistics) {
		this.returnGameStatistics = returnGameStatistics;
	}

	public ATPGameStatistics getTotalGameStatistics() {
		return totalGameStatistics;
	}

	public void setTotalGameStatistics(final ATPGameStatistics totalGameStatistics) {
		this.totalGameStatistics = totalGameStatistics;
	}

	public ATPServicePointStatistics getServicePointStatistics() {
		return servicePointStatistics;
	}

	public void setServicePointStatistics(final ATPServicePointStatistics servicePointStatistics) {
		this.servicePointStatistics = servicePointStatistics;
	}

	public ATPReturnPointStatistics getReturnPointStatistics() {
		return returnPointStatistics;
	}

	public void setReturnPointStatistics(final ATPReturnPointStatistics returnPointStatistics) {
		this.returnPointStatistics = returnPointStatistics;
	}

	public ATPPointStatistics getTotalPointStatistics() {
		return totalPointStatistics;
	}

	public void setTotalPointStatistics(final ATPPointStatistics totalPointStatistics) {
		this.totalPointStatistics = totalPointStatistics;
	}
}
