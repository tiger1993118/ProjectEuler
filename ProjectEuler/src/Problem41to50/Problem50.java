/**Problem50.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-18
3:12:07 AM
 */
package Problem41to50;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO The prime 41, can be written as the sum of six consecutive primes:
 * 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13 This is the longest sum of consecutive primes
 * that adds to a prime below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 * 
 * 
 * Solution : First compute the largest number that it could get with the sum of
 * consecutive primes starting from 2. Find the length and the sum, run a loop
 * such that each time check if the sum is prime, if yes, return the sum, it
 * have the sum of longest consecutive primes. If no, deduce the smallest prime
 * starting from 2 every loop.
 * 
 * @author Tiger yi
 * 
 */
public class Problem50 {

	public int primeLimit = 1000000;

	public boolean[] isPrime = new boolean[primeLimit];

	public List<Integer> primes = new ArrayList<Integer>();

	public void consecutivePrime() {
		allPrimes();
		int total = 0;
		int max = 0;
		for (int prime : primes) {
			if (total + prime < 1000000) {
				total += prime;
				max += 1;
			} else {
				break;
			}
		}
		int i = 0;
		while (!isPrime[total]) {
			total -= primes.get(i);
			i += 1;
			max -= 1;
		}
		System.out.println(max);
		System.out.println(total);
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
		new Problem50().consecutivePrime();

	}

}
