/**Prime.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jan 1, 2015 at 10:48:35 PM
 */
package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Prime {

	public static List<Integer> primes;

	public static boolean[] isPrimes;
	
	public static void setPrimes(Integer n) {
		primes = new ArrayList<Integer>();

		isPrimes = new boolean[n];
		for (Integer i = 0; i < n; i++) {
			isPrimes[i] = true;
		}

		for (Integer i = 2; i < n; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (Integer x = 2; x * i < n; x++) {
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

	public static boolean isPrime(Integer n) {
		for (Integer i : primes) {
			if (i > n / 2) {
				break;
			} else if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime2(Integer n) {
		int root = (int) Math.sqrt(n + 1);
		for (Integer i = 2; i <= root; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Prime.setPrimes(10000000);
		System.out.println(primes);
	}
}
