package part2.problem111to120;

import java.util.Arrays;

/**
 * Problem 113 Link: https://projecteuler.net/problem=113
 *
 */
public class Problem113 {

	// Length of the range, such that range = 10^LENGTH
	public static final int LENGTH = 101;

	// Number of DIGITS (ie. 0, 1...9)
	public static final int DIGITS = 10;

	// increasingNumber[i] represents the number of increasings below 10^(i+1)
	private static long[] NumberOfIncreasing;

	/*
	 * Main idea, instead of iterating all the number below 'range'(ie. 10^100) like
	 * Problem 112, we will directly compute the number of non-bouncy number below
	 * 'range'. Since the number could have 100 digits in it and it is too big for
	 * any primitive type(ie. int), we will use an int[] to represent the number,
	 * and every int in the array representing 1 digit.
	 * 
	 * 1. Initialize the integer array of length
	 * 'LENGTH'------------------------------
	 * 
	 * 2. Iteratively looping through all the positions in the number-----------
	 * 
	 * 3. Iteratively looping through all available digits in this position 0 - 9
	 * 
	 * Notes: 1. The number could have 0s in front, it will just represent a
	 * less-digits number(ie. 009 will just be 9) --------------------------------
	 * 2. The total number of non-bouncy = increasing + decreasing - same digits---
	 * 3. The number of increasing is the same as the number of decreasing, since we
	 * could always reverse an increasing number and it becomes an decreasing
	 * number, vice versa. Except for the number of 00987, since this represent 987
	 * and it is valid in decreasing number but invalid in increasing number, so we
	 * have to compute this group separately for decreasing number
	 */
	public static void solve() {

		// Initialize the data structure to store number of increase numbers
		NumberOfIncreasing = new long[LENGTH];
		NumberOfIncreasing[0] = 1;

		computeIncreasing();

		System.out.println(Arrays.toString(NumberOfIncreasing));

		long increasings = getIncreasing(LENGTH - 1);
		long decreasings = 0;
		for (int n = LENGTH - 1; n > 0; n--) {
			decreasings += getIncreasing(n);
		}
		long sames = 0;
		for (int n = LENGTH - 1; n > 0; n--) {
			sames += 10;
		}
		sames++;
		long total = increasings + decreasings - sames;
		System.out.println(total);
	}

	private static long getIncreasing(int celling) {
		return NumberOfIncreasing[celling];
	}

	private static void computeIncreasing() {

		// Store all the current sum
		long[] temp_sums = new long[DIGITS];

		for (int i = 1; i < LENGTH; i++) {

			// current sum and entry
			long curr_sum = NumberOfIncreasing[i - 1];

			// The first entry is the last sum
			long prev = temp_sums[0];
			temp_sums[0] = curr_sum;

			for (int i_sum = 1; i_sum < DIGITS; i_sum++) {
				// Update the current sum
				curr_sum -= prev;

				// Update the previous sum
				prev = temp_sums[i_sum];

				// insert the new sum
				temp_sums[i_sum] = curr_sum;
			}
			// Sum the array and it will be the number of increasings below 10^(i+1)
			NumberOfIncreasing[i] = Arrays.stream(temp_sums).sum();
		}
	}

	public static void main(String[] args) {
		Problem113.solve();

	}

}
