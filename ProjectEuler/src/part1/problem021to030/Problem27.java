/**Problem27.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-05
3:39:40 PM
 */
package part1.problem021to030;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Euler discovered the remarkable quadratic formula:
 * 
 * n² + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is
 * divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
 * divisible by 41.
 * 
 * The incredible formula n² − 79n + 1601 was discovered, which produces 80
 * primes for the consecutive values n = 0 to 79. The product of the
 * coefficients, −79 and 1601, is −126479.
 * 
 * Considering quadratics of the form:
 * 
 * n² + an + b, where |a| < 1000 and |b| < 1000
 * 
 * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |−4| = 4 Find
 * the product of the coefficients, a and b, for the quadratic expression that
 * produces the maximum number of primes for consecutive values of n, starting
 * with n = 0.
 * 
 * Solution : First I compute all the primes under 2*1000², why only primes
 * below this limit? because both a and b are under 1000,so that the quadratic
 * equation gonna be n² + an + b < n² + 1000n + 1000 and we know when n = 1000,
 * n² + 1000n + 1000 must not be a prime number, that is approximately 2*1000².
 * And i optimize the runtime by only choosing b is prime. Because when n = 0,
 * quadratic equation gonna be b, so that b must be prime. When n = 1, quadratic
 * equation gonna be 1 + a + b and this is gonna be prime, then we could
 * conclude that a is bigger than -b(every prime are positive). Loop through
 * every prime below 1000 for b, and a such that -b < a < 1000, starting from n
 * = 1(n = 0 already done), increase 1 for n if the quadratic quuation at this n
 * is still a prime. Find the maximum one and the product of a and b.
 * 
 * @author Tiger yi
 * 
 */
public class Problem27 {

	public boolean[] isPrime;

	public Integer limit;

	public Integer primeLimit;

	public List<Integer> primes;

	public Problem27(Integer limit) {
		this.limit = limit;
		this.primeLimit = (int) (2 * Math.pow(limit, 2));
		isPrime = new boolean[primeLimit];
		primes = new ArrayList<Integer>();
		allPrimes();
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
		for (int i = 2; i < limit; i++) {
			if (isPrime[i])
				primes.add(i);
		}
	}

	public Integer quadraticPrimes() {
		Integer max = 0;
		for (Integer b : primes) {
			for (Integer a = -b; a < limit; a++) {
				Integer n = 1;
				Integer i = quadratic(n, a, b);
				while (i > -1 && isPrime[i]) {
					n++;
					i = quadratic(n, a, b);
				}
				n--;
				if (max < n) {
					max = n;
					System.out.println(a + " - " + b + " = " + a * b + " max:"
							+ max);
				}
			}

		}
		return max;
	}

	public Integer quadratic(Integer n, Integer a, Integer b) {
		return (int) (Math.pow(n, 2) + a * n + b);
	}

	public static void main(String[] args) {
		Problem27 P27 = new Problem27(1000);
		P27.quadraticPrimes();
	}

}
