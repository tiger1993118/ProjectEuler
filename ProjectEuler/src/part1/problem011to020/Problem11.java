/**Problem11.java
@author Tiger Xiu Yi yixiu17@gmail.com
Created on2014-11-27
10:39:20 PM
 */
package part1.problem011to020;

/**
 * TODO In the 20×20 grid below, four numbers along a diagonal line have been
 * marked in red. The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * 
 * What is the greatest product of four adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the 20×20 grid?
 * 
 * Solution: To Compute the greatest product, first need to transfer the 20*20
 * grid into an integer array. My trick is to use 26*26 instead, add a 3*3
 * border on to the original 20*20 grid so that i do not i have to deal with
 * many indexOutBoundExceptions. So set all those extra space in 26*26 to 0. Now
 * i have the grid, for each numbers(totally 20*20s) there are four cases to
 * compute the product, vertical, horizontal, left diagonal and right diagonal.
 * four algorithm to calculate each one.
 * 
 * The four cases algorithm needs a large amount of code, there might be a
 * better solution to reuse each one
 * 
 * @author Tiger Xiu Yi
 * 
 */
public class Problem11 {

	public static final String input = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n"
			+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n"
			+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"
			+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"
			+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"
			+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"
			+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"
			+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"
			+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n"
			+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"
			+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"
			+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"
			+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"
			+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n"
			+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n"
			+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n"
			+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n"
			+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n"
			+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n"
			+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";

	public Integer[][] grid = new Integer[26][26];

	public final String ROW = "ROWID";
	public final String COLUMN = "COLUMNID";
	public final String LDIAGONAL = "LDIAGONALID";
	public final String RDIAGONAL = "RDIAGONALID";

	public final String[] OPTIONS = { ROW, COLUMN, LDIAGONAL, RDIAGONAL };

	public Problem11() {
		grid = getExpandedGrid();
	}

	public Integer[][] getExpandedGrid() {

		String[] rows = input.split("\n");
		Integer[][] grid = new Integer[26][26];
		for (int index1 = 0; index1 < 26; index1++) {
			for (int index2 = 0; index2 < 26; index2++) {
				if (index1 < 3 || index1 > 22 || index2 < 3 || index2 > 22)
					grid[index1][index2] = 0;
			}
		}

		for (int index1 = 3; index1 < 23; index1++) {
			String[] row = rows[index1 - 3].split(" ");
			for (int index2 = 3; index2 < 23; index2++) {
				grid[index1][index2] = Integer.parseInt(row[index2 - 3]);
			}
		}
		return grid;

	}

	public void viewGrid() {
		for (int index1 = 0; index1 < 26; index1++) {
			for (int index2 = 0; index2 < 26; index2++) {
				if (grid[index1][index2] > 10)
					System.out.print(grid[index1][index2] + " ");
				else
					System.out.print(grid[index1][index2] + "  ");
			}
			System.out.print("\n");
		}
	}

	public Integer maximumProduct() {
		Integer maxProduct = 0;
		for (int row = 3; row < 23; row++) {
			for (int column = 3; column < 23; column++) {
				for (String option : OPTIONS) {
					Integer product = OptionalMProduct(row, column, option);
					if (product > maxProduct) {
						maxProduct = product;
					}
				}
			}
		}
		return maxProduct;
	}

	public Integer OptionalMProduct(Integer row, Integer column, String option) {
		Integer maxProduct = 0;
		switch (option) {
		case ROW:
			for (int current = -3; current <= 0; current++) {
				Integer currentColumn = column + current;
				Integer currentPro = grid[row][currentColumn]
						* grid[row][currentColumn + 1]
						* grid[row][currentColumn + 2]
						* grid[row][currentColumn + 3];
				if (maxProduct < currentPro)
					maxProduct = currentPro;
			}
			break;
		case COLUMN:
			for (int current = -3; current <= 0; current++) {
				Integer currentRow = row + current;
				Integer currentPro = grid[currentRow][column]
						* grid[currentRow + 1][column]
						* grid[currentRow + 2][column]
						* grid[currentRow + 3][column];
				if (maxProduct < currentPro)
					maxProduct = currentPro;
			}
			break;
		case LDIAGONAL:
			for (int current = -3; current <= 0; current++) {
				Integer currentRow = row + current;
				Integer currentColumn = column + current;
				Integer currentPro = grid[currentRow][currentColumn]
						* grid[currentRow + 1][currentColumn + 1]
						* grid[currentRow + 2][currentColumn + 2]
						* grid[currentRow + 3][currentColumn + 3];
				if (maxProduct < currentPro)
					maxProduct = currentPro;
			}
			break;
		case RDIAGONAL:
			for (int current = -3; current <= 0; current++) {
				Integer currentRow = row + current;
				Integer currentColumn = column - current;
				Integer currentPro = grid[currentRow][currentColumn]
						* grid[currentRow + 1][currentColumn - 1]
						* grid[currentRow + 2][currentColumn - 2]
						* grid[currentRow + 3][currentColumn - 3];
				if (maxProduct < currentPro)
					maxProduct = currentPro;
			}
			break;
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		Problem11 P11 = new Problem11();
		System.out.println(P11.maximumProduct());

	}
}
