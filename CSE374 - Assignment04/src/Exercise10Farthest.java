import org.apache.commons.lang3.tuple.Pair;

public class Exercise10Farthest {
	public Pair<Double, Double> compare(double[] array) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		
		for (double e : array) {
			// If element is larger than current max
			// change current max
			if (e > max) {
				max = e;
			}
			
			// If element is larger than current min
			// change current min
			if (e < min) {
				min = e;
			}
		}
		
		Pair<Double, Double> returnPair = Pair.of(min, max);
		
		return returnPair;
	}
}
