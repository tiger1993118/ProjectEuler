package part2.problem111to120;

/**
 * Problem 117: https://projecteuler.net/problem=117
 *
 */
public class Problem117 {

	private static final int LENGTH = 51;

	/*
	 * Main Idea: Similar to Problem 116, I will solve the problem with Dynamic
	 * Programming, and work my solution bottom-up. To break up the problem, we will
	 * look at the 1st block and we have a decision to make, since we could either
	 * choose no tile(i.e. black) or tile.-----------------------------------------
	 * 
	 * -- If the first one is no tile, Solve(n) will become Solve(n-1) -------------
	 * -- If the first one has a tile, it will go either red, green or blue. ------
	 * --- For different color tiles, we would skip different number of tiles
	 * depending on the length of the tile -----------------------------------------
	 * Lastly, we will add all the smaller solutions
	 * 
	 * 1. Initialize data structure ------------------------------------------------
	 * 2. Base case ----------------------------------------------------------------
	 * 3. Iteratively work the solution bottom-up
	 * 
	 */
	public static void solve() {

		long[] ways = new long[LENGTH];

		// Base case
		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;
		ways[3] = 4;
		ways[4] = 8;

		// Recursive
		for (int i = 5; i < LENGTH; i++) {

			long total = 0;

			total += ways[i - 1];// First block have NO tile
			total += ways[i - 2];// First 2 blocks are RED
			total += ways[i - 3];// First 3 blocks are GREEN
			total += ways[i - 4];// First 4 blocks are BLUE

			ways[i] = total;
		}
		System.out.println(ways[LENGTH - 1]);
	}

	public static void main(String[] args) {
		Problem117.solve();

	}

}
