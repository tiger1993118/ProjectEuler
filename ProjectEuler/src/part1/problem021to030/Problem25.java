/**Problem25.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-04
11:18:51 PM
 */
package part1.problem021to030;

import java.math.BigInteger;

/**
 * TODO The Fibonacci sequence is defined by the recurrence relation:
 * 
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1. Hence the first 12 terms will be:
 * 
 * F1 = 1 F2 = 1 F3 = 2 F4 = 3 F5 = 5 F6 = 8 F7 = 13 F8 = 21 F9 = 34 F10 = 55
 * F11 = 89 F12 = 144 The 12th term, F12, is the first term to contain three
 * digits.
 * 
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * Solution: Simply use BigInteger to contain the Fibonacci number and apply the
 * algorithm to compute Fibonacci number.
 * 
 * @author Tiger yi
 * 
 */
public class Problem25 {

	public static Integer fibonacciNumber(Integer limit) {
		BigInteger f1 = new BigInteger("1");
		BigInteger f2 = new BigInteger("1");
		return fibonacciHelper(f1, f2, 3, limit);
	}

	public static Integer fibonacciHelper(BigInteger f1, BigInteger f2,
			Integer n, Integer limit) {
		BigInteger f3 = f1.add(f2);
		Integer length = f3.toString().length();
		if (length >= limit) {
			return n;
		} else {
			return fibonacciHelper(f2, f3, n + 1, limit);
		}

	}

	public static void main(String[] args) {
		System.out.println(Problem25.fibonacciNumber(1000));
	}
}
