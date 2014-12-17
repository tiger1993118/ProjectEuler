/**Problem37.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
3:28:19 PM
 */
package Problem31to40;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * 
 * Solution : Compute every primes under 1 million, and check every one of them
 * whether it is truncatable from both left to right and right to left.Finally
 * sum them up.
 * 
 * @author Tiger yi
 * 
 */
public class Problem37 {
	public final int primeLimit = 1000000;

	public boolean[] isPrime = new boolean[primeLimit];

	public List<Integer> primes = new ArrayList<Integer>();

	public void truncatablePrimes() {
		int sum = 0;
		allPrimes();
		for (Integer prime : primes) {
			if (isTruncatable(prime.toString())) {
				System.out.println(prime);
				if (prime > 10)
					sum += prime;
			}
		}
		System.out.println(sum);
	}

	public boolean isTruncatable(String s) {
		for (int end = 1; end < s.length(); end++) {
			Integer i = Integer.parseInt(s.substring(0, end));
			if (!isPrime[i]) {
				return false;
			}
		}
		for (int start = s.length() - 1; start > 0; start--) {
			Integer i = Integer.parseInt(s.substring(start, s.length()));
			if (!isPrime[i]) {
				return false;
			}

		}
		return true;
	}

	public void allPrimes() {
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < primeLimit; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < primeLimit; i++) {
			if (isPrime[i]) {
				for (int ni = i + i; ni < primeLimit; ni = ni + i) {
					isPrime[ni] = false;
				}
			}
		}
		for (int i = 2; i < primeLimit; i++) {
			if (isPrime[i])
				primes.add(i);
		}
	}

	public static void main(String[] args) {
		Problem37 P37 = new Problem37();
		P37.truncatablePrimes();
		// System.out.println(P37.isPrime[74]);

	}

}
