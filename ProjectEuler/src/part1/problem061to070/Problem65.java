/**Problem65.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 12, 2015 at 10:06:56 AM
 */
package part1.problem061to070;

import java.math.BigInteger;

import algorithm.Digits;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem65 {

	public static void convergentsOfe() {
		int limit = 100;
		int[] ints = new int[limit];
		ints[0] = 2;
		for (Integer k = 0; k < limit - 3; k += 3) {
			ints[k + 1] = 1;
			ints[k + 2] = 2 * (k / 3 + 1);
			ints[k + 3] = 1;
		}
		BigInteger numer = BigInteger.valueOf(ints[limit - 1]), denom = BigInteger
				.valueOf(1), tem = BigInteger.valueOf(0);
		for (int i = limit - 2; i >= 0; i--) {
			tem = denom;
			denom = numer;
			numer = tem;
			numer = numer.add(denom.multiply(BigInteger.valueOf(ints[i])));
		}
		System.out.println(Digits.digitSum(numer.toString()));
	}

	public static void main(String[] args) {
		convergentsOfe();
	}

}
