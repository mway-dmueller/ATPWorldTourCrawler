package de.dmueller.statistics.tennis.atp.domain.tournament;

public enum ATPCourt {
	HARD("Hard"), CLAY("Clay"), GRASS("Grass"), CARPET("Carpet"), UNKNOWN("");

	private final String value;

	private ATPCourt(final String value) {
		this.value = value;
	}

	public static ATPCourt fromValue(final String value) {
		for (final ATPCourt court : values()) {
			if (court.getValue().equalsIgnoreCase(value)) {
				return court;
			}
		}

		return UNKNOWN;
	}

	public String getValue() {
		return value;
	}
}