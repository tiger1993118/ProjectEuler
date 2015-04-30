/**Try.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 29, 2015 at 10:05:16 AM
 */
package Problem61to70;

import java.math.BigInteger;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Try {

	public static void problem66() {
		BigInteger max = new BigInteger("1");
		int max_D = 1;
		int square = 1;
		for (Integer d = 1; d < 100; d++) {// loop d
			
			if (d != square * square) {
				BigInteger x = new BigInteger("2");
				BigInteger y = new BigInteger("1");
				BigInteger D = new BigInteger(d.toString());
				while ((x.pow(2).subtract(D.multiply(y.pow(2)))).compareTo(new BigInteger("1")) != 0) {
					// System.out.println(D + "-" + x + "-" + y);
					if (y.compareTo(x) == -1) {// increase y
						// y+=1;
						y = y.add(new BigInteger("1"));
					} else {// increase x
						x = x.add(new BigInteger("1"));
						y = new BigInteger("1");
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

	public static void main(String[] args) {
		problem66();

	}

}
