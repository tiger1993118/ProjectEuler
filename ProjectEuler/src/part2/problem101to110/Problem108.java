/**Problem108.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Aug 15, 2018 at 6:22:52 PM
*/
package part2.problem101to110;

import java.math.BigInteger;

import algorithm.Timer;

/**
 * @author Xiu Tiger Yi
 * TODO
 * In the following equation x, y, and n are positive integers.
 * 
	For n = 4 there are exactly three distinct solutions:

	What is the least value of n for which the number of distinct solutions exceeds one-thousand?

	NOTE: This problem is an easier version of Problem 110; it is strongly advised that you solve this one first.
 */
public class Problem108 {

	public static void solve() {
		
		// From the algorithm, repsectively x and n
		// Algorithm is calculating the y
		BigInteger x, n = BigInteger.valueOf(50000), limit;
		int count = 0;// Count the number of solutions
		int printed = 100;
		
		while(count <= 1000) {
			count = 0;// Reset the count
			n = n.add(BigInteger.ONE); // try the next n
			limit = n.add(n);// x must be smaller than 2*n, since y >= x
			for(x = n.add(BigInteger.ONE); x.compareTo(limit) <= 0; x = x.add(BigInteger.ONE)) {
				if((n.multiply(x)).mod(x.subtract(n)).equals(BigInteger.ZERO)) 
						count ++;
			}
			if(count > printed) {
				double time = Timer.duartion();
				System.out.println("n is " + n + " and count is " + count + ", and it took " + time + " seconds");
				printed += 100;
			}
		}
		System.out.println("n is " + n + " and count is " + count);
	}
	public static void main(String[] args) {
		Timer.start();
		Problem108.solve();
	}

}
