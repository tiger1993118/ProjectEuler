package part2.problem101to110;

import algorithm.File;
import algorithm.Point2D;

public class Problem102 {
	
	public static void solve() {
		Integer total = 0;
		String[][] s = File.readFile("raw/p102_triangles.txt", "\n", ",");
		Point2D ZERO = new Point2D(0, 0);// Origin Point
		// Triangle ABC
		Point2D A = new Point2D(0, 0);
		Point2D B = new Point2D(0, 0);
		Point2D C = new Point2D(0, 0);
		for (int i = 0; i < s.length; i++) {// Loop over all the triangles
			A.setXY(Integer.parseInt(s[i][0]), Integer.parseInt(s[i][1]));
			B.setXY(Integer.parseInt(s[i][2]), Integer.parseInt(s[i][3]));
			C.setXY(Integer.parseInt(s[i][4]), Integer.parseInt(s[i][5]));
		
			// Point is inside of the triangle if it on the same side of each point(ie A), divided by the other line(ie. BC) 
			if (Point2D.sameSide(A, B, ZERO, C) && Point2D.sameSide(A, C, ZERO, B) && Point2D.sameSide(B, C, ZERO, A)) {
				total ++;
			}
		}
		
		System.out.println(total);
	}
	
	public static void main(String[] args) {
		solve();

	}

}
