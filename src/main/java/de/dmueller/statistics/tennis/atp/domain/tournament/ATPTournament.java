package de.dmueller.statistics.tennis.atp.domain.tournament;

public class ATPTournament {

	private String id;
	private String descriptor;
	private String name;
	private String city;
	private String country;

	public ATPTournament(final String id, final String descriptor) {
		this.id = id;
		this.descriptor = descriptor;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(final String descriptor) {
		this.descriptor = descriptor;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return new StringBuilder("ATPTournament [").append("id=").append(id).append(", name=").append(name)
				.append(", city=").append(city).append(", country=").append(country).append("]").toString();
	}
}
