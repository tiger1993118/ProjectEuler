package part2.problem111to120;

import java.util.List;

import algorithm.PrimeBelowN;

/**
 * Problem 111 https://projecteuler.net/problem=111
 *
 */
public class problem111 {

	// The problem asking to find the appropriate primes between 1e9 and 1e10
	public static final double range = 1e10;

	/*
	 * 1. Need to time the algorithm 2. Find all the primes below
	 * 10_000_000_000^(1/2) 3. Write function that take number of flexible position
	 * 4. recursive calculate the output
	 */
	public static void solve() {
		int n = (int) Math.sqrt(range);// square root of 10_000_000_000

		// All primes below n
		PrimeBelowN.setPrimes(n);
		List<Integer> primes = PrimeBelowN.getPrimes();

	}

	public static void main(String[] args) {
		problem111.solve();
	}
}
