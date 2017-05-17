/**Problem69.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 2, 2015 at 5:41:01 AM
 */
package part1.problem061to070;

import java.util.List;

import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem69 {

	public static List<Integer> primes;

	public static boolean[] isPrime;

	public static void totientMax() {
		int limit = 1000000;
		Prime.setPrimes(limit);
		primes = Prime.getPrimes();
		isPrime = Prime.getIsPrimes();
		Integer product = 1;
		for (Integer prime : primes) {
			if (product * prime < limit) {
				product *= prime;
			} else {
				break;
			}
		}
		System.out.println(product);
	}

	public static void main(String[] args) {
		totientMax();
	}
}
