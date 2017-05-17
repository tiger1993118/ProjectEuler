/**Problem35.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
3:34:43 AM
 */
package part1.problem031to040;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 * 
 * Solution : First compute all the primes under 1 million, then loop through
 * every primes, such that every rotations of the number is a prime.Count all of
 * them.
 * 
 * @author Tiger yi
 * 
 */
public class Problem35 {

	public final int primeLimit = 1000000;

	public boolean[] isPrime = new boolean[primeLimit];

	public List<Integer> primes = new ArrayList<Integer>();

	public void circularPrimes() {
		int total = 0;
		allPrimes();
		for (int prime : primes) {
			if (isCircular(prime)) {
				System.out.println(prime);
				total += 1;
			}
		}
		System.out.println(total);
	}

	public boolean isCircular(int n) {
		int i = 6;
		while ((n / Math.pow(10, i)) < 1) {
			i--;
		}
		int time = i;
		while (time > 0) {
			int highest = n / (int) Math.pow(10, i);
			n -= highest * Math.pow(10, i);
			n = n * 10 + highest;
			if (!isPrime[n])
				return false;
			time--;
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
		new Problem35().circularPrimes();

	}

}
