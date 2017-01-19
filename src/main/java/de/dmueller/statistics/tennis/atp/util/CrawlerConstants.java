package de.dmueller.statistics.tennis.atp.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.IntStream;

public class CrawlerConstants {

	public static final String WALKOVER = "(W/O)";
	public static final String RETIRED = "(RET)";

	public static final int[] YEARS = IntStream.range(1990, new GregorianCalendar().get(Calendar.YEAR)).toArray();

	public static final String ATP_WORLD_TOUR_URL = "http://www.atpworldtour.com";

}
