package part2.problem111to120;

/**
 * Problem 120: https://projecteuler.net/problem=120
 */
public class Problem120 {

	/*
	 * Progress: Try expanding the equation first see to find clue
	 */
	public static void solve() {

		long total = 0;

		for (int a = 3; a <= 1000; a++) {

			if (a % 2 == 0) {
				total += a * (a - 2);
			} else {
				total += a * (a - 1);
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		Problem120.solve();

	}

}
