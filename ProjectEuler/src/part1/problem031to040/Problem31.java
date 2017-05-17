/**Problem31.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-11
11:17:20 PM
 */
package part1.problem031to040;

/**
 * TODO In England the currency is made up of pound, £, and pence, p, and there
 * are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p). It is possible to make £2
 * in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p How many different ways can £2 be
 * made using any number of coins?
 * 
 * Observation: Every time you pick a coin, there is only 2 options, you pick
 * this coin or not. The total number of ways to pick at every choice point is
 * equal to sum of number of ways to pick this coin + number of ways not to pick
 * this coin.And the total amount of value left is the current total value - the
 * value of current coin. Repeat this till the total amount of value left is
 * smaller than the value of current coin, you could only pass this coin, to
 * next coin(smaller value).
 * 
 * Solution: sort the coin is decreasing order. starting with current coin 200,
 * and current total value is 200. return the sum as i describe in the above
 * observation. Repeat it till we get to the last coin which is 1.
 * 
 * @author Tiger yi
 * 
 */
public class Problem31 {

	public int[] coins = { 200, 100, 50, 20, 10, 5, 2, 1 };

	public void coinSums() {
		System.out.println(coinSumsHelper(200, 0));
	}

	public int coinSumsHelper(int left, int i) {
		int ways = 0;
		while (left >= 0) {
			if (left == 0) {
				ways += 1;
			} else if (left > 0) {
				if (i < (coins.length - 1))
					ways += coinSumsHelper(left, i + 1);
			}
			left = left - coins[i];
		}
		return ways;
	}

	public static void main(String[] args) {
		new Problem31().coinSums();

	}

}
