/**Problem53.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-21
3:30:02 PM
 */
package part1.problem051to060;

import java.math.BigInteger;

import Algorithm.Combination;

/**
 * TODO There are exactly ten ways of selecting three from five, 12345:
 * 
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * 
 * In combinatorics, we use the notation, 5C3 = 10.
 * 
 * In general,
 * 
 * nCr = n! r!(n−r)! ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1. It is not
 * until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * 
 * How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are
 * greater than one-million?
 * 
 * Solution : Loop Through every combinations such that r,n <= 100, we know that
 * nCr = nC(n-r) so that we only have to compute nCr such that r <= n/2.
 * 
 * @author Tiger yi
 * 
 */
public class Problem53 {

	public void combinatoricSelections() {
		BigInteger million = new BigInteger("1000000");
		Integer counter = 0;
		for (Integer n = 23; n <= 100; n++) {
			for (Integer r = 1; r <= n / 2; r++) {
				BigInteger bi = Combination.algorithm(r, n);
				if (n % 2 == 0 && (r == n / 2)) {
					if (bi.compareTo(million) > 0) {
						counter += 1;
					}
				} else {
					if (bi.compareTo(million) > 0) {
						counter += 2;
					}
				}
			}
		}
		System.out.println(counter);
	}

	public static void main(String[] args) {
		new Problem53().combinatoricSelections();

	}

}
