package de.dmueller.statistics.tennis.atp.crawler.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class PlayerUtils {

	/*
	 * pattern: /en/players/<player-name>/<player-id>/overview
	 */
	private static final Pattern PLAYER_OVERVIEW_PATTERN = Pattern.compile("/en/players/([\\w\\-]+)/([\\w]+)/overview");

	private PlayerUtils() {
		assert false : "not instantiable";
	}

	public static final String extractPlayerId(final String link) {

		final Matcher matcher = PLAYER_OVERVIEW_PATTERN.matcher(link);
		if (!matcher.find()) {
			return null;
		}

		return StringUtils.upperCase(matcher.group(2));
	}
}
