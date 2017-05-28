/**Problem87.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jun 25, 2015 at 10:29:58 PM
 */
package part1.problem081to090;

import java.util.ArrayList;
import java.util.List;

import algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem87 {

	public static void primePowerTriples() {
		int limit = 5000_0000;
		Prime.setPrimes(limit);
		List<Integer> primes = Prime.getPrimes();
		List<Integer> squares = new ArrayList<Integer>();
		List<Integer> cubes = new ArrayList<Integer>();
		List<Integer> fourths = new ArrayList<Integer>();
		boolean[] isSum = new boolean[limit];
		for (Integer prime : primes) {
			int curr = prime * prime;
			if (curr >= limit) {
				break;
			}
			squares.add(curr);

		}
		for (Integer prime : primes) {
			int curr = prime * prime * prime;
			if (curr >= limit) {
				break;
			}
			cubes.add(curr);

		}
		for (Integer square : squares) {
			int curr = square * square;
			if (curr >= limit) {
				break;
			}
			fourths.add(curr);
		}
		for (Integer fourth : fourths) {
			for (Integer cube : cubes) {
				Integer sum = limit - fourth;
				if (cube >= sum) {
					break;
				} else {
					for (Integer square : squares) {
						sum = limit - fourth - cube;
						if (square > sum) {
							break;
						} else {
							isSum[square + cube + fourth] = true;
						}
					}
				}
			}
		}
		Integer count = 0;
		for (boolean b : isSum) {
			count += b ? 1 : 0;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		primePowerTriples();

	}

}
