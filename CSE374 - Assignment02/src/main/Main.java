package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import structures.DoublingArray;
import structures.IncrementalArray;
import structures.RemovalArray;
import structures.Stopwatch;
import structures.SwappyArray;

public class Main {
	
	static Map<Integer, String> outputMap;
	
	
	public static void main(String[] args) throws IOException {
		// Variables 
		outputMap = new HashMap<>();
		ArrayList<Integer> newList = new ArrayList<>();
		for (int i = 0; i < 100000; i++) newList.add(i);
		RemovalArray<Integer> incrementalArray = new IncrementalArray<>();
		RemovalArray<Integer> doublingArray =    new DoublingArray<>();
		RemovalArray<Integer> rmvSwappyArray =    new SwappyArray<>(newList);
		RemovalArray<Integer> rmvDoublingArray =  new DoublingArray<>(newList);
		
		
		
		//test();
		
		removeTest(rmvSwappyArray,   "swappyremovetest.csv");
		removeTest(rmvDoublingArray, "doubleremovetest.csv");
		
		//runExperiments(incrementalArray, "incremental.csv");
		//runExperiments(doublingArray,    "doubling.csv");
	}
	
	// Test Method for my remove method (part III.2)
	public static void test() {
		ArrayList<Integer> newList = new ArrayList<>();
		for (int i = 0; i < 20; i++) newList.add(i);
		
		RemovalArray<Integer> swappyArrayTest = new SwappyArray<>(newList);
		
		System.out.println(swappyArrayTest.remove(3));
		System.out.println(swappyArrayTest.remove(6));
		
		// Array should be
		// [0, 1, 2, 19, 4, 5, 18, 7, ......]
	}
	
	
	
	// Adds numbs 1-n to RemovalArray array
	public static void removeTest(RemovalArray<Integer> array, String filename) throws IOException {
		for (int i = 10000 ; i <= 100000 ; i += 10000) {
			outputMap.put(i, ",");
		}
		
		// Runs test 10 times for 400,000 elements and reports times in map.
		for (int j = 1 ; j <= 10 ; j++) {
			System.out.println("*** Remove Test " + j + " ***");
			
			for (int i = 10000 ; i <= 100000 ; i += 10000) {
				System.out.println("- " + i + " -");
				
				double time = measureRemoveTime(array, 100000);
				outputMap.put(i, outputMap.get(i) + time + ",");
			}
			
			//Resets array for next test.
			array.clear();
		}
		
		
		// Writes to file
		FileWriter writer = new FileWriter(filename);
		writer.write("N,");
		for (int i = 1 ; i <= 10 ; i++) {
			writer.write("Repeat" + i + ",");
		}
		
		for (Map.Entry<Integer,String> entry : outputMap.entrySet()) {
			writer.write("\n" + entry.getKey() + entry.getValue());
		}
		writer.close();
	}
	
	// Adds numbs 1-n to RemovalArray array
	public static void removeFromArray(RemovalArray<Integer> array, int n) {
		for (int i = 0; i < n; i++) {
			array.removeAt(0);
		}
	}
	
	public static double measureRemoveTime(RemovalArray<Integer> array, int n) {
		Stopwatch timer = new Stopwatch();
		
		removeFromArray(array, n);
		
		return timer.elapsedTime();
	}
		
	// Adds numbs 1-n to RemovalArray array
	public static void addToArray(RemovalArray<Integer> array, int n) {
		for (int i = 1; i <= n; i++) {
			array.add(i);
		}
	}
	
	public static double measureTime(RemovalArray<Integer> array, int n) {
		Stopwatch timer = new Stopwatch();
		
		addToArray(array, n);
		
		return timer.elapsedTime();
	}
	
	public static void runExperiments(RemovalArray array, String filename) throws IOException {
		// Creates map for output
		for (int i = 20000 ; i <= 400000 ; i += 20000) {
			outputMap.put(i, ",");
		}
		
		// Runs test 10 times for 400,000 elements and reports times in map.
		for (int j = 1 ; j <= 10 ; j++) {
			System.out.println("*** Test " + j + " ***");
			
			for (int i = 20000 ; i <= 400000 ; i += 20000) {
				System.out.println("- " + i + " -");
				
				double time = measureTime(array, 20000);
				outputMap.put(i, outputMap.get(i) + time + ",");
			}
			
			//Resets array for next test.
			array.clear();
		}
		
		
		// Writes to file
		FileWriter writer = new FileWriter(filename);
		writer.write("N,");
		for (int i = 1 ; i <= 10 ; i++) {
			writer.write("Repeat" + i + ",");
		}
		
		for (Map.Entry<Integer,String> entry : outputMap.entrySet()) {
			writer.write("\n" + entry.getKey() + entry.getValue());
		}
		writer.close();
	}
}
