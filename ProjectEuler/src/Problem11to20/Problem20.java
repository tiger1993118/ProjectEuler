/**Problem20.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-11-30
3:22:12 PM
 */
package Problem11to20;

import java.math.BigInteger;

/**
 * TODO n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * Solution: Use BigInteger because the Factorial gonna be very huge. And
 * transfer the BigInteger into String to sum up every digits. Alternative
 * solution: Implement number using an array such that each digit occupy a
 * position in the array, but gonna be much more complicated.
 * 
 * @author Tiger yi
 * 
 */
public class Problem20 {

	public static void main(String[] args) {
		BigInteger Factorial = new BigInteger("1");

		for (Integer i = 1; i <= 100; i++) {
			BigInteger bigI = new BigInteger(i + "");
			Factorial = Factorial.multiply(bigI);
		}
		String s = Factorial.toString();
		Integer sum = 0;
		for (Integer i = 0; i < s.length(); i++) {
			Integer curr = (int) s.charAt(i) - '0';
			sum += curr;
		}

		System.out.println(sum);
	}
}
