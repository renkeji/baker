package utils;

import java.text.DecimalFormat;

public class Formater {
	
	public static Double formatDouble(Double number) {
		DecimalFormat df;
		if ( number == Math.floor(number) && !Double.isInfinite(number) ) {
		    df = new DecimalFormat("#");
		} else {
			df = new DecimalFormat("#.###");
		}
		return Double.parseDouble(df.format(number));
	}
	
	public static String formatDescription(String description) {
		String[] paragraphs = description.split("\n");
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		for (String p : paragraphs) {
			sb.append(p).append("<br>");
		}
		sb.append("</p>");
		return sb.toString();
	}
	
}
