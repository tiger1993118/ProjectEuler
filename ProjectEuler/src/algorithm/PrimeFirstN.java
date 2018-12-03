package algorithm;

import java.util.Arrays;

/**
 * @author Xiu Tiger Yi A class that find the first n primes.
 */
public class PrimeFirstN {

	int n;
	int[] primes;// Store all the primes
	boolean[] isPrimes;// A boolean match index to isPrime

	public PrimeFirstN(int n) {

		// Initialize data structure
		primes = new int[n + 1];

		// Set the first two primes
		primes[1] = 2;
		primes[2] = 3;

		// Starting from the prime 3
		int curr = 3;
		// Set primes
		for (int i = 3; i < primes.length; i++) {
			curr = primes[i] = nextPrime(curr);
		}

		isPrimes = new boolean[primes[primes.length - 1] + 1];
		// Set isPrimes
		for (int i = 1; i < primes.length; i++) {
			isPrimes[primes[i]] = true;
		}

	}

	// Skip every even number and return the next prime
	public int nextPrime(int n) {
		do {
			n += 2;
		} while (!isPrime(n));
		return n;

	}

	// Return True if current number n is Prime
	public boolean isPrime(int n) {
		int root = (int) Math.sqrt(n + 1);

		for (int i = 1; primes[i] <= root; i++) {
			if (n % primes[i] == 0)
				return false;
		}
		return true;
	}

	public static boolean isPrime2(int number) {
		if (number <= 1)
			return false;
		if (number == 2 || number == 3)
			return true;
		if ((number & 1) == 0)
			return false;
		if (number % 3 == 0)
			return false;
		for (int i = 5; i < Math.sqrt(number) + 1; i += 6) {
			if (number % i == 0) {
				return false;
			}
			if (number % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

	public int[] getPrimes() {
		// inogre primes[0], which is 0
		return Arrays.copyOfRange(primes, 1, primes.length);
	}

	public boolean[] getIsPrimes() {
		return isPrimes;
	}

	public static void main(String[] args) {
		PrimeFirstN p = new PrimeFirstN(10);
		System.out.println(Arrays.toString(p.getIsPrimes()));
		System.out.println(p);
	}
}
