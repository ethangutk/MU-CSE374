
public class Exercise5SortedMin {
	// Example input
	// 15 21 35 60 3 7 9 10
	// 5 7 9 1 2 3 4
	public int exercise05(int[] a) {
		// Variables
		int middle = a[0];
		int timesSearched = 2;
		int middleIndex = 0;
		int currentIndex = a.length / 2;
				
		
		//binary search:
		// if value is bigger at the left
		// go left is value is smaller than first index
		// go right if value is smaller than first index
		
		while (true) {
			if (a[currentIndex - 1] > a[currentIndex]) {
				//index found
				return currentIndex;
			} else if (a[currentIndex] < middle) {
				//Left
				currentIndex = a.length - (a.length / timesSearched);
			} else if (a[a.length - (currentIndex)] > middle) {
				//Right
				currentIndex = (a.length / timesSearched);
			}
			timesSearched++;
		}
	}
}
