/**Problem94.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 13, 2015 at 2:14:02 PM
 */
package part1.problem091to100;

import java.math.BigInteger;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem94 {

	public static void almostEquilateralTriangles() {
		Integer limit = 166_666_667;
		BigInteger square1 = BigInteger.ZERO;
		Integer squareIndex1 = 1;
		BigInteger height1 = BigInteger.ZERO;

		BigInteger square2 = BigInteger.ZERO;
		Integer squareIndex2 = 1;
		BigInteger height2 = BigInteger.valueOf(8);

		BigInteger total = BigInteger.ZERO;

		for (Integer i = 1; i <= limit; i++) {
			height1 = height1.add(BigInteger.valueOf(6 * i - 1));
			while (square1.compareTo(height1) == -1) {
				square1 = square1.add(BigInteger.valueOf(2 * squareIndex1 - 1));
				squareIndex1++;
			}
			if (square1.compareTo(height1) == 0) {
				// System.out.println(i + "-" + height1);
				total = total.add(BigInteger.valueOf((i + 1) * 2 * 3 - 2));
			}

			height2 = height2.add(BigInteger.valueOf(6 * i + 7));
			while (square2.compareTo(height2) == -1) {
				square2 = square2.add(BigInteger.valueOf(2 * squareIndex2 - 1));
				squareIndex2++;
			}
			if (square2.compareTo(height2) == 0) {
				// System.out.println(2 + "-" + i + "-" + height2);
				total = total.add(BigInteger.valueOf((i + 1) * 2 * 3 + 2));
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		almostEquilateralTriangles();
	}

}
