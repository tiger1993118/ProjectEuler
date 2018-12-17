package part2.problem121to130;

import org.apache.commons.math3.fraction.BigFraction;

/**
 * Problem121: https://projecteuler.net/problem=121
 *
 */
public class Problem121 {

	// Number of turns in total
	private final static int TURNS = 15;

	// Array of every percentages that red discs is selected
	private final static BigFraction[] PERCENTAGES = new BigFraction[TURNS];

	/*-
	 ** Process:
	 * 1. Compute all the permutations of winning combo
	 * 2. Apply the indices of permutations to the percentage of winning
	 * 3. Add the percentages up 
	 * 4. Compute the final winning prize
	 */
	public static void solve() {

		// Initialize the array of percentages
		for (int i = 0; i < TURNS; i++) {
			PERCENTAGES[i] = new BigFraction(i + 1, i + 2);
		}

		// Initially, no Blue disk is selected
		boolean[] initial_selected = new boolean[TURNS];

		// Total Probability
		BigFraction total = BigFraction.ZERO;

		for (int n = TURNS / 2 + 1; n <= TURNS; n++) {
			total = total.add(recurPermutation(initial_selected, 0, n));
		}
		System.out.println(total.reciprocal().intValue());
	}

	public static BigFraction recurPermutation(boolean[] selected, int level, int availablity) {

		if (availablity == 0) {// Base case, found a permutation

			// Apply current permutation to the probability
			BigFraction f = computeProbabliity(selected);

			return f;

		} else {// Recursively compute all the permutations

			// Total Probability
			BigFraction total = BigFraction.ZERO;
			// We are selecting a new disk, -1 in available places
			availablity -= 1;

			for (int i = level; i < (TURNS - availablity); i++) {

				// Select current index, set it to true
				selected[i] = true;

				// With current index, call the next recursive function
				total = total.add(recurPermutation(selected, i + 1, availablity));

				// Reset the value back to false
				selected[i] = false;
			}
			return total;
		}
	}

	/*
	 * Compute and return the total probability of current selected permutations of
	 * blue and red disks
	 */
	private static BigFraction computeProbabliity(boolean[] selected) {

		BigFraction ret = BigFraction.ONE;

		for (int i = 0; i < selected.length; i++) {

			if (selected[i]) {// the probability of a blue disk is selected in this round

				ret = ret.multiply(BigFraction.ONE.subtract(PERCENTAGES[i]));

			} else {// the probability of a red disk is selected in this round

				ret = ret.multiply(PERCENTAGES[i]);
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem121.solve();
	}

}
