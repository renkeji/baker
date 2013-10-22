package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameExtractor {
	
	public static String[] extractName(String header) {
		String[] strings = new String[2];
		String regexp = "^(.*) (\\d+|3-Year Avg.)$";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(header);
		while (matcher.find()) {
			strings[0] = matcher.group(1).trim();
			strings[1] = matcher.group(2).trim();
		}
		return strings;
	}
	
}
