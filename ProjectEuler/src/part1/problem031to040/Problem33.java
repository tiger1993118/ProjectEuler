/**Problem33.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
1:26:00 AM
 */
package part1.problem031to040;

/**
 * TODO The fraction 49/98 is a curious fraction, as an inexperienced
 * mathematician in attempting to simplify it may incorrectly believe that 49/98
 * = 4/8, which is correct, is obtained by cancelling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * 
 * There are exactly four non-trivial examples of this type of fraction, less
 * than one in value, and containing two digits in the numerator and
 * denominator.
 * 
 * If the product of these four fractions is given in its lowest common terms,
 * find the value of the denominator.
 * 
 * Solution : loop through every two digit number from 10 to 98 for numerator,
 * from (numerator+1) to 99 for denominator such that denominator is larger than
 * numerator. separate tenth digit and ones digit from both numerator and
 * denominator. Compare if either two are equal, and then get quotient from the
 * other two numbers. return True if it is the same as the original quotient.
 * 
 * @author Tiger yi
 * 
 */
public class Problem33 {

	public void digitCancelling() {
		for (int numerator = 10; numerator < 99; numerator++) {
			for (int denominator = numerator + 1; denominator < 100; denominator++) {
				if (numerator % 10 != 0 && denominator % 10 != 0) {
					int nten = numerator / 10;
					int none = numerator - nten * 10;
					int dten = denominator / 10;
					int done = denominator - dten * 10;
					float correct = (float) numerator / denominator;

					if ((nten == dten) && (correct == (float) none / none)) {
						System.out.println(numerator + "/" + denominator);
					} else if ((nten == done)
							&& (correct == (float) none / dten)) {
						System.out.println(numerator + "/" + denominator);
					} else if ((none == dten)
							&& (correct == (float) nten / done)) {
						System.out.println(numerator + "/" + denominator);
					} else if ((none == done)
							&& (correct == (float) nten / dten)) {
						System.out.println(numerator + "/" + denominator);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Problem33().digitCancelling();
	}
}
