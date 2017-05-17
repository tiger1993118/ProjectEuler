/**Problem58.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jan 1, 2015 at 10:45:51 PM
 */
package part1.problem051to060;

import Algorithm.Prime2;

/**
 * 
 * TODO Starting with 1 and spiralling anticlockwise in the following way, a
 * square spiral with side length 7 is formed.
 * 
 * 37 36 35 34 33 32 31 38 17 16 15 14 13 30 39 18 5 4 3 12 29 40 19 6 1 2 11 28
 * 41 20 7 8 9 10 27 42 21 22 23 24 25 26 43 44 45 46 47 48 49
 * 
 * It is interesting to note that the odd squares lie along the bottom right
 * diagonal, but what is more interesting is that 8 out of the 13 numbers lying
 * along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 * 
 * If one complete new layer is wrapped around the spiral above, a square spiral
 * with side length 9 will be formed. If this process is continued, what is the
 * side length of the square spiral for which the ratio of primes along both
 * diagonals first falls below 10%?
 * 
 * Observation : After couple of trying, I observe that the prime percentage
 * will drop below 10% approximately between length 22000 to 28000, then 28000^2
 * is about 800000000, So that I only need to compute all the primes below this
 * limit first(To optimize, we only need to compute 1/2 of it, which is
 * 400000000).
 * 
 * Solution : After computing all the primes within the limit, we create a while
 * loop on condition of percentage of prime numbers comparing with 10%. Odd
 * squares lie along the bottom right diagonal, which is also square of the
 * lengths of square spiral. the other three numbers along the diagonal(which
 * are bottom left, up left and up right) are each decreasing by (length - 1).
 * We could check whether they are prime numbers by using the primes we compute
 * before. Return the length of square spiral when the while loop ends.
 * 
 * @author Xiu Tiger Yi
 *
 */
public class Problem58 {

	public void spiralPrimes() {

		Prime2 Prime2 = new Prime2(30000);
		Integer prime = 3;
		Integer total = 5;
		Integer length = 3;

		while ((double) prime / total >= 0.1) {
			System.out.println("length:" + length + "per:" + (double) prime
					/ total);
			length += 2;
			total += 4;
			Integer current = (int) Math.pow(length, 2);
			for (int i = 0; i < 3; i++) {
				current = current - (length - 1);

				if (Prime2.isPrime(current))
					prime += 1;
			}
		}
		System.out.println(length);

	}

	public static void main(String[] args) {
		new Problem58().spiralPrimes();
	}

}
