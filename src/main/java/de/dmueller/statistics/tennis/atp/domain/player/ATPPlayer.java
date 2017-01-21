package de.dmueller.statistics.tennis.atp.domain.player;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ATPPlayer {

	private String code;
	private String link;
	private int move;
	private String country;
	private String name;
	private int age;
	private int points;
	private int tournamentsPlayed;
	private int pointsDropping;
	private int nextBest;
	private Map<Date, Integer> rankings = new LinkedHashMap<>();

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

	public int getMove() {
		return move;
	}

	public void setMove(final int move) {
		this.move = move;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(final int points) {
		this.points = points;
	}

	public int getTournamentsPlayed() {
		return tournamentsPlayed;
	}

	public void setTournamentsPlayed(final int tournamentsPlayed) {
		this.tournamentsPlayed = tournamentsPlayed;
	}

	public int getPointsDropping() {
		return pointsDropping;
	}

	public void setPointsDropping(final int pointsDropping) {
		this.pointsDropping = pointsDropping;
	}

	public int getNextBest() {
		return nextBest;
	}

	public void setNextBest(final int nextBest) {
		this.nextBest = nextBest;
	}

	public Map<Date, Integer> getRankings() {
		return rankings;
	}

	public void setRankings(final Map<Date, Integer> rankings) {
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
		builder.append(",\n\tmove=");
		builder.append(move);
		builder.append(",\n\tcountry=");
		builder.append(country);
		builder.append(",\n\tname=");
		builder.append(name);
		builder.append(",\n\tage=");
		builder.append(age);
		builder.append(",\n\tpoints=");
		builder.append(points);
		builder.append(",\n\ttournamentsPlayed=");
		builder.append(tournamentsPlayed);
		builder.append(",\n\tpointsDropping=");
		builder.append(pointsDropping);
		builder.append(",\n\tnextBest=");
		builder.append(nextBest);
		builder.append(",\n\trankings=");
		builder.append(rankings);
		builder.append("]");
		return builder.toString();
	}
}
