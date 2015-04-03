/**Prime2.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jan 4, 2015 at 4:13:11 PM
 */
package Algorithm;


/**
 * @author Xiu Tiger Yi
 *
 */
public class Prime2 {

	int n;

	int[] primes;

	public Prime2(int n) {
		primes = new int[n + 1];

		primes[1] = 2;
		primes[2] = 3;

		int curr = 3;
		for (int i = 3; i < n + 1; i++) {
			curr = primes[i] = nextPrime(curr);
		}
	}

	public int nextPrime(int n) {
		do {
			n += 2;
		} while (!isPrime(n));
		return n;

	}

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
		return primes;
	}
}
