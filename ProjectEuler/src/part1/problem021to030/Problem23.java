/**Problem22.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-04
1:44:06 AM
 */
package part1.problem021to030;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * 
 * Solution:Firstly compute all the primes under the limit and store them in an
 * integer list(i used boolean array at first to filter out the prime faster).
 * Secondly, compute proper divisors of every number and the sum of them(This
 * step could be faster by ignoring those prime number, their sum of divisors
 * are all 1).Then find out the abundant number according to its definition and
 * store them in an integer list.After that loop through the abundant list twice
 * and to compute every subset of size two, and the sum of them will not be
 * included in the answer, I use an boolean array to filter keep track of wheter
 * a number could be the sum of two abundant numbers.Finally, loop through the
 * array and compute the sum of them all.
 * 
 * @author Tiger yi
 * 
 */
public class Problem23 {
	public static final Integer limit = 28124;

	public boolean[] isPrime;

	public List<Integer> primes;

	public Integer[] sumOfDivisor;

	public boolean[] notAbundantSum;

	public List<Integer> abundants;

	public Problem23() {
		isPrime = new boolean[limit];
		primes = new ArrayList<Integer>();
		sumOfDivisor = new Integer[limit];
		notAbundantSum = new boolean[limit];
		abundants = new ArrayList<Integer>();
		allPrimes();
		sumOfDivisors();
		for (Integer i = 0; i < limit; i++) {
			notAbundantSum[i] = true;
		}
	}

	public Integer nonAbundantSum() {
		Integer sum = 0;
		for (Integer i = 0; i < limit; i++) {
			if (sumOfDivisor[i] > i) {
				abundants.add(i);
			}
		}
		for (Integer i1 : abundants) {
			for (Integer i2 : abundants) {
				if (i1 + i2 < limit) {
					notAbundantSum[i1 + i2] = false;
				}
			}
		}
		for (Integer i = 0; i < limit; i++) {
			if (notAbundantSum[i])
				sum += i;
		}
		return sum;
	}

	public void sumOfDivisors() {
		for (Integer i = 2; i < limit; i++) {
			List<Integer> factors = new ArrayList<Integer>();
			List<Set<Integer>> divisors = new ArrayList<Set<Integer>>();
			Set<Integer> thisDivisors = new HashSet<Integer>();
			thisDivisors.add(i);
			divisors.add(thisDivisors);
			if (!isPrime[i]) {
				Integer temp = i;
				for (Integer prime : primes) {
					while (temp != 1 && temp % prime == 0) {
						temp = temp / prime;
						factors.add(prime);
					}
					if (temp == 1) {
						break;

					}
				}

				for (int time = 0; time < factors.size(); time++) {
					thisDivisors = new HashSet<Integer>();
					for (Integer divisor : divisors.get(time)) {
						for (Integer factor : factors) {
							if (divisor % factor == 0) {
								thisDivisors.add(divisor / factor);
							}
						}
					}
					divisors.add(thisDivisors);
				}
				Integer sum = 0;
				for (int index = 1; index < divisors.size(); index++) {
					for (Integer divisor : divisors.get(index)) {
						sum += divisor;
					}
				}
				sumOfDivisor[i] = sum;
			} else {
				sumOfDivisor[i] = 1;
			}
		}

	}

	public void allPrimes() {
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < limit; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < limit; i++) {
			if (isPrime[i]) {
				primes.add(i);
				for (int ni = i + i; ni < limit; ni = ni + i) {
					isPrime[ni] = false;
				}
			}
		}

		for (int i = 0; i < limit; i++) {
			sumOfDivisor[i] = -1;
		}
	}

	public static void main(String[] args) {
		Problem23 P22 = new Problem23();
		System.out.println(P22.nonAbundantSum());
	}
}
