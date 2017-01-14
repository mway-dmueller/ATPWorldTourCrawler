package de.dmueller.statistics.tennis.atp.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TournamentArchiveForYearWrapper implements Serializable {
	private static final long serialVersionUID = -5880168737077837553L;

	private List<TournamentArchiveForYear> tournaments;

	public List<TournamentArchiveForYear> getTournaments() {
		return tournaments;
	}

	public void setTournaments(final List<TournamentArchiveForYear> tournaments) {
		this.tournaments = tournaments;
	}
}
