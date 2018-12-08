package part2.problem111to120;

/**
 * Problem 113 Link: https://projecteuler.net/problem=113
 *
 */
public class Problem113 {

	public static final int LENGTH = 50;

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
	 * 2. Recursively looping through all the positions in the number---------------
	 * 
	 * 3. Iteratively looping through all available digits in this position 0 - 9
	 * 
	 * Notes: 1. The number could have 0s in front, it will just represent a
	 * less-digits number(ie. 009 will just be 9) --------------------------------
	 * 2. The total number of non-bouncy = increasing + decreasing - same digits
	 */
	public static void solve() {

		int[] number = new int[LENGTH];

		int increasings = recurIncreasing(number, 0, 0);
		System.out.println(increasings);
		// int decreasings = recurDecreasing(number, 0, 9);
		// int same_digits
	}

	public static int recurIncreasing(int[] number, int position, int min) {

		int total = 0;

		if (position == LENGTH) {// We have a complete increasing number
			return 1;
		} else {// We keep constructing the number and set digit at current position

			// Iterating all the digits from 'min' to 9, and set it at current position
			for (int n = min; n < 10; n++) {
				number[position] = n;
				total += recurIncreasing(number, position + 1, n);
			}
		}

		return total;
	}

	public static void main(String[] args) {
		Problem113.solve();

	}

}
