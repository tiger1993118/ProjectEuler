package part2.problem101to110;

public class Problem109 {

	public static void solve() {
		// System.out.println(getNumberInCheckout(6));

		int sum = 0;
		for (int n = 1; n < 100; n++) {
			sum += getNumberInCheckout(n);

		}
		System.out.println(sum);

	}

	/*
	 * Calculate and return the distinct ways to finish on current score "total"
	 */
	public static int getNumberInCheckout(int total) {
		// Number of ways
		int ret = 0;
		int score = total;// The score left after the last points

		// Starting from the third(ie. last) score, it could only be scored as Double
		for (int third = 2; third <= total && third <= 50; third += 2) {

			if (third == 42) {// After 40, it is 50(ie. bulls eye)
				third = 50;
			}
			// Deduct the third score from total
			score = total - third;

			// Second score, constraint - seconds score <= first scores to make sure it
			// only has distinct ways
			for (int second = 0; second <= score / 2.; second++) {

				if (second == score / 2.) {// different scenario when the first and second having the same scores

					// same number of ways for both second and first score
					int way = getNumberInShoot(second);
					if (way == 1) {// AA. 1 way
						ret += 1;
					} else if (way == 2) {// AA, BB, AB. 3 ways
						ret += 3;
					} else if (way == 3) {// AA, BB, CC, AB, AC, BC. 6 ways
						ret += 6;
					}

				} else {

					// calculate the ways to score this second score(ie. single, double, triple)
					int secondWay = getNumberInShoot(second);

					// First score is total - third - second
					int first = score - second;
					// calculate the ways to score this first score(ie. single, double, triple)
					int firstWay = getNumberInShoot(first);

					ret += secondWay * firstWay;
				}
			}
		}
		return ret;
	}

	/*
	 * Calculate and return the number of ways to score one shoot(ie. only consider
	 * Single, Double, Third)
	 */
	public static int getNumberInShoot(int score) {

		// If current score is 0, counts as one way to score
		if (score == 0) {
			return 1;
		}

		int ret = 0;
		// If it is smaller than 20 or equal to 25, it could be achieved on single score
		if (score <= 20 || score == 25) {
			ret++;
		}
		// If score is multiplier of 2 and it is smaller than 2*20 or equal to 2*25,
		// it could be achieved on a double score
		if (score % 2 == 0 && (score <= 40 || score == 50)) {
			ret++;
		}
		// If score is multiplier of 3 and it is smaller than 3*20,
		// it could be achieved on a triple score
		if (score % 3 == 0 && score <= 60) {
			ret++;
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem109.solve();
	}

}
