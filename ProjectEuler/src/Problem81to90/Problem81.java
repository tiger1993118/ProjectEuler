/**Problem81.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 16, 2015 at 11:49:55 AM
 */
package Problem81to90;

import java.math.BigInteger;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem81 {

	public static void pathSumTwoWays() {
		String[][] matrix = File.readFile("raw/p081_matrix.txt", "\n", ",");
		BigInteger[][] sumMatrix = new BigInteger[matrix.length][matrix.length];
		for (Integer irow = matrix.length - 1; irow >= 0; irow--) {
			for (Integer icol = matrix.length - 1; icol >= 0; icol--) {
				BigInteger curr = new BigInteger(matrix[irow][icol]);
				if (irow == matrix.length - 1 && icol == matrix.length - 1) {
					sumMatrix[irow][icol] = curr;
				} else if (irow == matrix.length - 1) {
					sumMatrix[irow][icol] = curr.add(sumMatrix[irow][icol + 1]);
				} else if (icol == matrix.length - 1) {
					sumMatrix[irow][icol] = curr.add(sumMatrix[irow + 1][icol]);
				} else {
					sumMatrix[irow][icol] = curr.add(sumMatrix[irow + 1][icol]
							.min(sumMatrix[irow][icol + 1]));
				}
			}
		}
		System.out.println(sumMatrix[0][0]);
	}

	public static void main(String[] args) {
		pathSumTwoWays();
	}

}
