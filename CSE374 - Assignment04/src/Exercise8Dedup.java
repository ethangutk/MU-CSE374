import java.util.Arrays;

public class Exercise8Dedup {
	String[] dedup(String[] a) {
		// Sorts array
		Arrays.sort(a);
		int duplicatesRemoved = 0;
		
		for (int i = 0 ; i < a.length - 1 ; i++) {
			if (a[i].compareTo(a[i + 1]) == 0) {
				// Strings equal
				// [1], [2], [3], [3], [4], [5], [6]
				for (int j = i + 1; j < a.length - duplicatesRemoved - 1 ; j++) {
					// Shifts every element down
					// [1], [2], [3], [4], [5], [6], [6]
					a[j] = a[j + 1];
				}
				duplicatesRemoved++;
			}
		}
		return Arrays.copyOf(a, a.length - duplicatesRemoved);
	}
}
