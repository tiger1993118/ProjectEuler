/** ${file_name}
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
 */
package part1.problem051to060;

import java.math.BigInteger;

import algorithm.Digits;

/**
 * TODO It is possible to show that the square root of two can be expressed as
 * an infinite continued fraction.
 * 
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 * 
 * By expanding this for the first four iterations, we get:
 * 
 * 1 + 1/2 = 3/2 = 1.5 1 + 1/(2 + 1/2) = 7/5 = 1.4 1 + 1/(2 + 1/(2 + 1/2)) =
 * 17/12 = 1.41666... 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 * 
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth
 * expansion, 1393/985, is the first example where the number of digits in the
 * numerator exceeds the number of digits in the denominator.
 * 
 * In the first one-thousand expansions, how many fractions contain a numerator
 * with more digits than denominator?
 * 
 * Observation : Remove the 1 from each numbers, write down the series of
 * numerator and denominator, found out that the next numerator(denoted n2) =
 * this denominator(denoted d1). the next denominator(denoted d2) = d1*2 + n1.
 * After adding one to each number, counting the number of digits in new
 * numerator and denominator, compare if two are equal.
 * 
 * Solution : Two Integer one to keep track of numerator, the other one for
 * denominator. Initial value is 1 and 2. Use the algorithm above to compute new
 * number and compare and count the new numerator and denominator.
 * 
 * @author Xiu Tiger Yi
 *
 */
public class Problem57 {

	public void squareRootConvergent() {
		Integer time = 0;
		Integer count = 0;
		BigInteger numer = new BigInteger("1");
		BigInteger denom = new BigInteger("2");
		while (time < 1000) {
			Integer n1 = Digits.numOfDigits(numer.add(denom).toString());
			Integer n2 = Digits.numOfDigits(denom.toString());
			if (n1 > n2)
				count += 1;
			BigInteger tem = new BigInteger(numer.toString());
			numer = denom;
			denom = numer.multiply(new BigInteger("2")).add(tem);
			time += 1;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		new Problem57().squareRootConvergent();
	}

}
