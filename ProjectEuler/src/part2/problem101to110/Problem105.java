package part2.problem101to110;

import java.util.Arrays;
import java.util.stream.IntStream;

import algorithm.Converter;
import algorithm.File;

public class Problem105 {
	
	public static void solve() {
		int sum = 0;
		// Read File
		String[][] files = File.readFile("raw/p105_sets.txt", "\n", ",");
		int[][] sets = Converter.parseIntArray(files);
		
		// Second Condition
		for(int[] set: sets) {
			Arrays.sort(set);// Sort it
			if(check_second(set)) {// Check second condition
				if(check_first(set)) {
					sum += IntStream.of(set).sum();
				}
			}
		}
		System.out.println(sum);
	}
	
	// Return True if the set satisfied the first condition
	private static boolean check_first(int[] set) {
		for(int i = 2; i <= (set.length/2); i++) {
			// Check the first condition for current size of subset
			if(!rec_check_subset(set, new Integer[i], new Integer[i], 0, 0, i)) {
				return false;
			}
		}
		return true;
	}
	
	// Recursively find subset A and B of size size, and compare SA and SB
	private static boolean rec_check_subset(int[] set, Integer[] indexA, Integer[] indexB, int layerA, int layerB, int size) {
		if(layerA == size && layerB == size) {// Compare the subset sum of A and B

			int SA = 0, SB = 0;
			for(int i = 0; i < size; i++) {// Sum of subset A and sum of subset B
				SA += set[indexA[i]];
				SB += set[indexB[i]];
			}
			if(SA == SB) {// Did not satisfy first condition, return false
				System.out.print("A-");
				System.out.println(Arrays.toString(indexA));
				System.out.print("B-");
				System.out.println(Arrays.toString(indexB));
				return false;
			}
		}
		else if(layerA == size) {// Determine subset B after subset A is all set
			int start;
			if(layerB == 0) {// First 
				start = 0;
			}else {// Last value + 1
				start = indexB[layerB-1] + 1;
			}
			for(int i = start; i < set.length; i++) {// Loop the value 
				if(!(Arrays.asList(indexA).contains(i))) {
					indexB[layerB] = i;
					if(!rec_check_subset(set, indexA, indexB, layerA, layerB+1, size)) {// If one constraint is failed, return false
						return false;
					}
				}
			}
		}else {// Determine subset A first
			int start;
			if(layerA == 0) {// First 
				start = 0;
			}else {// Last value + 1
				start = indexA[layerA-1] + 1;
			}
			int limit = set.length - (size - indexA.length);
			for(int i = start; i < limit; i++) {// Loop the value 
				indexA[layerA] = i;
				if(!rec_check_subset(set, indexA, indexB, layerA+1, layerB, size)) {// If one constraint is failed, return false
					return false;
				}
			}
		}
		return true;
	}

	// Return True if the set satisfied the second condition
	public static boolean check_second(int[] set) {
		int left_sum = set[0];
		int right_sum = 0;
		for (int i = 1; i <= set.length / 2; i++) {
			left_sum += set[i];
			right_sum += set[set.length - i];
			if (left_sum <= right_sum) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		Problem105.solve();
	}

}
