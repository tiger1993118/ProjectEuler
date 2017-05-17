/**Problem77.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 6, 2015 at 9:12:16 AM
 */
package part1.problem071to080;

import java.util.List;

import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem77 {

	static List<Integer> primes;

	static int[] numSummations = null;

	static boolean[] isPrime;

	public static void primeSummations() {
		Integer limit = 100;
		Prime.setPrimes(limit);
		primes = Prime.getPrimes();
		isPrime = Prime.getIsPrimes();
		numSummations = new int[limit];
		numSummations[1] = 0;
		numSummations[2] = 0;
		numSummations[3] = 0;

		for (Integer n = 4; n < limit; n++) {
			Integer ret = 0;
			for (Integer prime : primes) {
				if (prime >= n)
					break;

				Integer count = recurSummations(n - prime,
						Math.min(n - prime, prime));
				ret += count;
				// System.out.println(prime + "-" + count);
			}
			numSummations[n] = ret;
			if (ret > 5000) {
				System.out.println(n + "-" + ret);
				break;
			}
		}
	}

	public static int recurSummations(int total, int bound) {
		if (total <= bound) {
			if (isPrime[total])
				return numSummations[total] + 1;
			else
				return numSummations[total];
		} else {
			Integer ret = 0;
			for (Integer prime : primes) {
				if (prime > bound)
					break;

				Integer count = recurSummations(total - prime,
						Math.min(total - prime, prime));
				ret += count;
			}
			return ret;
		}
	}

	public static void main(String[] args) {
		primeSummations();

	}

}
