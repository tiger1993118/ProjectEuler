/**Problem18.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-11-30
2:50:29 PM
 */
package Problem11to20;

/**
 * TODO By starting at the top of the triangle below and moving to adjacent
 * numbers on the row below, the maximum total from top to bottom is 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * Solution: Firstly, format the input into a 2 dimensional Integer array, such
 * that array[x][y] represent (x+1)th row and (n+1)th number in the triangle.
 * Use delimiter '\n' and ' ' to achieve this goal.Once we have the array, we
 * will find the maximum path sum by looping through every rows. After
 * observation, i found out that every numbers at position p in each row n, its
 * income of sum only come from 2 cases, either the number at p in row n-1, or
 * the number at p-1 in row n-1.e.g, income of Array[a][b] is either from
 * Array[a-1][b-1] or Array[a-1][b], so that we could compute every sum at row
 * from different paths till this row.(Be careful with the corner case at
 * position 0 or last one, their income only have 1 case).Starting from row 0 to
 * last row we have every different sum stored in current row.For the last row,
 * we have different sums which were come from every rows and every paths.
 * Simply pick the largest one, that is the final answer.
 * 
 * @author Tiger yi
 * 
 */
public class Problem18 {

	public final static String input = "75\n" + "95 64\n" + "17 47 82\n"
			+ "18 35 87 10\n" + "20 04 82 47 65\n" + "19 01 23 75 03 34\n"
			+ "88 02 77 73 07 63 67\n" + "99 65 04 28 06 16 70 92\n"
			+ "41 41 26 56 83 40 80 70 33\n"
			+ "41 48 72 33 47 32 37 16 94 29\n"
			+ "53 71 44 65 25 43 91 52 97 51 14\n"
			+ "70 11 33 28 77 73 17 78 39 68 17 57\n"
			+ "91 71 52 38 17 14 91 43 58 50 27 29 48\n"
			+ "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n"
			+ "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

	public Integer size = 15;

	public Integer[][] triangle;

	public Problem18() {
		triangle = new Integer[size][size];
		getTriangle();
	}

	public Integer maximumPathSum() {
		Integer max = 0;
		for (Integer row = 1; row < size; row++) {
			for (Integer n = 0; n < row + 1; n++) {
				if (n == 0) {
					triangle[row][0] += triangle[row - 1][0];
				} else if (n == row) {
					triangle[row][row] += triangle[row - 1][row - 1];
				} else {
					triangle[row][n] += Math.max(triangle[row - 1][n - 1],
							triangle[row - 1][n]);
				}
			}
		}

		for (Integer n = 0; n < size; n++) {
			max = Math.max(triangle[size - 1][n], max);
		}
		return max;
	}

	public void getTriangle() {
		String[] sRow = input.split("\n");
		for (Integer i = 0; i < size; i++) {
			String[] sN = sRow[i].split(" ");
			for (Integer n = 0; n < i + 1; n++) {
				triangle[i][n] = Integer.parseInt(sN[n]);
			}
		}
	}

	public static void main(String[] args) {
		Problem18 P18 = new Problem18();
		System.out.println(P18.maximumPathSum());
	}
}
