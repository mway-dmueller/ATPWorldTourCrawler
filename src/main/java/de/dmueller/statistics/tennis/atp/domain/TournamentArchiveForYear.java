package de.dmueller.statistics.tennis.atp.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TournamentArchiveForYear implements Serializable {
	private static final long serialVersionUID = 7389952072930297895L;

	@JsonProperty("Key")
	private String key;
	@JsonProperty("Value")
	private String value;
	@JsonProperty("DataAttributes")
	private DataAttributes dataAttributes;

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public DataAttributes getDataAttributes() {
		return dataAttributes;
	}

	public void setDataAttributes(final DataAttributes dataAttributes) {
		this.dataAttributes = dataAttributes;
	}
}
