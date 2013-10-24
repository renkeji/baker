package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculateQuartiles {

	public static List<Double> calculateQuartiles(List<Double> data) {
		List<Double> result = new ArrayList<Double>();
		List<Double> copy = new ArrayList<Double>();
		copy.addAll(data);
		Collections.sort(copy);
		int dataSize = copy.size() - 1;
		int lowerQuartileIndex = (int)(Math.ceil(dataSize * 0.25));
		int medianIndex = (int)(dataSize/2);
		int upperQuartileIndex = (int)(Math.ceil(dataSize * 0.75));
		result.add(copy.get(lowerQuartileIndex));
		result.add(copy.get(medianIndex));
		result.add(copy.get(upperQuartileIndex));
		return result;
	}
	
}
