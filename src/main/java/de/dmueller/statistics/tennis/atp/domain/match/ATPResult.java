package de.dmueller.statistics.tennis.atp.domain.match;

import java.util.Set;

public class ATPResult {

	private Set<ATPSet> sets;
	private boolean walkover;

	public Set<ATPSet> getSets() {
		return sets;
	}

	public void setSets(final Set<ATPSet> sets) {
		this.sets = sets;
	}

	public boolean isWalkover() {
		return walkover;
	}

	public void setWalkover(final boolean walkover) {
		this.walkover = walkover;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ATPResult [sets=");
		builder.append(sets);
		builder.append(", walkover=");
		builder.append(walkover);
		builder.append("]");
		return builder.toString();
	}
}
