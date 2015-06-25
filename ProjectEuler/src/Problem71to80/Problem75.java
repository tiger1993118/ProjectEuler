/**Problem75.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 11:24:00 AM
 */
package Problem71to80;

import java.math.BigInteger;

import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem75 {

	static int limit = 150_0000;

	static int aLimit = 50_0000;

	public static void singularIntegerRightTriangles() {

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

	// 105005874983
	// 124905538120
	public static void singularIntegerRightTriangles2() {
		BigInteger square = BigInteger.valueOf(0);
		BigInteger[] squares = new BigInteger[limit / 2 + 1];
		for (Integer n = 1; n <= limit / 2; n++) {
			square = square.add(BigInteger.valueOf(n));
			square = square.add(BigInteger.valueOf(n - 1));
			squares[n] = square;
		}

		Prime.setPrimes(aLimit + 10_0000);
		boolean[] isPrime = Prime.getIsPrimes();

		BigInteger aSquare = BigInteger.ZERO;
		int estimate = 0;
		BigInteger total = BigInteger.ZERO;
		for (int a = 1; a < aLimit; a++) {
			aSquare = squares[a];
			if (!isPrime[a]) {
				if (a < 1225) {
					estimate = a * a / 2;
				} else {
					estimate = (limit - a) / 2;
				}
				for (int b = a + 1; b <= aLimit; b++) {
					if (!isPrime[b]) {
						int reminder = b % a;
						if (reminder != 0 && b % reminder != 0) {
							total = total.add(BigInteger.ONE);
						}
					}
				}
			}
		}
		System.out.println(total);
	}

	public static void singularIntegerRightTriangles3() {

		int aSquare = 1, estimate, bSquare, cSquare;
		double root;
		for (int a = 2; a < aLimit; a++) {
			aSquare += 2 * a - 1;
			bSquare = aSquare;
			cSquare = 2 * bSquare;
			if (a < 1225) {
				estimate = a * a / 2;
			} else {
				estimate = (limit - a) / 2;
			}
			for (int b = a + 1; b <= estimate; b++) {
				cSquare += 2 * b - 1;
				root = Math.sqrt(cSquare);
				if ((int) root == root) {
					System.out.println(a + "-" + b);
				}
			}
		}
	}

	public static void main(String[] args) {
		singularIntegerRightTriangles3();
		//System.out.println((int) Math.sqrt(5));
	}
}
