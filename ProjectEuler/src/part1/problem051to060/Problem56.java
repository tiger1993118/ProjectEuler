/**Problem56.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-31
9:28:07 AM
 */
package part1.problem051to060;

import java.math.BigInteger;

import algorithm.Digits;

/**
 * TODO A googol (10100) is a massive number: one followed by one-hundred zeros;
 * 100100 is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 * 
 * Considering natural numbers of the form, ab, where a, b < 100, what is the
 * maximum digital sum?
 * 
 * Solution : Use BigInteger to compute a^b and static method digitSum to
 * compute the digits sum of string.
 * 
 * @author Tiger yi
 * 
 */
public class Problem56 {

	public void powerfulDigitSum() {
		Integer max = 0;
		for (Integer a = 1; a < 100; a++) {
			for (Integer b = 1; b < 100; b++) {
				BigInteger ba = new BigInteger(a.toString());
				Integer sum = Digits.digitSum(ba.pow(b).toString());
				max = Math.max(sum, max);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new Problem56().powerfulDigitSum();

	}

}
