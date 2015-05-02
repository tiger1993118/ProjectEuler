/**Try3.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 30, 2015 at 5:39:59 AM
 */
package Problem61to70;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Try3 {

	public static void problem66() {
		int max_D = 1;
		int square = 3;
		for (int d = 9; d < 1000; d++) {
			if (d != square * square) {

				int x = 2;
				int y = 1;
				while (x * x - d * y * y != 1) {

					if (y <= x) {
						y += 1;
					} else {
						x += 1;
						y = 1;
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

	public static void main(String[] args) {
		problem66();

	}

}
