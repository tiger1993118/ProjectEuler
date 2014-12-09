/**Problem30.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-08
8:23:29 PM
 */
package Problem21to30;

/**
 * TODO Surprisingly there are only three numbers that can be written as the sum
 * of fourth powers of their digits:
 * 
 * 1634 = 14 + 64 + 34 + 44 8208 = 84 + 24 + 04 + 84 9474 = 94 + 44 + 74 + 44 As
 * 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 * 
 * Solution : The trick part is to find the upper bound of the number we are
 * looking for, we denote the sum of fifth powers of their digits to be
 * sumOfDigits(), and notice that sumOfDigits(999999) = 354294 so that the
 * maximum sum of every 6 digits number is 354294, so the number above it will
 * have sum smaller than it. Now we have our upper bound, only thing we need to
 * do is write the algorithm to compute sum of fifth powers of their digits,
 * which is gonna be easy.
 * 
 * @author Tiger yi
 * 
 */
public class Problem30 {

	public void fifthPowers() {
		int total = 0;
		for (int i = 2; i < 354294; i++) {
			int digitSum = sumOfDigits(i);
			if (i == digitSum)
				total += i;
		}
		System.out.println(total);
	}

	public int sumOfDigits(int n) {
		int sum = 0;
		for (int i = 5; i >= 0; i--) {
			int digit = n / (int) Math.pow(10, i);
			sum += Math.pow(digit, 5);
			n -= digit * (int) Math.pow(10, i);
		}
		return sum;
	}

	public static void main(String[] args) {
		new Problem30().fifthPowers();
	}

}
