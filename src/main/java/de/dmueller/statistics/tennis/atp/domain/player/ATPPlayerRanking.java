package de.dmueller.statistics.tennis.atp.domain.player;

import java.util.Date;

public class ATPPlayerRanking {

	private String code;
	private String link;
	private Date rankDate;
	private String name;
	private String country;
	private int move;
	private Integer age;
	private int points;
	private int tournamentsPlayed;
	private int pointsDropping;
	private int nextBest;
	private int ranking;

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

	public Date getRankDate() {
		return rankDate;
	}

	public void setRankDate(final Date rankDate) {
		this.rankDate = rankDate;
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

	public int getMove() {
		return move;
	}

	public void setMove(final int move) {
		this.move = move;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(final Integer age) {
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

	public int getRanking() {
		return ranking;
	}

	public void setRanking(final int ranking) {
		this.ranking = ranking;
	}
}
