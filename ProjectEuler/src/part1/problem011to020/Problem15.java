/**Problem15.java
TODO
@author Tiger Yi yixiu17@gmail.com
Created on2014-11-28
5:26:06 PM
 */
package part1.problem011to020;

/**
 * 
 * TODO Starting in the top left corner of a 2×2 grid, and only being able to
 * move to the right and down, there are exactly 6 routes to the bottom right
 * corner.
 * 
 * 
 * How many such routes are there through a 20×20 grid?
 * 
 * 
 * Solution : I solved it with dynamic programming, which compute routes from
 * the very left-top corner (0,0) to every point (a,b) such that a <= 20, b <=20
 * and store them in a long array. The final result which is at point(20, 20) is
 * stored at array[20][20]. My dynamic programming base case is every point
 * (0,b) for all b <= 20 and (a, 0) for all a <= 20 have routes only one. In
 * recursive step, there are two contributions to routes at (a,b), left routes
 * at (a, b-1) or up routes at (a-1, b). The total routes is the sum of these
 * two routes.
 * 
 * There is another faster which use algorithm directly is that routes from
 * (0,0) to (a,b) is always binomial coefficent(a + b, a), which do not need to
 * compute every values in 20*20 array, a time and space saver. But from
 * programming point, i perfer to use dynamic programming lol
 * 
 * @author yi
 * 
 */
public class Problem15 {

	public Long[][] paths;

	public Problem15() {
		paths = new Long[21][21];

	}

	public Long latticePaths() {
		getArray();
		return paths[20][20];
	}

	public void getArray() {
		for (int i = 0; i < 21; i++) {
			paths[i][0] = (long) 1;
			paths[0][i] = (long) 1;
		}
		for (int row = 1; row < 21; row++) {
			for (int column = 1; column < 21; column++) {
				paths[row][column] = paths[row - 1][column]
						+ paths[row][column - 1];
			}
		}

	}

	public static void main(String[] args) {
		Problem15 P15 = new Problem15();
		System.out.println(P15.latticePaths());
	}
}
