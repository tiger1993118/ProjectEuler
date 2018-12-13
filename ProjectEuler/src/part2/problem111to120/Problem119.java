package part2.problem111to120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithm.Digits;

/*
 * Problem 119: https://projecteuler.net/problem=119
 */
public class Problem119 {

	private static final int DIGITS = 9;

	private static final int LENGTH = 9 * DIGITS + 1;

	/*
	 * Main Idea: Observed from the 2nd and 10th number in the list, We could sort
	 * of having a sense of how many digits the answer could be and how many powers
	 * it needs. So we define a range of 9-digits number, and we could compute that
	 * 9-digits number will have digit_sum within range 1 and 9*9(i.e. 999999999).
	 * We compute the range from 1 to 9*9 of power 1 to 10, and check the
	 * conditions. Lastly sort them out.
	 * 
	 */
	public static void solve() {

		// Store all the numbers to the power of
		long[] powers = new long[LENGTH];

		// Each index representing the base number
		for (int i = 2; i < LENGTH; i++) {
			powers[i] = i;
		}

		// Store the number that we found
		List<Long> list = new ArrayList<>();

		// Keep powering the base up
		for (int time = 2; time < 11; time++) {
			for (int i = 2; i < LENGTH; i++) {
				powers[i] = powers[i] * i;

				if (Digits.digitSum(Long.toString(powers[i])) == i) {
					// System.out.println(powers[i]);
					list.add(powers[i]);
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.get(29));
	}

	public static void main(String[] args) {
		Problem119.solve();
	}

}
