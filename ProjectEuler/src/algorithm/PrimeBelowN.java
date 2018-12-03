/**Prime.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jan 1, 2015 at 10:48:35 PM
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiu Tiger Yi
 *
 *         This is a class to help find all the primes that is smaller than the
 *         number limit
 * 
 */
public class PrimeBelowN {

	// Store all the primes
	static List<Integer> primes;
	// A boolean array that match index to prime
	static boolean[] isPrimes;

	public PrimeBelowN(int limit) {
		setPrimes(limit);
	}

	public static void setPrimes(int limit) {

		primes = new ArrayList<Integer>();
		isPrimes = new boolean[limit];

		// Initialize all numbers are prime(ie. true)
		for (int i = 2; i < limit; i++) {
			isPrimes[i] = true;
		}
		// Reset the multiplier number to be false(ie. Not prime)
		for (int i = 2; i < limit; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (int x = 2; x * i < limit; x++) {
					isPrimes[i * x] = false;
				}
			}
		}
	}

	public static boolean[] getIsPrimes() {
		return isPrimes;
	}

	public static List<Integer> getPrimes() {
		return primes;
	}

	/*
	 * Old Function that check whether number n is prime
	 */
	@Deprecated
	public static boolean isPrime(int n) {
		for (int i : primes) {
			if (i > n / 2) {
				break;
			} else if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Old Function that check whether number n is prime
	 */
	@Deprecated
	public static boolean isPrime2(Integer n) {
		int root = (int) Math.sqrt(n + 1);
		for (Integer i = 2; i <= root; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PrimeBelowN.setPrimes(1_000_000_000);
		// System.out.println(PrimeBelowN.getPrimes());
		System.out.println(PrimeBelowN.getPrimes().size());
	}
}
