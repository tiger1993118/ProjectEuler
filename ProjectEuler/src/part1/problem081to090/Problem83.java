/**Problem83.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 18, 2015 at 8:20:16 PM
 */
package part1.problem081to090;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem83 {

	static String[][] matrix = File.readFile("raw/p083_matrix.txt", "\n", ",");

	// static String[][] matrix = { { "131", "673", "234", "103", "18" },
	// { "201", "96", "342", "965", "150" },
	// { "630", "803", "746", "422", "111" },
	// { "537", "699", "497", "121", "956" },
	// { "805", "732", "524", "37", "331" } };

	static int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;

	static BigInteger[][] sumMatrix = null;

	public static void pathSumFourWays2() {
		sumMatrix = Problem81.pathSumTwoWays(matrix);
		List<Integer> moves = getMoves();
		boolean updated = false;
		do {
			updated = false;
			int irow = matrix.length - 1, icol = matrix.length - 1;
			for (int i = 0; i < moves.size(); i++) {
				int move = moves.get(i);
				if (move == LEFT) {
					icol -= 1;
				} else if (move == RIGHT) {
					icol += 1;
				} else if (move == UP) {
					irow -= 1;
				} else {
					irow += 1;
				}
				int rightRow = irow, downRow = Math.min(irow + 1,
						matrix.length - 1), rightCol = Math.min(icol + 1,
						matrix.length - 1), downCol = icol;
				BigInteger curr = sumMatrix[irow][icol];
				BigInteger rightSum = sumMatrix[rightRow][rightCol];
				BigInteger downSum = sumMatrix[downRow][downCol];
				BigInteger rightNew = curr.add(new BigInteger(
						matrix[rightRow][rightCol]));
				BigInteger downNew = curr.add(new BigInteger(
						matrix[downRow][downCol]));
				if (rightNew.compareTo(rightSum) == -1) {
					updated = true;
					updateSumMatrix(rightRow, rightCol, rightNew);
					break;
				}
				if (downNew.compareTo(downSum) == -1) {
					updated = true;
					updateSumMatrix(downRow, downCol, downNew);
					break;
				}
			}
			if (updated) {
				moves = getMoves();
			}
		} while (updated);
		System.out.println(sumMatrix[0][0]);
	}

	private static List<Integer> getMoves() {
		List<Integer> moves = new ArrayList<Integer>();
		for (int irow = 0, icol = 0; irow != matrix.length - 1
				|| icol != matrix.length - 1;) {
			int leftRow = irow, rightRow = irow, upRow = Math.max(irow - 1, 0), downRow = Math
					.min(irow + 1, matrix.length - 1), leftCol = Math.max(
					icol - 1, 0), rightCol = Math.min(icol + 1,
					matrix.length - 1), upCol = icol, downCol = icol;
			BigInteger leftSum = sumMatrix[leftRow][leftCol];
			BigInteger rightSum = sumMatrix[rightRow][rightCol];
			BigInteger upSum = sumMatrix[upRow][upCol];
			BigInteger downSum = sumMatrix[downRow][downCol];
			BigInteger min = leftSum.min(rightSum).min(upSum).min(downSum);

			if (min.equals(leftSum)) {
				icol -= 1;
				moves.add(0, RIGHT);
			} else if (min.equals(rightSum)) {
				icol += 1;
				moves.add(0, LEFT);
			} else if (min.equals(upSum)) {
				irow -= 1;
				moves.add(0, DOWN);
			} else {
				irow += 1;
				moves.add(0, UP);
			}
		}
		return moves;
	}

	private static void updateSumMatrix(int irow, int icol, BigInteger newSum) {
		int leftRow = irow, rightRow = irow, upRow = Math.max(irow - 1, 0), downRow = Math
				.min(irow + 1, matrix.length - 1), leftCol = Math.max(icol - 1,
				0), rightCol = Math.min(icol + 1, matrix.length - 1), upCol = icol, downCol = icol;
		sumMatrix[irow][icol] = newSum;
		BigInteger leftSum = sumMatrix[leftRow][leftCol];
		BigInteger rightSum = sumMatrix[rightRow][rightCol];
		BigInteger upSum = sumMatrix[upRow][upCol];
		BigInteger downSum = sumMatrix[downRow][downCol];
		BigInteger leftNew = newSum
				.add(new BigInteger(matrix[leftRow][leftCol]));
		BigInteger rightNew = newSum.add(new BigInteger(
				matrix[rightRow][rightCol]));
		BigInteger upNew = newSum.add(new BigInteger(matrix[upRow][upCol]));
		BigInteger downNew = newSum
				.add(new BigInteger(matrix[downRow][downCol]));
		if (leftNew.compareTo(leftSum) == -1) {
			updateSumMatrix(leftRow, leftCol, leftNew);
		}
		if (rightNew.compareTo(rightSum) == -1) {
			updateSumMatrix(rightRow, rightCol, rightNew);
		}
		if (upNew.compareTo(upSum) == -1) {
			updateSumMatrix(upRow, upCol, upNew);
		}
		if (downNew.compareTo(downSum) == -1) {
			updateSumMatrix(downRow, downCol, downNew);
		}
	}

	public static void main(String[] args) {
		pathSumFourWays2();
	}

}
