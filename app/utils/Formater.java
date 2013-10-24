package utils;

public class Formater {
	
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
