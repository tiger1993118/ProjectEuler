package part2.problem111to120;

/**
 * Problem 120: https://projecteuler.net/problem=120
 */
public class Problem120 {

	/*
	 * Progress: Try expanding the equation first see to find clue
	 * 
	 * Main Idea: First keeping the equation E = (a-1)^n + (a+1)^n, and after
	 * simplifying the equation, we have two result depending if n is odd or even.
	 * 
	 * if n is even, E = 2; if n is odd, E = 2*n*a.
	 * 
	 * We could ignore the case n is even, since the value(i.e. 2 mod a^2) is
	 * smaller than n is odd (i.e. 2*n*a mod a^2)
	 * 
	 * And in the case of a, we could have a is even or odd
	 * 
	 * If a is odd, we could have the max value (a-1)*a (i.e. mod a^2) ;-----------
	 * If a is even, we could the max (a-2)*a (i.e. mod a^2)
	 *
	 * Lastly add them up.
	 */
	public static void solve() {

		long total = 0;

		for (int a = 3; a <= 1000; a++) {

			if (a % 2 == 0) {// a is even
				total += a * (a - 2);
			} else {// a is odd
				total += a * (a - 1);
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		Problem120.solve();

	}

}
