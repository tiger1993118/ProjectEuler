/**Problem85.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jun 24, 2015 at 9:31:25 PM
 */
package part1.problem081to090;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem85 {

	public static void countingRectangles() {
		int diff = 100000;
		int goal = 200_0000;
		int[] goal_area = { 0, 0 };
		for (int w = 1; w < 2000; w++) {
			int count = w * (w + 1) / 2;
			int total = 0;
			int l = 0;
			while (total < goal) {
				l++;
				total += count * l;
			}
			if (total - goal < diff) {
				diff = total - goal;
				goal_area[0] = w;
				goal_area[1] = l;
				System.out.println(w + "-" + l + "-" + total);
			}
			if (goal - (total - count * l) < diff) {
				diff = goal - (total - count * l);
				goal_area[0] = w;
				goal_area[1] = l;
				System.out.println(w + "-" + (l - 1) + "-"
						+ (total - count * l));
			}

		}
	}

	public static void main(String[] args) {
		countingRectangles();
	}
}
