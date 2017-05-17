/**Problem21.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-03
7:09:21 PM
 */
package part1.problem021to030;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO Let d(n) be defined as the sum of proper divisors of n (numbers less
 * than n which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b,
 * then a and b are an amicable pair and each of a and b are called amicable
 * numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * Solution : I have several steps before i have the final result. Firstly I
 * calculate every primes up to the limit number(in the question, it is 10000),
 * And store them in a list and also cross out the possibilities for them to be
 * Amicable numbers, because the only proper divisors primes has is 1, and and
 * obviously any pairs of prime and 1 are not amicable pairs.But the real reason
 * we compute all the primes is that, we need to calculate the proper divisors
 * for every number, that comes our second step.Once we have all the prime
 * numbers, we do a infinite division to find all the possible prime factors.
 * e.g., 12 = 2*2*3, and that leads us to the next step, compute all the
 * different subsets of factors of the number, so that the product of each
 * subset will become a unique proper divisors. We could compute the sum of
 * divisors as soon as we have them and store them in a array of Integer such
 * that Index at i have representing number i and the corresponding value at i
 * is the sum of i's divisors. Finally, we have everything, filter out only the
 * amicable numbers and compute the sum.
 * 
 * @author Tiger yi
 * 
 */
public class Problem21 {

	public boolean[] isPrime;

	public Integer limit;

	public List<Integer> primes;

	public Integer[] amicables;

	public Problem21(Integer limit) {
		this.limit = limit;
		isPrime = new boolean[limit];
		amicables = new Integer[limit];
		primes = new ArrayList<Integer>();
		allPrimes();
	}

	public Integer sumAmicableNumbers() {
		Integer sum = 0;
		amicableNumbers();
		for (Integer i = 2; i < limit; i++) {
			if (amicables[i] != -1) {
				if (amicables[i] < limit) {
					if (i.equals(amicables[amicables[i]])
							&& !i.equals(amicables[i])) {
						sum += i;
					}
				}
			}
		}
		return sum;
	}

	public void amicableNumbers() {
		for (Integer i = 2; i < limit; i++) {
			List<Integer> factors = new ArrayList<Integer>();
			List<Set<Integer>> divisors = new ArrayList<Set<Integer>>();
			Set<Integer> thisDivisors = new HashSet<Integer>();
			thisDivisors.add(i);
			divisors.add(thisDivisors);
			if (amicables[i] == 0) {
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
				amicables[i] = sum;
			}
		}
	}

	public void allPrimes() {
		isPrime[0] = false;
		isPrime[1] = false;
		amicables[0] = -1;
		amicables[1] = -1;
		for (int i = 2; i < limit; i++) {
			amicables[i] = 0;
			isPrime[i] = true;
		}

		for (int i = 2; i < limit; i++) {

			if (isPrime[i]) {
				primes.add(i);
				amicables[i] = -1;
				for (int ni = i + i; ni < limit; ni = ni + i) {
					isPrime[ni] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Problem21 P21 = new Problem21(10000);
		System.out.println(P21.sumAmicableNumbers());

	}
}
