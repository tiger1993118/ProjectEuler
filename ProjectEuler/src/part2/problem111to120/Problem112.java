package part2.problem111to120;

/**
 * Problem 112 Link: https://projecteuler.net/problem=112
 *
 */
public class Problem112 {

	/*
	 * 
	 * The main function we have to write is checkBouncy, which check whether the
	 * current number is bouncy. We starting from the left hand of the number and
	 * iterate till the rightmost digit. We have to be careful is that, assuming the
	 * number is not bouncy number at first, then we don't know if it will be
	 * increasing, decreasing or neither(ie. like 2222). So we started to figure it
	 * out until we see movement from digits(ie. increasing, decreasing) and then
	 * starting from here, we could decide if it is a bouncy number.
	 */
	public static void solve() {

		int bouncy = 0;
		double percent = 0;
		int n = 0;

		// Find the percentage of bouncy number is exactly 99%
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
