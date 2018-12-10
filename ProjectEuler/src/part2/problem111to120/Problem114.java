package part2.problem111to120;

import java.util.Arrays;

/**
 * Problem 114: https://projecteuler.net/problem=114
 */
public class Problem114 {

	private static final int LENGTH = 55;

	/*
	 * Main Idea: Recursively solve the problem( Dynamic Program). We could
	 * deconstruct the blocks by making decision from piece to piece. Suppose we
	 * have the "block" array of length n. The number of ways of solving the problem
	 * initially is solve[n]
	 * 
	 * -- block[0](i.e. the 1st piece) --------------------------------------------
	 * we could either go with red or black. --------------------------------------
	 * - If we go with black, then the problem is "smaller" and turns into solving
	 * the blocks of length n-1(i.e. solve[n-1]) ----------------------------------
	 * - If we go with red, then the next 2 block right after(i.e. block[1] and
	 * block[2]) must also be red block, and there are two choices again in block[3]
	 * 
	 * -- block[3]-----------------------------------------------------------------
	 * - If we go with black, then the problem is "smaller" again and turns into
	 * solve[n-4]----------------------------------------------------------------- -
	 * - If we go with red, then we go to the next block
	 * 
	 * -- till we get to base case which is block[0]
	 * 
	 * For the sake of time complexity, we will work bottom-up and add all number of
	 * ways
	 */
	public static void solve() {
		long[] ways = new long[LENGTH];

		// Base case
		ways[0] = 1;// 0 blocks - reach the end, that is 1 way
		ways[1] = 1;// 1 blocks - B
		ways[2] = 1;// 2 blocks - BB
		ways[3] = 2;// 3 blocks - BBB/RRR

		// iteratively bottom-up our number of ways
		for (int i = 4; i < LENGTH; i++) {

			// block[0] going black
			ways[i] += ways[i - 1];

			// After the initial 3 blocks which are RRR
			// The rest of the blocks could choose to be any 'ways'
			for (int k = i - 4; k >= 0; k--) {
				ways[i] += ways[k];
			}

			// all blocks are red till the end
			ways[i] += 1;
		}
		System.out.println(Arrays.toString(ways));
		System.out.println(ways[50]);
	}

	public static void main(String[] args) {

		Problem114.solve();
	}

}
