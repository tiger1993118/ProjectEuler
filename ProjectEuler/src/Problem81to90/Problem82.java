/**Problem82.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 16, 2015 at 12:17:13 PM
 */
package Problem81to90;

import java.math.BigInteger;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem82 {

	public static void pathSumThreeWays() {
		String[][] matrix = File.readFile("raw/p082_matrix.txt", "\n", ",");
		BigInteger[][][] sumMatrix = new BigInteger[3][matrix.length][matrix.length];
		// 0 - down, 1 - up, 2 - right
		BigInteger min = new BigInteger("10000000");

		for (Integer icol = matrix.length - 1; icol >= 0; icol--) {

			for (Integer irow = matrix.length - 1; irow >= 0; irow--) {
				Integer i = 0;
				BigInteger curr = new BigInteger(matrix[irow][icol]);
				if (icol == matrix.length - 1) {
					sumMatrix[i][irow][icol] = curr;
				} else if (irow == matrix.length - 1) {
					sumMatrix[i][irow][icol] = curr
							.add(sumMatrix[2][irow][icol + 1]);
				} else {
					sumMatrix[i][irow][icol] = curr
							.add(sumMatrix[2][irow][icol + 1]
									.min(sumMatrix[i][irow + 1][icol]));
				}
			}
			for (Integer irow = 0; irow < matrix.length; irow++) {
				Integer i = 1;
				BigInteger curr = new BigInteger(matrix[irow][icol]);
				if (icol == matrix.length - 1) {
					sumMatrix[i][irow][icol] = curr;
				} else if (irow == 0) {
					sumMatrix[i][irow][icol] = curr
							.add(sumMatrix[2][irow][icol + 1]);
				} else {
					sumMatrix[i][irow][icol] = curr
							.add(sumMatrix[2][irow][icol + 1]
									.min(sumMatrix[i][irow - 1][icol]));
				}
			}
			for (Integer irow = matrix.length - 1; irow >= 0; irow--) {
				Integer i = 2;
				BigInteger curr = new BigInteger(matrix[irow][icol]);
				if (icol == matrix.length - 1) {
					sumMatrix[i][irow][icol] = curr;
				} else if (irow == matrix.length - 1) {
					sumMatrix[i][irow][icol] = curr
							.add(sumMatrix[i][irow][icol + 1]
									.min(sumMatrix[1][irow - 1][icol]));
				} else if (irow == 0) {
					sumMatrix[i][irow][icol] = curr
							.add(sumMatrix[i][irow][icol + 1]
									.min(sumMatrix[0][irow + 1][icol]));
				} else {
					sumMatrix[i][irow][icol] = curr
							.add(sumMatrix[i][irow][icol + 1].min(
									sumMatrix[0][irow + 1][icol]).min(
									sumMatrix[1][irow - 1][icol]));
				}
				if (icol == 0) {
					min = min.min(sumMatrix[i][irow][icol]);
				}
			}

		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		pathSumThreeWays();
	}
}
