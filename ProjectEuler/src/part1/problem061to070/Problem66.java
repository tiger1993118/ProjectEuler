/**Problem66.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 29, 2015 at 5:25:44 AM
 */
package part1.problem061to070;

import Algorithm.Digits;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem66 {

	public static int[] xs = { 0, 1, 4, 5, 6, 9 };

	public static int[][] d_possible_x = { { 1, 9 }, { 0, 1, 4, 5, 6, 9 },
			{ 1, 3, 7, 9 }, { 1, 2, 3, 4, 6, 7, 8, 9 }, { 1, 5, 9 },
			{ 1, 4, 6, 9 }, { 1, 5, 9 }, { 1, 2, 3, 4, 6, 7, 8, 9 },
			{ 1, 3, 7, 9 }, { 0, 1, 4, 5, 6, 9 } };

	public static int[][] x_possible_y = { { 1, 3, 7, 9 },
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 3, 7, 9 },
			{ 1, 2, 3, 4, 6, 7, 8, 9 }, { 1, 3, 5, 7, 9 },
			{ 1, 2, 3, 4, 6, 7, 8, 9 } };

	public static void problem66() {
		int max = 1;
		int max_D = 1;
		int square = 1;
		for (int D = 1; D < 1000; D++) {// loop D

			// Get possible x using D
			int D_last_digit = Digits.lastNDigits(D, 1);
			int x_index = 0;
			int[] possible_x = d_possible_x[D_last_digit];
			int x = possible_x[x_index];

			if (D != square * square) {

				// Get possible y using x
				int x_last_digit = get_x_last_digit(x);
				int y_index = 0;
				int[] possible_y = x_possible_y[x_last_digit];
				int y = possible_y[y_index];
				if (y == 0) {
					y_index += 1;
					y = possible_y[y_index];
				}

				while ((x * x - D * y * y) != 1) {

					// System.out.println(D + "-" + x + "-" + y);
					if (y < x) {// increase y
						// y+=1;
						y_index += 1;
						if (y_index == possible_y.length) {
							y += (10 + possible_y[0] - possible_y[y_index - 1]);
							y_index = 0;
						} else {
							y += (possible_y[y_index] - possible_y[y_index - 1]);
						}
					} else {// increase x
						x_index += 1;
						if (x_index == possible_x.length) {
							x += (10 + possible_x[0] - possible_x[x_index - 1]);
							x_index = 0;
						} else {
							x += (possible_x[x_index] - possible_x[x_index - 1]);
						}
						x_last_digit = get_x_last_digit(x);
						y_index = 0;
						possible_y = x_possible_y[x_last_digit];
						y = possible_y[y_index];
						if (y == 0) {
							y_index += 1;
							y = possible_y[y_index];
						}
					}
				}
				System.out.println(D + "-" + x + "-" + y);
				if (x > max) {
					max = x;
					max_D = D;
				}
			} else {
				square++;

			}
		}
		System.out.println("max D: " + max_D);
	}

	public static int get_x_last_digit(int x) {
		int x_last_digit = Digits.lastNDigits(x * x, 1);
		for (int index = 0; index < xs.length; index++) {
			if (xs[index] == x_last_digit) {
				return index;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		problem66();
	}

}
