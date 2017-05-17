/**Problem91.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 6, 2015 at 2:05:58 PM
 */
package part1.problem091to100;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem91 {

	public static void rightTrianglesWithIntegerCoordinates() {
		int limit = 50;
		int total = 0;
		for (int px = 0; px <= limit; px++) {
			for (int py = 1; py <= limit; py++) {
				for (int qx = px; qx <= limit; qx++) {
					for (int qy = 0; qy <= py; qy++) {
						// System.out.println(px + "-" + py + "-" + qx + "-" +
						// qy);
						int a_square = px * px + py * py;
						int b_square = qx * qx + qy * qy;
						int c_square = (qx - px) * (qx - px) + (py - qy)
								* (py - qy);
						if (a_square != 0 && b_square != 0 && c_square != 0) {
							if (a_square > b_square && a_square > c_square) {
								if (b_square + c_square == a_square) {
									total++;
									System.out.println("(" + px + "," + py
											+ ")" + "-" + "(" + qx + "," + qy
											+ ")");
								}
							} else if (b_square > a_square
									&& b_square > c_square) {
								if (a_square + c_square == b_square) {
									total++;
									System.out.println("(" + px + "," + py
											+ ")" + "-" + "(" + qx + "," + qy
											+ ")");
								}
							} else {
								if (a_square + b_square == c_square) {
									total++;
									System.out.println("(" + px + "," + py
											+ ")" + "-" + "(" + qx + "," + qy
											+ ")");
								}
							}
						}
					}
				}
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		rightTrianglesWithIntegerCoordinates();

	}

}
