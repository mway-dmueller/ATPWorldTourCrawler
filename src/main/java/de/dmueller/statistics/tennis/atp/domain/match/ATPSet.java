package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPSet {

	private final int first;
	private final int second;

	public ATPSet(final int first, final int second) {
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return String.format("%d:%d", first, second);
	}
}