/**Try2.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 30, 2015 at 3:11:49 AM
 */
package Problem61to70;

import java.util.ArrayList;
import java.util.List;

import Algorithm.Digits;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Try2 {

	public static void problem66() {
		List<Long> squares = new ArrayList<Long>();
		squares.add((long) 0);
		int size = 5000000;
		// 1073741820l
		for (long l = 1; l < size; l++) {
			squares.add(squares.get((int) (l - 1)) + 2 * l - 1);
			// System.out.println(l);
		}
		System.out.println("okay");
		int max_D = 1;
		int square = 3;
		for (int d = 96; d < 1000; d++) {
			if (d != square * square) {

				int x = 2;
				int y = 1;
				while (squares.get(x) != d * squares.get(y) + 1) {
					double limit = Math.ceil(x / Math.sqrt(d));

					if (y < limit) {
						y += 1;
					} else {
						// System.out.println(d + "-" + x);
						x += 1;
						y = (int) Math.floor(x / Math.sqrt(d + 1));
						if (x > 1073741820l) {
							System.out.println("-------------" + d
									+ "-------------");
							break;
						}
					}
				}
				System.out.println(d + "-" + x + "-" + y);
			} else {
				square++;
			}

		}
	}

	public static boolean is_last_digit(long x, long y, long d) {
		int last_x = Digits.lastNDigits(x, 1);
		int last_y = Digits.lastNDigits(y, 1);
		int last_d = Digits.lastNDigits(d, 1);
		int last = 10 + Digits.lastNDigits(last_x * last_x, 1)
				- Digits.lastNDigits(last_y * last_y * last_d, 1);
		System.out.println(d + "-" + x + "-" + y + "-" + last);
		return Digits.lastNDigits(last, 1) == 1;
	}

	public static void main(String[] args) {
		problem66();

	}

}
