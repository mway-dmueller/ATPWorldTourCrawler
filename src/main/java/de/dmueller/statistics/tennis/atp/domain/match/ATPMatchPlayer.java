package de.dmueller.statistics.tennis.atp.domain.match;

public class ATPMatchPlayer {

	private String id;
	private String link;
	private String seed;
	private String nationality;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	public String getSeed() {
		return seed;
	}

	public void setSeed(final String seed) {
		this.seed = seed;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(final String nationality) {
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ATPPlayer [id=");
		builder.append(id);
		builder.append(", link=");
		builder.append(link);
		builder.append(", seed=");
		builder.append(seed);
		builder.append(", nationality=");
		builder.append(nationality);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}
