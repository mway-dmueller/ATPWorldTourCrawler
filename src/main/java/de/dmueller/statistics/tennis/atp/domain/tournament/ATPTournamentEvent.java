package de.dmueller.statistics.tennis.atp.domain.tournament;

import java.util.Date;
import java.util.Set;

import de.dmueller.statistics.tennis.atp.domain.match.ATPMatch;

public class ATPTournamentEvent {

	private ATPTournament tournament;
	private int year;
	private Date fromDate;
	private Date toDate;
	private ATPCourt court;
	private ATPTotalFinancialCommitment totalFinancialCommitment;
	private Set<ATPMatch> matches;

	public ATPTournament getTournament() {
		return tournament;
	}

	public void setTournament(final ATPTournament tournament) {
		this.tournament = tournament;
	}

	public int getYear() {
		return year;
	}

	public void setYear(final int year) {
		this.year = year;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(final Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(final Date toDate) {
		this.toDate = toDate;
	}

	public ATPCourt getCourt() {
		return court;
	}

	public void setCourt(final ATPCourt court) {
		this.court = court;
	}

	public ATPTotalFinancialCommitment getTotalFinancialCommitment() {
		return totalFinancialCommitment;
	}

	public void setTotalFinancialCommitment(final ATPTotalFinancialCommitment totalFinancialCommitment) {
		this.totalFinancialCommitment = totalFinancialCommitment;
	}

	public Set<ATPMatch> getMatches() {
		return matches;
	}

	public void setMatches(final Set<ATPMatch> matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("ATPTournamentEvent [\n\t").append("tournament=").append(tournament)
				.append(",\n\tyear=").append(year).append(",\n\tfromDate=").append(fromDate).append(",\n\ttoDate=")
				.append(toDate).append(",\n\tcourt=").append(court).append(",\n\ttotalFinancialCommitment=")
				.append(totalFinancialCommitment).append(",\n\tmatches=").append(matches).append("]").toString();
	}
}
