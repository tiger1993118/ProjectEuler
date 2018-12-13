package part2.problem111to120;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import algorithm.PrimeBelowN;

/**
 * Problem 118: https://projecteuler.net/problem=118
 *
 */
public class Problem118 {

	/*
	 * 1st Try:
	 * 
	 * Main Idea: Focusing on how to group the digits(i.e. 1 to 9) first, and come
	 * up with different group setting. After, compute all the combinations of the
	 * digits and group them with different group settings. Test each appointed
	 * number in every group settings to check if they are all primes. Notes: be
	 * careful when adding up the solutions, since there might be duplicate(i.e.
	 * 12|34|56 is the same as 34|12|56 in group of numbers.
	 * 
	 * 1. Computing Different set of groupings. for example, (3,3,2,1) stands for a
	 * set of numbers consisted of 3-digits, 3-digits, 2-digits and single-digit
	 * number.
	 * 
	 * 2. Applying the group setting to every combination of digits(i.e. 1 to 9).
	 * For example, applying (3,3,2,1) to 321547689 is 321,547,68,9
	 * 
	 * 3. Divided the duplicate number of settings. For example for group
	 * (3,2,2,1,1), we will divide the number of solutions of this group settings by
	 * 2*2;
	 */
	// Number of available digits
	private static int NUMBER_OF_DIGIT = 9;

	// Limit of Prime
	private static int LIMIT = (int) Math.pow(10, 8);

	private static boolean[] isPrime;

	public static void solve() {

		PrimeBelowN.setPrimes(LIMIT);

		isPrime = PrimeBelowN.getIsPrimes();

		System.out.println(recurAllGroup(NUMBER_OF_DIGIT - 1, new ArrayList<Integer>(), NUMBER_OF_DIGIT));
	}

	/*
	 * Compute all the combination of digits and apply them to group of setting
	 */
	public static int recurAllNumber(String current, Queue<Integer> digits, List<Integer> groups) {

		if (digits.size() == 0) {// Base case
			// System.out.println(current);
			// Apply the group setting to this number, and check whether they are all primes
			return groupAndPrime(current, groups);

		} else {// Recursive case

			int total = 0;

			// Copy of 'groups' to pass into next recursive call
			Queue<Integer> next_digits = new LinkedList<Integer>();
			next_digits.addAll(digits);

			for (int i = 0; i < digits.size(); i++) {

				// Remove and set the current digit
				int n = next_digits.remove();
				total += recurAllNumber(current + n, next_digits, groups);

				// Add the current digit back
				next_digits.add(n);

			}
			return total;
		}
	}

	/*
	 * Compute all the possible groups of setting and appointing digits.
	 */
	public static int recurAllGroup(int prev, List<Integer> groups, int left) {

		if (left == 0) {// Base case

			// Compute the number of duplication of this group setting
			int duplicate = 1;
			Map<Integer, Integer> map = new HashMap<>();
			for (int t : groups) {
				if (map.containsKey(t))
					map.put(t, map.get(t) + 1);
				else
					map.put(t, 1);
			}
			for (int t : map.values()) {
				for (int f = 2; f <= t; f++)
					duplicate *= f;
			}

			// Initialize the digits Queue(1 to 9)
			Queue<Integer> digits = new LinkedList<Integer>();
			for (int n = 1; n <= NUMBER_OF_DIGIT; n++) {
				digits.add(n);
			}

			int total = recurAllNumber("", digits, groups);

			// The current group
			System.out.println(groups + " - " + total + " - " + duplicate);
			return (total / duplicate);
		} else {// Recursive case, generate the number number of digits

			int total = 0;

			// The new copy of group setting
			List<Integer> next_groups = new ArrayList<>();
			next_groups.addAll(groups);

			// The next index and number of digits
			next_groups.add(0);
			int i = next_groups.size() - 1;

			for (int n = 1; n <= Math.min(prev, left); n++) {

				// Set new number of digits
				next_groups.set(i, n);

				total += recurAllGroup(n, next_groups, left - n);
			}
			return total;
		}
	}

	/*
	 * Applying the group setting to the current string(i.e. which is the number in
	 * string form), and check whether all of the numbers in the group are prime.
	 * Return 1 if they are, 0 otherwise.
	 */
	public static int groupAndPrime(String s, List<Integer> groups) {
		for (int end : groups) {
			int n = Integer.valueOf(s.substring(0, end));
			// System.out.print(n + "-");
			if (!isPrime[n])
				return 0;
			s = s.substring(end);
		}
		// System.out.println();
		return 1;
	}

	/*
	 * public static boolean isDistinctDigit(int n) { boolean[] digits = new
	 * boolean[10]; digits[0] = true; while (n != 0) { int digit = n % 10;
	 * 
	 * if (digits[digit]) return false; else digits[digit] = true; n /= 10; } return
	 * true; }
	 */

	public static void main(String[] args) {
		Problem118.solve();
	}
}
