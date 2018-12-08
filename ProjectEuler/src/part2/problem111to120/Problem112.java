package part2.problem111to120;

/**
 * Problem 112 Link: https://projecteuler.net/problem=112
 *
 */
public class Problem112 {

	/*
	 * Main Idea: Since we are finding the bouncy numbers that are exactly 99%, then
	 * the total number we are looking at must be a multiplier of 100, so that we
	 * iterate over 100 every total number. We started with 22200 in our case, and
	 * add up the bouncy number since.
	 * 
	 * 1. Starting with 22200 and calculate the bouncy number below 22200 --------
	 * 
	 * 2. In every 100 number, add up any new bouncy number to the sum -----------
	 * 
	 * 3. When we calculate the bouncy number within these 100 numbers, we divide it
	 * into two cases -------------------------------------------------------------
	 * 
	 * 3a. If the prefix number(ie. x in x00) is a bouncy number already, then all
	 * 100 numbers will be bouncy as well ----------------------------------------
	 * 
	 * 3b. otherwise, then we calculate bouncy number, for which we only need to
	 * look at the only digit prior to 00 (ie. y in xy00, and y is only a digit).
	 * Depending on increasing or decreasing scenario, we will compute the
	 * non-bouncy number.
	 */
	public static void solve() {

		int bouncy = 0;
		double percent = 0;
		int n = 0;

		while (percent != 99) {

			n++;
			if (checkBouncy(n) == -10) {
				bouncy++;
			}

			percent = (double) bouncy * 100 / n;
		}
		System.out.println(bouncy + " - " + n + " - " + percent);
	}

	/*
	 * Return -10 if the number is bouncy --------------------------------------
	 * Return 1 if the number is increasing ------------------------------------
	 * Return -1 if the number is decreasing -----------------------------------
	 * Return 0 if the number is neither bouncy, increasing nor decreasing(ie.
	 * Having all the same digits)
	 */
	public static int checkBouncy(long number) {

		int mask = 0;
		String str = String.valueOf(number);
		char prev = str.charAt(0);
		for (char curr : str.toCharArray()) {

			// Don't know it is increasing or decreasing yet
			if (mask == 0) {

				if (curr > prev) {
					// Initially increasing
					mask = 1;

				} else if (curr < prev) {
					// Initially decreasing
					mask = -1;
				}
			} else if (mask == 1 && (curr >= prev)) {
			} else if (mask == -1 && (curr <= prev)) {
			} else {
				// The number is bouncy
				return -10;
			}
			prev = curr;
		}

		// The number have all the same digits
		return mask;

	}

	public static void main(String[] args) {

		Problem112.solve();
	}

}
