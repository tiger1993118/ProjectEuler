package part2.problem111to120;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 115: https://projecteuler.net/problem=115
 *
 */
public class Problem115 {

	// Least length of units
	private static final int UNITS = 50;

	/*
	 * Main Idea: Similar to Problem 114, we will use dynamic programming and work
	 * our solution bottom-up. Two differences I will make here is: Firstly, we will
	 * use a list to keep track of the number of ways to solve blocks of length n,
	 * since the question asking for the length and it is undecidable, we cannot
	 * initialize it with array as Problem 114. Secondly, when breaking up the
	 * problem and blocks of length n, I will make the least length of units a
	 * parameter, instead of a static number like 3 in Problem 114, make the subtle
	 * changes in the recursive algorithm correspondingly.
	 * 
	 * 1. Use Problem 114 algorithm and verify the value F(3, 29) and F(3, 30) to
	 * make sure our algorithm is correct. ----------------------------------------
	 * 2. Change the data Structure from array to list ----------------------------
	 * 3. Add the least number of units as parameters and make some subtle changes
	 * in recursive function.
	 *
	 */
	public static void solve() {
		List<Integer> ways = new ArrayList<Integer>();

		// Base case
		// Block of length from 0 to UNITS-1, they all only have 1 way: all Bs
		for (int i = 0; i < UNITS; i++) {
			ways.add(i, 1);
		}
		// Block of length UNITS have 2 ways: all Rs and all Bs
		ways.add(UNITS, 2);

		// iteratively bottom-up our number of ways
		// Keep computing ways until it exceeds one Million
		while (ways.get(ways.size() - 1) <= 1_000_000) {

			// Current length of block
			int i = ways.size();

			// Current total number of ways
			int total = 0;

			// block[0] going black
			total += ways.get(i - 1);

			// After the initial UNITS blocks which are RRR
			// The rest of the blocks could choose to be any 'ways'
			for (int k = i - (UNITS + 1); k >= 0; k--) {
				total += ways.get(k);
			}

			// all blocks are red till the end
			total += 1;

			ways.add(total);
		}

		System.out.println(ways.size() - 1);
	}

	public static void main(String[] args) {
		Problem115.solve();
	}

}
