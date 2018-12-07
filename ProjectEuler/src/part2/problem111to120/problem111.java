package part2.problem111to120;

import java.util.ArrayList;
import java.util.List;

import algorithm.PrimeBelowN;

/**
 * Problem 111 https://projecteuler.net/problem=111
 *
 */
public class Problem111 {

	// The problem asking to find the appropriate primes between 1e9 and 1e10
	public static final double range = 1e10;
	// Number of digits available
	public static final int digits = 10;

	/*
	 * 1. Need to time the algorithm3. Write function that take number of flexible
	 * position 4. recursive calculate the output
	 */
	public static void solve() {
		int n = (int) Math.sqrt(range);

		// All primes below n
		PrimeBelowN.setPrimes(n);
		List<Integer> primes = PrimeBelowN.getPrimes();

		for (int d = 0; d < 10; d++) {
			// The flexibility of position in the number starting at 1
			int flexibility = 0;
			List<Long> ret;
			do {
				flexibility++;
				ret = findPrime(primes, flexibility, d);
			} while (ret.isEmpty() && flexibility < digits);
			System.out.println(d + "-" + ret.size());
		}
	}

	private static List<Long> findPrime(List<Integer> primes, int flexibility, int d) {
		List<Long> ret = new ArrayList<Long>();

		return ret;
	}

	private static List<Long> recurHelper(List<Integer> primes, int flexibility, int d, int[] number) {
		return null;
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
		// problem111.solve();
		System.out.println(Problem111.buildNumber(number));

	}
}
