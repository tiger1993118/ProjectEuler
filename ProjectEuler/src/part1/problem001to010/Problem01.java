/**Problem1.java
@author Tiger Yi <yixiu17@gmail.com>
Created on 2014-11-27
9:38:41 PM
 */
package part1.problem001to010;

/**
 * TODO Multiples of 3 and 5 If we list all the natural numbers below 10 that
 * are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is
 * 23. Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * Solution : my solution is very simple, initial an Integer total to keep the
 * sum, loop through every integer between 0 to 1000, if current number is a
 * multiples of 3 or 5, add it to the total, otherwise, jump to the next one
 * 
 * @author yi
 */
public class Problem01 {

	public static Integer multiplesOf3and5() {
		Integer total = 0;
		for (int i = 1; i < 1000; i++) {
			if ((i % 3 == 0) || (i % 5 == 0))
				total += i;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(Problem01.multiplesOf3and5());
	}
}
