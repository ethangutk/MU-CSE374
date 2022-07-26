import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class Exercise4Pair <E extends Comparable<?super E>> {
	//
	public Pair<Integer,Integer> exercise04(int[] arrayInput, int x) {
		// Turn array into list
		List<Integer> list = Arrays.stream(arrayInput).boxed().collect(Collectors.toList());
		int index = Collections.binarySearch(list, x);

		if (index > -1) {
			Pair<Integer, Integer> returnPair = Pair.of(index - 1, arrayInput.length - index - 1);
			return returnPair;
		} else {
			return null;
		}
	}
	
}
