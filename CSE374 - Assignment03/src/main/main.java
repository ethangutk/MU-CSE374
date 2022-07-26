package main;

import org.apache.commons.lang3.tuple.Pair;

//import Pair Somehow?
//import org.apache.commons.lang3.tuple;

public class main {
	public static void main(String[] args) {
		// ----- PART III -----

		// Create int array
		int arraySize = 10;
		int[] intArray = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			intArray[i] = i;
		}

		// Call mystery method
		//Pair<Boolean, Integer> results = mystery(intArray);
		//System.out.println("Answer: " + results.getLeft() + "\nTimes Loop Ran:" + results.getRight());
		
		// ARRAY SIZE | ANSWER | NUMBER OF LOOPS | NUMBER OF LOOPS / ARRAY SIZE
		// 10		  | true   | 54				 | 5.4
		// 100        | true   | 5049			 | 50.5
		// 200        | true   | 20099			 | 100.5
		// 300        | true   | 45149			 | 150.5
		// 400        | true   | 80199			 | 200.5
		// 500        | true   | 125249			 | 250.5
		
		// 1. 
		//	As the function runs, it will take the index, double it, and add 1 to it. If 
		//	if the index is equal to the array length, it will turn into (i + 1). 
		//	Thus, the loop may seem to run O(n) by looking at the header, the loop 
		//	runs more than that. So for example, passing an array of 100 elements
		// 	in the function will have the loop run ~5,000 times. So it seems like the 
		//	loop runs O(n^2) / 2.
		
		// 2. 
		// 	The loop contains if statements. If performed, it will
		// 	increase the index amount making the loop perform in different
		//	ways. In our case, the loop will run O(n^2) /2.
		
		// 3.
		
		int inputTrick = 10;
		System.out.print("\nTimes loop ran for input (" + inputTrick + "): ");
		System.out.print(trickyhobbitses(inputTrick) + ".");
	}

	public static Pair<Boolean, Integer> mystery(int[] array) {
		int index = 1, timeLoopRan = 0;
		boolean answer = true;
		for (int i = 0; i < array.length - 1;) {
			if (index == array.length) {
				i = i + 1;
				index = i + 1;
			} else {
				if (array[i] >= array[index])
					answer = false;
				
				index = index + 1;
			}
			timeLoopRan++;
		}
		// Run Time  |  index  |  i
		// 1		 | 	1	   |  0
		// 2		 |  2	   |  0
		// 3		 | 	5	   |  0
		// 4		 |  11	   |  0
		// 5		 |  23	   |  0
		
		Pair<Boolean, Integer> returnPair = Pair.of(answer, timeLoopRan);

		return returnPair;
	}
	
	public static int trickyhobbitses(int n) {
		int index = 1, timesLoopRan = 0;
		
		for (int i = 0; i < (n-1);) {
			if (index == n) {
				i++;
				index = i;
			} else {
				index++;
			}
			timesLoopRan++;
		}
		
		return timesLoopRan;
	}
}
