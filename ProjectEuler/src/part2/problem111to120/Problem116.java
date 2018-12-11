package part2.problem111to120;

/**
 * Problem 116: https://projecteuler.net/problem=116
 *
 */
public class Problem116 {

	// Measuring the number of ways to replace 50 units of black tiles
	private static final int LENGTH = 51;

	// 3 different tiles
	private static final int TILES = 3;

	// different lengths for different color of tiles
	private static final int RED = 2;
	private static final int GREEN = 3;
	private static final int BLUE = 4;
	// for the convenience of looping
	private static final int[] COLORS = new int[] { RED, GREEN, BLUE };

	/*
	 * Main Idea: Solving the question using Dynamic Programming, and we will work
	 * our solution bottom-up and save every number of ways in an array 'ways', for
	 * which red_ways[i] represents the number of ways to replace tiles of length i
	 * in red tiles(i.e. length two), so does green_ways[i] and blue_ways[i].
	 * Lastly, add them up to compute the the total ways of replacement. ----------
	 * NOTES: I assign red _ways[i] to represent the number of ways to cover the
	 * black tiles that ALLOWING no red tile to be used(i.e. Solution could be all
	 * Blacks), since this would make the dynamic programming much easier, and in
	 * the end, just deduct 1 from the final solution.
	 * 
	 * 1. Initialize all three arrays representing the solution of three colors.--
	 * 2. Different base case for three arrays.-----------------------------------
	 * 3. Iteratively run the bottom-up solutions. -------------------------------
	 */
	public static void solve() {

		long total = 0;

		// Number of ways to cover the length n tile in different tile
		long[][] ways = new long[TILES][];
		// ways[0] is the array that stores the number of ways to cover tiles with RED
		// way[1] - GREEN, way[2] - BLUE
		for (int i = 0; i < TILES; i++) {
			ways[i] = new long[LENGTH];
		}

		// base case
		for (int i = 0; i < TILES; i++) {
			for (int k = 0; k < COLORS[i]; k++) {
				ways[i][k] = 1;
			}
		}

		// Bottom-up solution
		for (int i_color = 0; i_color < TILES; i_color++) {
			for (int i_len = COLORS[i_color]; i_len < LENGTH; i_len++) {

				long count = 0;

				// Algorithm: Blocks[n] = Blocks[n-1] + Blocks[n-length_of_tile]
				count += ways[i_color][i_len - 1];
				count += ways[i_color][i_len - COLORS[i_color]];

				ways[i_color][i_len] = count;
			}
		}
		// Deduct 1 from each way for the all black pattern(i.e. no replacement)
		total = ways[0][LENGTH - 1] + ways[1][LENGTH - 1] + ways[2][LENGTH - 1] - 3;
		System.out.println(total);
	}

	public static void main(String[] args) {
		Problem116.solve();

	}

}
