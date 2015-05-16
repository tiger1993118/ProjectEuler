/**Problem75.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 11:24:00 AM
 */
package Problem71to80;

import java.math.BigInteger;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem75 {

	public static void singularIntegerRightTriangles() {
		int limit = 1_500_000;
		boolean[] isRightTri = new boolean[limit];
		// BigInteger a_square = new BigInteger("0");
		BigInteger square = BigInteger.valueOf(0);
		BigInteger[] squares = new BigInteger[limit / 2 + 1];
		for (Integer n = 1; n <= limit / 2; n++) {
			square = square.add(BigInteger.valueOf(n));
			square = square.add(BigInteger.valueOf(n - 1));
			squares[n] = square;
		}

		for (Integer L = 12; L < limit; L += 2) {
			if (!isRightTri[L]) {
				System.out.println(L);
				for (Integer i = 1; i < (double) L / 3; i++) {
					BigInteger m_square = squares[L - i];
					BigInteger a_square = squares[i];
					BigInteger m_2 = BigInteger.valueOf((L - i) * 2);
					if (m_square.subtract(a_square).mod(m_2)
							.equals(BigInteger.valueOf(0))) {
						// System.out.println(i + "-" + L);
						for (Integer n = L; n < limit; n += L) {
							isRightTri[n] = true;
						}
					}
				}
			}
		}
		// for (Integer a = 1; a < 500_000; a++) {
		// a_square = a_square.add(BigInteger.valueOf(a * 2 - 1));
		// if (a < 1225) {
		// estimate = a * a / 2;
		//
		// } else {
		// estimate = (limit - a) / 2;
		// }
		// BigInteger c_square = a_square.add(a_square);
		// System.out.println(a + "-" + a_square + "-" + estimate);
		// for (Integer b = a + 1; b <= estimate; b++) {
		// c_square.add(BigInteger.valueOf(b * 2 - 1));
		// }
		// }
	}



	public static void main(String[] args) {
		singularIntegerRightTriangles();
	}
}
