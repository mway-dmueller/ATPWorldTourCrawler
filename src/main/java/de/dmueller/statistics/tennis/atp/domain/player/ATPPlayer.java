package de.dmueller.statistics.tennis.atp.domain.player;

import java.util.ArrayList;
import java.util.List;

public class ATPPlayer {

	private String code;
	private String link;
	private String name;
	private String country;
	private List<ATPRanking> rankings = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getLink() {
		return link;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public List<ATPRanking> getRankings() {
		return rankings;
	}

	public void setRankings(final List<ATPRanking> rankings) {
		this.rankings = rankings;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ATPPlayer [");
		builder.append("\n\tcode=");
		builder.append(code);
		builder.append(",\n\tlink=");
		builder.append(link);
		builder.append(",\n\tcountry=");
		builder.append(country);
		builder.append(",\n\tname=");
		builder.append(name);
		builder.append(",\n\trankings=");
		builder.append(rankings);
		builder.append("]");
		return builder.toString();
	}
}
