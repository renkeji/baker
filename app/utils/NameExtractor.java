package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import play.Logger;

public class NameExtractor {
	
	private static final Logger logger = new Logger();
	
	public static String[] extractName(String header) {
		String[] strings = new String[2];
		String regexp = "^(.*) (\\d+|3-Year Avg.)\\s*$";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(header);
		while (matcher.find()) {
			strings[0] = matcher.group(1).trim();
			strings[1] = matcher.group(2).trim();
		}
		return strings;
	}
	
	public static void test() {
		String token = "Trading Address - Country";
		if (token.matches(".*Country.*")) {
			logger.warn("Matched!");
		} else {
			logger.warn("Not Matched!");
		}
	}
	
}
