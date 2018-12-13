package part2.problem111to120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithm.Digits;

public class Problem119 {

	private static final int DIGITS = 9;

	private static final int LENGTH = 9 * DIGITS + 1;

	/*
	 * Process: Brute force the solutions first see how far we could get
	 */
	public static void solve() {

		long[] powers = new long[LENGTH];

		for (int i = 2; i < LENGTH; i++) {
			powers[i] = i;
		}

		List<Long> list = new ArrayList<>();
		for (int time = 2; time < 11; time++) {
			for (int i = 2; i < LENGTH; i++) {
				powers[i] = powers[i] * i;

				if (Digits.digitSum(Long.toString(powers[i])) == i) {
					System.out.println(powers[i]);
					list.add(powers[i]);
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.get(29));
	}

	public static void main(String[] args) {
		Problem119.solve();
	}

}
