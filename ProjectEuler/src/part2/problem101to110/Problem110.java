package part2.problem101to110;

import java.math.BigInteger;
import java.util.List;

import algorithm.Prime;

/*
 * In the following equation x, y, and n are positive integers.

1/x + 1/y =	1/n

It can be verified that when n = 1260 there are 113 distinct solutions 
and this is the least value of n for which the total number of distinct solutions exceeds one hundred.

What is the least value of n for which the number of distinct solutions exceeds four million?

NOTE: This problem is a much more difficult version of Problem 108 
and as it is well beyond the limitations of a brute force approach it requires a clever implementation.
 */
public class Problem110 {

	/*
	 * A simple test help us validate our guess, that says, If a number n = a_1 *a_2
	 * *... * a_m , for which a_1 to a_m are all distinct prime number, then this
	 * number has a constant number of distinction solution k, for all Integer n
	 * 
	 * And the latter test not just limited to product of distinct prime number, but
	 * extended to all integer numbers s.t. n (a_1)^p1 * (a_2)^p2 *... * (a_m)^pm
	 * 
	 * 
	 */
	public static void simpleTest() {

		Prime.setPrimes(30);
		List<Integer> primes = Prime.getPrimes();

		// n = a_1 * a_2 * a*3
		for (int a = 0; a < (primes.size() - 2); a++) {
			for (int b = a + 1; b < primes.size() - 1; b++) {
				for (int c = b + 1; c < primes.size(); c++) {
					int n = primes.get(a) * primes.get(b) * primes.get(c);
					System.out.println(n + " - " + simpleCounter(n));
				}
			}
		}

		// Not Just Distinct prime divisor
		// n = a_1 * a_1 * a_2 * a_2 * a*3
		for (int a = 0; a < (primes.size() - 2); a++) {
			for (int b = a + 1; b < primes.size() - 1; b++) {
				for (int c = b + 1; c < primes.size(); c++) {
					int n = primes.get(a) * primes.get(a) * primes.get(a) * primes.get(b) * primes.get(b)
							* primes.get(c);
					System.out.println(n + " - " + simpleCounter(n));
				}
			}
		}
	}

	public static int simpleCounter(int n) {
		int ret = 0;

		// For all pairs of solutions s.t. x < y, then (n+1) < x < 2*n
		for (int x = (n + 1); x <= 2 * n; x++) {
			BigInteger numer = BigInteger.valueOf(x).multiply(BigInteger.valueOf(n));// x*n
			BigInteger denomin = BigInteger.valueOf(x - n);// x-n
			if ((numer.mod(denomin).equals(BigInteger.ZERO))) {
				ret++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Problem110.simpleTest();

	}

}
