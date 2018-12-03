package part2.problem101to110;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import algorithm.Prime;
import algorithm.Prime2;

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

	public static void solve(int limit) {

		int n = findNumber(limit);

		int m = n - 3;

		// Get the first m primes
		Prime2 p2 = new Prime2(m);
		int[] primes = p2.getPrimes();
		System.out.println(Arrays.toString(primes));

		// Since we know the product of m primes already has solutions exceeding
		// 'limit', then we will try less primes

		int power = (int) (Math.log(primes[m - 1]) / Math.log(primes[0]));
		long curr_solution = baseSolutions(m);
		int[] powers = new int[m];
		BigInteger product = BigInteger.ONE;
		for (int i = 0; i < powers.length; i++) {
			powers[i] = 1;
			product = product.multiply(BigInteger.valueOf(primes[i]));
		}
		recurHelper(m, primes, limit, curr_solution, 0, powers, product, 1, power);
	}

	public static void recurHelper(int n, int[] primes, long limit, long curr_solution, int i, int[] powers,
			BigInteger product, int incre, int power) {

		int curr_power = 2;
		powers[i] = curr_power;
		incre *= primes[i];
		product = product.multiply(BigInteger.valueOf(primes[i]));
		curr_solution += increSolutions(powers, i);

		while (incre < primes[n - 1]*primes[n - 1] && curr_power <= power) {
			// System.out.println(curr_solution + "-" + Arrays.toString(powers));
			// Update values

			// Check if current solutions exceed the limit
			if (curr_solution > limit) {
				// Find one solution
				System.out.println(product + "-" + Arrays.toString(powers) + "-" + curr_solution);
				// Reset this power
				powers[i] = 1;
				return;
			}
			recurHelper(n, primes, limit, curr_solution, i + 1, powers, product, incre, curr_power);

			// Update parameters
			product = product.multiply(BigInteger.valueOf(primes[i]));
			curr_solution += increSolutions(powers, i);
			curr_power++;
			powers[i] = curr_power;
			incre *= primes[i];
		}

		// Reset this powers
		powers[i] = 1;
	}

	public static long baseSolutions(int m) {
		long ret = 1;

		int i = 0;
		while (i < m) {
			ret = ret * 3 - 1;
			i++;
		}
		return ret;
	}

	public static long increSolutions(int[] powers, int i) {

		long ret = 1;
		for (int k = 0; k < powers.length; k++) {
			if (k != i) {
				ret *= (2 * powers[k] + 1);
			}
		}
		return ret;
	}

	/*
	 * For n = a_1 * a_2 * ... * a_m such that all a_x are distinct. Find and return
	 * the least number m, for which the solution of P110 exceed limit.
	 */
	public static int findNumber(int limit) {
		long i = 1;
		int n = 0;
		for (; i <= limit; n++) {
			i = i * 3 - 1;
		}

		return n;
	}

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

		Prime.setPrimes(12);
		List<Integer> primes = Prime.getPrimes();

		// n = a_1 * a_2 * a*3
		for (int a = 0; a < (primes.size() - 3); a++) {
			for (int b = a + 1; b < primes.size() - 2; b++) {
				for (int c = b + 1; c < primes.size() - 1; c++) {
					for (int d = c + 1; d < primes.size(); d++) {
						int n = primes.get(a) * primes.get(a) * primes.get(b) * primes.get(b) * primes.get(c)
								* primes.get(c) * primes.get(d) * primes.get(d);
						System.out.println(n + " - " + simpleCounter(n));
					}
				}
			}
		}

		// Not Just Distinct prime divisor
		// n = a_1 * a_1 * a_2 * a_2 * a*3
		for (int a = 0; a < (primes.size() - 2); a++) {
			for (int b = a + 1; b < primes.size() - 1; b++) {
				for (int c = b + 1; c < primes.size(); c++) {
					int n = primes.get(a) * primes.get(a) * primes.get(b) * primes.get(a) * primes.get(b)
							* primes.get(b) * primes.get(c);
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
		//Problem110.solve(100);
		Problem110.solve(4_000_000);

	}

}
