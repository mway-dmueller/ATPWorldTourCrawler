package de.dmueller.statistics.tennis.atp.domain.tournament;

public class ATPTotalFinancialCommitment {

	private String currency;
	private int value;

	public ATPTotalFinancialCommitment() {

	}

	public ATPTotalFinancialCommitment(final String currency, final int value) {
		this.currency = currency;
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("TotalFinancialCommitment [currency=");
		builder.append(currency);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
}