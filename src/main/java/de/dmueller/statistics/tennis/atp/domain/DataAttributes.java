package de.dmueller.statistics.tennis.atp.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataAttributes implements Serializable {
	private static final long serialVersionUID = 4076219425305788378L;

	@JsonProperty("descriptor")
	private String descriptor;

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(final String descriptor) {
		this.descriptor = descriptor;
	}
}
