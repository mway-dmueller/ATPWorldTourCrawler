package de.dmueller.statistics.tennis.atp.domain.tournament;

public class ATPTournament {

	private String code;
	private String descriptor;
	private String name;
	private String city;
	private String country;

	public ATPTournament(final String code, final String descriptor) {
		this.code = code;
		this.descriptor = descriptor;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
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
		return new StringBuilder("ATPTournament [").append("code=").append(code).append(", name=").append(name)
				.append(", city=").append(city).append(", country=").append(country).append("]").toString();
	}
}
