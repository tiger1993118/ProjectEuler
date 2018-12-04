package part2.problem101to110;

/**
 * Problem 109: user In the game of darts a player throws three darts at a
 * target board which is split into twenty equal sized sections numbered one to
 * twenty.
 * 
 * 
 * The score of a dart is determined by the number of the region that the dart
 * lands in. A dart landing outside the red/green outer ring scores zero. The
 * black and cream regions inside this ring represent single scores. However,
 * the red/green outer ring and middle ring score double and treble scores
 * respectively.
 * 
 * At the centre of the board are two concentric circles called the bull region,
 * or bulls-eye. The outer bull is worth 25 points and the inner bull is a
 * double, worth 50 points.
 * 
 * There are many variations of rules but in the most popular game the players
 * will begin with a score 301 or 501 and the first player to reduce their
 * running total to zero is a winner. However, it is normal to play a "doubles
 * out" system, which means that the player must land a double (including the
 * double bulls-eye at the centre of the board) on their final dart to win; any
 * other dart that would reduce their running total to one or lower means the
 * score for that set of three darts is "bust".
 * 
 * When a player is able to finish on their current score it is called a
 * "checkout" and the highest checkout is 170: T20 T20 D25 (two treble 20s and
 * double bull).
 * 
 * There are exactly eleven distinct ways to checkout on a score of 6:
 * 
 * 
 * D3
 * 
 * 
 * D1 D2 S2 D2 D2 D1 S4 D1 S1 S1 D2 S1 T1 D1 S1 S3 D1 D1 D1 D1 D1 S2 D1 S2 S2 D1
 * Note that D1 D2 is considered different to D2 D1 as they finish on different
 * doubles. However, the combination S1 T1 D1 is considered the same as T1 S1
 * D1.
 * 
 * In addition we shall not include misses in considering combinations; for
 * example, D3 is the same as 0 D3 and 0 0 D3.
 * 
 * Incredibly there are 42336 distinct ways of checking out in total.
 * 
 * How many distinct ways can a player checkout with a score less than 100?
 */
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
