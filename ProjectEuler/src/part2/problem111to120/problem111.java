package part2.problem111to120;

import java.util.ArrayList;
import java.util.List;

import algorithm.PrimeBelowN;

/**
 * Problem 111 https://projecteuler.net/problem=111
 *
 */
public class Problem111 {

	// Number of digits available
	public static final int digits = 10;
	// The problem asking to find the appropriate primes between 1e9 and 1e10
	public static final double range = Math.pow(10, digits);

	public static void solve() {
		// Only have to find all the primes smaller than sqaure root of range
		int n = (int) Math.sqrt(range);

		// All primes below n
		PrimeBelowN.setPrimes(n);
		List<Integer> primes = PrimeBelowN.getPrimes();
		long sum = 0;

		for (int d = 0; d < 10; d++) {
			List<Long> ret = findPrime(primes, d);
			System.out.println(d + "-" + ret.size());
			for (long p : ret)
				sum += p;
		}

		System.out.println(sum);
	}

	private static List<Long> findPrime(List<Integer> primes, int digit) {

		// Initially every positions are all digit 'd', with length 'digit'
		int[] init = new int[digits];
		for (int i = 0; i < init.length; i++) {
			init[i] = digit;
		}

		// The list of required primes
		List<Long> ret = new ArrayList<Long>();

		// Since we need to find the prime with most positions are repeated
		// The flexibility of position in the number starting at 1
		for (int flex = 1; ret.isEmpty() && flex < digits; flex++) {
			ret = recurHelper(primes, digit, init, flex, 0);
		}

		return ret;
	}

	private static List<Long> recurHelper(List<Integer> primes, int digit, int[] number, int flexibility, int level) {

		List<Long> ret = new ArrayList<Long>();

		// If there is no flexibility, we will check the current number whether it is
		// prime
		if (flexibility == 0) {

			// Build the number
			long current = buildNumber(number);

			// Check if the number is the multiplier of any primes
			for (int prime : primes) {
				if (current % prime == 0) {// Composite
					return ret;
				}
			}
			ret.add(current);

		} else {
			// Current digit is set, so deduct 1 from flexibility
			flexibility -= 1;

			// Looping through all the available positions in the number
			for (int l = level; l < digits - flexibility; l++) {

				// If the position of the digit is at 0, it cannot be 0
				int n = (l == 0) ? 1 : 0;
				// Loop through all the possible digits at current position
				for (; n < 10; n++) {

					// The digit cannot be the same as the repeated digit
					if (n != digit) {
						number[l] = n;
						ret.addAll(recurHelper(primes, digit, number, flexibility, l + 1));
					}
				}
				// Reset the digit back to the repeated digit
				number[l] = digit;

				// 0 cannot be at 0th position
				if (digit == 0 && l == 0) {
					return ret;
				}
			}
		}
		return ret;
	}

	/*
	 * Concatenate an array of integer to one long number, ignore the 0's at front
	 */
	public static long buildNumber(int[] number) {
		long ret = 0L;
		StringBuilder sb = new StringBuilder();
		for (int n : number) {
			sb = sb.append(n);
		}
		ret = Long.valueOf(sb.toString());
		return ret;
	}

	public static void main(String[] args) {
		Problem111.solve();

	}
}
