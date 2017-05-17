/**Problem34.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
2:27:34 AM
 */
package part1.problem031to040;

/**
 * TODO 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * 
 * Observation : the largest digit is 9, so the largest margin is 9!, and I
 * notice that the largest nine digit number have sum of digits 9 * 9! is an
 * eight digit number.So that eight digit number is the limit, 8*9! is the
 * largest possible curious number.
 * 
 * Solution : store 0! to 9! so that we do not have to compute them again. Loop
 * through 10 to 9*9! compute sum of every digits and compare.Sum up all of them
 * which is the final answer.
 * 
 * @author Tiger yi
 * 
 */
public class Problem34 {

	public int[] factorials = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

	public void digitFactorials() {
		int total = 0;
		for (int n = 10; n < 2903040; n++) {
			int i = 6;
			while ((n / Math.pow(10, i)) < 1) {
				i -= 1;
			}
			int sum = 0, digit = 0, copy = n;
			while (i >= 0) {
				digit = copy / (int) Math.pow(10, i);
				sum += factorials[digit];
				copy -= digit * (int) Math.pow(10, i);
				i--;
			}
			if (sum == n) {
				System.out.println(n);
				total += n;
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		new Problem34().digitFactorials();
	}

}
