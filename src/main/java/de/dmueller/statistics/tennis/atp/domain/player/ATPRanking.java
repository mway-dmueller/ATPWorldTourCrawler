package de.dmueller.statistics.tennis.atp.domain.player;

import java.util.Date;

public class ATPRanking {

	private Date rankDate;
	private int move;
	private Integer age;
	private int points;
	private int tournamentsPlayed;
	private int pointsDropping;
	private int nextBest;
	private int ranking;

	public Date getRankDate() {
		return rankDate;
	}

	public void setRankDate(final Date rankDate) {
		this.rankDate = rankDate;
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
