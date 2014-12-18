/**Problem46.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-17
10:06:33 PM
 */
package Problem41to50;

/**
 * TODO It was proposed by Christian Goldbach that every odd composite number
 * can be written as the sum of a prime and twice a square.
 * 
 * 9 = 7 + 2×12 15 = 7 + 2×22 21 = 3 + 2×32 25 = 7 + 2×32 27 = 19 + 2×22 33 = 31
 * + 2×12
 * 
 * It turns out that the conjecture was false.
 * 
 * What is the smallest odd composite that cannot be written as the sum of a
 * prime and twice a square?
 * 
 * 
 * Solution : Loop through every odd composite numbers from 9, Reverse the
 * Algorithm, n - 2*x^2 if it is a prime, loop through every x such that the
 * result is bigger than 0. If there is no satisfied prime, then that is the
 * number break the rule.
 * 
 * @author Tiger yi
 * 
 */
public class Problem46 {

	public int primeLimit = 1000000;

	public boolean[] isPrime = new boolean[primeLimit];

	public void goldbach() {
		allPrimes();

		for (int i = 9; i < primeLimit; i += 2) {
			if (!isPrime[i]) {
				int t = 1;
				int n = i - (int) Math.pow(t, 2) * 2;
				while (n >= 0) {
					if (isPrime[n]) {
						break;
					}
					t += 1;
					n = i - (int) Math.pow(t, 2) * 2;
				}
				if (n < 0) {
					System.out.println(i);
				}
			}
		}
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
	}

	public static void main(String[] args) {
		new Problem46().goldbach();

	}

}
