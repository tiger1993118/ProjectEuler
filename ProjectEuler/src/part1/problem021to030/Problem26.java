/**Problem26.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-04
11:35:42 PM
 */
package part1.problem021to030;

import java.math.BigInteger;

/**
 * TODO A unit fraction contains 1 in the numerator. The decimal representation
 * of the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2 = 0.5 1/3 = 0.(3) 1/4 = 0.25 1/5 = 0.2 1/6 = 0.1(6) 1/7 = 0.(142857) 1/8
 * = 0.125 1/9 = 0.(1) 1/10 = 0.1 Where 0.1(6) means 0.166666..., and has a
 * 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
 * cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 * 
 * Solution : After observation, i found out 2 facts:1. If number a is k times
 * as number b, then a and b have the same length of recurring cycle. 2. If
 * number 1/a have recurring cycle, 0.c_{1}c_{2}...c_{n}(cycle have length n)
 * then c_{1}c_{2}...c_{n} multiply a will be 0.99...9(n 9's).From these
 * observations, we only have to compute the length of recurring cycle such that
 * numerator is a prime number.And as we find out the c_{1}c_{2}...c_{n}(cycle
 * have length n) multiply a is 0.99...9(n 9's), then we have the cycle. Loop
 * through all the primes, we found the longest recurring cycle and its
 * numerator.
 * 
 * @author Tiger yi
 * 
 */
public class Problem26 {
	public static boolean[] isPrime;

	public static BigInteger big1 = new BigInteger("1");
	public static BigInteger big10 = new BigInteger("10");

	public static Integer longestCycle(Integer limit) {
		Integer max = 0;
		Integer ret = 0;
		allPrimes(limit);
		for (Integer i = 6; i < limit; i++) {
			if (isPrime[i]) {
				Integer length = cycleLength(new BigInteger(i.toString()));
				if (length > max) {
					ret = i;
					max = length;
				}
			}
		}
		return ret;
	}

	public static void allPrimes(Integer limit) {
		isPrime = new boolean[limit];
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < limit; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < limit; i++) {
			if (isPrime[i]) {
				for (int ni = i + i; ni < limit; ni = ni + i) {
					isPrime[ni] = false;
				}
			}
		}
	}

	public static Integer cycleLength(BigInteger n) {

		BigInteger difference = new BigInteger("0");
		BigInteger big10s = new BigInteger("1");
		BigInteger bigFraction = null;

		while (!difference.equals(big1)) {
			big10s = big10s.multiply(big10);
			bigFraction = big10s.divide(n);
			difference = big10s.subtract(bigFraction.multiply(n));
		}
		Integer length = bigFraction.toString().length()
				+ n.toString().length() - 1;
		return length;
	}

	public static void main(String[] args) {
		System.out.println(Problem26.longestCycle(1000));

	}
}
