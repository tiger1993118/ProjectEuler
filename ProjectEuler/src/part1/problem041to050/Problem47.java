/**Problem47.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-18
1:42:10 AM
 */
package part1.problem041to050;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO The first two consecutive numbers to have two distinct prime factors
 * are:
 * 
 * 14 = 2 × 7 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors are:
 * 
 * 644 = 2² × 7 × 23 645 = 3 × 5 × 43 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct prime factors.
 * What is the first of these numbers?
 * 
 * 
 * Observation : The smallest integer having four distinct prime factors is
 * 2*3*5*7 = 210, we could start from here. Realized that , we do not have to
 * loop through every integers increasing by 1, instead, we could loop integers
 * every fourth one. Because if we need four consecutive integers, then if last
 * one of them failed, even if the first three satisfied the condition, these
 * four still could not be consecutive.
 * 
 * Solution : Loop through every fourth integers starting from 210, if it failed
 * the condition, go to the next one increased by 4. If it satisfied the
 * condition, we found one at the moment(denote the number n), we still need to
 * find another three. First check number below n, starting (n-1),(n-2)... in
 * order till some failed or the counter hit 4, if counter hit 4 then we find 4
 * consecutive, (n-3) is the smallest. If one of them failed, then we look into
 * the number larger than n, (n+1),(n+2)... in order till some failed or the
 * counter hit 4(remember the counter is saved from previous one that include n
 * and number below n that satisfied). If counter hit 4, return the smallest of
 * the four, otherwise, loop to next number increased by 4.
 * 
 * @author Tiger yi
 * 
 */
public class Problem47 {

	public int primeLimit = 1000000;

	public boolean[] isPrime = new boolean[primeLimit];

	public List<Integer> primes = new ArrayList<Integer>();

	public void distinctPrime() {
		allPrimes();
		for (int i = 210; i < primeLimit; i += 4) {
			int t = 0;
			if (containsFourPrimes(i)) {

				int i2 = i;
				while (containsFourPrimes(i2)) {
					t += 1;
					if (t == 4) {
						System.out.println(i2);
						break;
					}
					i2 -= 1;
				}
				if (t < 4) {
					int i3 = i + 1;
					while (containsFourPrimes(i3)) {
						t += 1;
						if (t == 4) {
							System.out.println(i2);
							break;
						}
						i3 += 1;
					}
				}
			}
			if (t == 4) {
				break;
			}
		}
	}

	public boolean containsFourPrimes(int n) {
		if (isPrime[n])
			return false;
		Set<Integer> factors = new HashSet<Integer>();
		for (int prime : primes) {
			while (n % prime == 0) {
				n = n / prime;
				factors.add(prime);
			}
			if (n == 1) {
				break;
			}
		}
		if (factors.size() == 4)
			return true;
		return false;
	}

	public void allPrimes() {
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < primeLimit; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < primeLimit; i++) {
			if (isPrime[i]) {
				primes.add(i);
				for (int ni = i + i; ni < primeLimit; ni = ni + i) {
					isPrime[ni] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Problem47().distinctPrime();

	}

}
