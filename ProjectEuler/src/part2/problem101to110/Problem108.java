/**Problem108.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Aug 15, 2018 at 6:22:52 PM
*/
package part2.problem101to110;

import java.math.BigInteger;

import algorithm.Timer;

/**
 * @author Xiu Tiger Yi TODO In the following equation x, y, and n are positive
 *         integers. 1/x + 1/y = 1/n For n = 4 there are exactly three distinct
 *         solutions: 1/5 + 1/20 = 1/4 1/6 + 1/12 = 1/4 1/8 + 1/8 = 1/4
 * 
 *         What is the least value of n for which the number of distinct
 *         solutions exceeds one-thousand? NOTE: This problem is an easier
 *         version of Problem 110; it is strongly advised that you solve this
 *         one first.
 */
public class Problem108 {

	public static void solve() {
		/*
		 * n from the problem Initial value is 1020, since it is the mutiplier of 2,3
		 * and 5 If it exceeds 1000 solutions, it must be the first one with the
		 * mutiplier of 2, 3 and 5
		 */
		BigInteger n = BigInteger.valueOf(1020);
		/*
		 * Make use of the alogrithm and make some subtle change 1/y = 1/n - 1/x such
		 * that y = nx/(x-n) We always choose y >= x and we could deduct that x > n and
		 * x < 2n We re-define the algorithm, set numerator as nx and denominator as
		 * (x-n), for which 0 < (x-n) <= n
		 */
		BigInteger numerator, denominator;

		int count = 0;// Count the number of solutions
		int printed = 100;// Help print out info with a new count exceed another 100

		while (count <= 1000) {
			count = 0;// Reset the count
			// As previously explained, n must increase by 30(i.e. 2*3*5)
			n = n.add(BigInteger.valueOf(30));

			/*
			 * Loop through all the possible 'x' and calculate the corresponding 'y' for
			 * this n Make use of the algorithm, increase denominator by 1 and numerator by
			 * n each time
			 */
			for (numerator = n.multiply(n.add(BigInteger.ONE)), denominator = BigInteger.ONE; denominator
					.compareTo(n) <= 0; numerator = numerator.add(n), denominator = denominator.add(BigInteger.ONE)) {
				if (numerator.mod(denominator).equals(BigInteger.ZERO)) // If 'y' is an integer. we found one solution
					count++;
			}
			if (count > printed) { // Print info once another n exceed another 100 (i.e. 100, 200 etc)
				double time = Timer.duartion();
				System.out.println("n is " + n + " and count is " + count + ", and it took " + time + " seconds");
				printed += 100;
			}
		}
	}

	public static void main(String[] args) {
		Timer.start();
		Problem108.solve();
	}

}
