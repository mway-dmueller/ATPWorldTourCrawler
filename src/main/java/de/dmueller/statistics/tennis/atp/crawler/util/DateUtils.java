package de.dmueller.statistics.tennis.atp.crawler.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

	public static final Calendar getLastMonday() {
		final GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
		final int value = calendar.get(Calendar.DAY_OF_WEEK);
		if (value == 0) {
			calendar.add(Calendar.DAY_OF_WEEK, -6);
		} else {
			calendar.add(Calendar.DAY_OF_WEEK, Calendar.MONDAY - value);
		}

		return calendar;
	}
}
