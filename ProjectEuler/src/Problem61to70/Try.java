/**Try.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 29, 2015 at 10:05:16 AM
 */
package Problem61to70;

import java.math.BigInteger;

import Algorithm.Digits;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Try {

	public static void problem66() {
		BigInteger max = new BigInteger("1");
		int max_D = 1;
		int square = 3;
		for (Integer d = 9; d < 1000; d++) {// loop d

			if (d != square * square) {

				BigInteger x = new BigInteger("2");
				BigInteger y = new BigInteger("1");
				BigInteger D = new BigInteger(d.toString());

				while (!(x.pow(2).subtract(D.multiply(y.pow(2)))).toString()
						.equals("1")) {
					// System.out.println(D + "-" + x + "-" + y);
					BigInteger limit = x.divide(BigInteger.valueOf(Math
							.round(Math.sqrt(d) - 1)));
					if (y.compareTo(limit) == -1) {// increase y
						y = y.add(BigInteger.valueOf(1));
					} else {// increase x
						x = x.add(BigInteger.valueOf(1));
						y = BigInteger.valueOf(1);
					}
				}
				System.out.println(D + "-" + x + "-" + y);
				if (x.compareTo(max) == 1) {
					max = x;
					max_D = d;
				}
			} else {
				square++;
			}
		}
		System.out.println("max_D : " + max_D);
	}

	public static boolean is_last_digit(BigInteger x, BigInteger y, BigInteger D) {
		int last_x = x.toString().charAt(x.toString().length() - 1);
		int last_y = y.toString().charAt(y.toString().length() - 1);
		int last_d = D.toString().charAt(D.toString().length() - 1);
		int last = 10 + Digits.lastNDigits(last_x * last_x, 1)
				- Digits.lastNDigits(last_y * last_y * last_d, 1);
		// System.out.println(d + "-" + x + "-" + y + "-" + last);
		return Digits.lastNDigits(last, 1) == 1;
	}

	public static void main(String[] args) {
		problem66();

	}

}
