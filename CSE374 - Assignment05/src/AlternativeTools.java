import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.tuple.Pair;


public class AlternativeTools <E extends Comparable<?super E>> {	
	
	
	
	// Part 2 - Question 1
	// Time complexity of N^2
	// Space complexity of 1
	public void getNestedUnique(E[] array, int n) {
		boolean isUnique = true;
		int timesPrinted = 0;
		for (int i = 0 ; i < array.length ; i++) {
			for (int j = 0 ; i < array.length ; j++) {
				// Checks if the element is a duplicate;
				if (array[i].equals(array[j]) && i != j) {
					isUnique = false;
					break;
				}
			}
			
			// Prints if the element is unique;
			if (isUnique) {
				System.out.print(array[i] + " ");
				timesPrinted++;
				if (timesPrinted == n) break;
			}
		}
	}
	
	
	
	
	// Part 2 - Question 2
	// Time complexity of n log(n) + (n)
	// Space complexity of 1
	public void getSortedUnique(E[] array, int n) {
		Arrays.sort(array);
		E currentElement;
		int numOfCurrentElements = 0;
		int timesPrinted = 0;
		
		for (int i = 0 ; i < array.length - 1 ; i++) {
			currentElement = array[i];
			// Iterate through the loop until the element changes.
			while ((i + 1) < array.length || array[i + 1].equals(currentElement) ) { 	
				numOfCurrentElements++;
				i++;
			}
			
			// If there was only one element, print the element
			if (timesPrinted < n && numOfCurrentElements == 0) {
				System.out.print(" " + currentElement.toString());
				timesPrinted++;
			}
			// If the number of elements printed equals n then break.
			if (timesPrinted == n) break;
			numOfCurrentElements = 0;
		}
	}
	
	
	
	
	// Part 2 - Question 3
	// Time complexity of n^2 + n
	// Space complexity of n
	public void getMapUnique(E[] array, int n) {
		// Loop to map elements
		HashMap<E, Integer> arrayMapped = new HashMap<>();
		
		for (int i = 0 ; i < array.length ; i++) {
			// For every element in the array, increment it in a map
			if (arrayMapped.containsKey(array[i])) {
				arrayMapped.put(array[i], arrayMapped.get(array[i]) + 1);
			}
			else arrayMapped.put(array[i], 1);
		}
		
		// Create a map iterator for printing
		Iterator<Entry<E, Integer>> iterator = arrayMapped.entrySet().iterator();
		int timesPrinted = 0;
		
		// Loop to print n unique elements
		while (iterator.hasNext()) {
			Entry<E, Integer> entry = iterator.next();
			
			// Checks if it is unique (quantity of 1)
			if (entry.getValue() == 1) {
				timesPrinted++;
				System.out.print(" " + entry.getKey().toString());
			}
			
			// If number of unique elements requested have
			// been printed, then break the loop
			if (timesPrinted == n) break;
		}
	}
	
	
	
	// Part 2 - Question 4
	
	
	public void getHeapUnique(E[] array, int n) {
		// Loop to map elements
		HashMap<E, Pair<Integer, Integer>> arrayMapped = new HashMap<>();
		// Pair<Boolean, Integer> returnPair = Pair.of(answer, timeLoopRan);
		
		for (int i = 0 ; i < array.length ; i++) {
			// For every element in the array, increment it in a map
			if (arrayMapped.containsKey(array[i])) {
				Pair<Integer, Integer> oldPair = arrayMapped.get(array[i]);
				Pair<Integer, Integer> newPair = 
						new Pair.of(oldPair.left(), oldPair.right() + 1);
				arrayMapped.put(array[i], newPair);
			}
			else arrayMapped.put(array[i], new Pair.of(i, 1));
		}
		
		// Create a map iterator for printing
		Iterator<Entry<E, Integer>> iterator = arrayMapped.entrySet().iterator();
		int timesPrinted = 0;
		
		// Loop to print n unique elements
		while (iterator.hasNext()) {
			Entry<E, Integer> entry = iterator.next();
			
			// Checks if it is unique (quantity of 1)
			if (entry.getValue() == 1) {
				timesPrinted++;
				System.out.print(" " + entry.getKey().toString());
			}
			
			// If number of unique elements requested have
			// been printed, then break the loop
			if (timesPrinted == n) break;
		}
	}
}
