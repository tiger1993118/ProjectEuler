/**Problem39.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
5:13:06 PM
 */
package part1.problem031to040;

/**
 * TODO If p is the perimeter of a right angle triangle with integral length
 * sides, {a,b,c}, there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * 
 * Solution : Looping through number from 5 to 1000 which represents the
 * perimeter. We denote the triangle numbers {a,b,c} such that a^2 + b^2 = c^2
 * and a < b < c. Then the upper bound of a is always c/3, because if a > c/3,
 * then c/3 < a < b < c, a+b+c will exceed the perimeter. And same goes with b,
 * b have to be smaller than c/2, if b > c/2, then c/2 < b < c, b+c will exceed
 * the perimeter. Loop from 1 to c/3 for a, from a + 1 to c/2 for b, and c =
 * perimeter - a - b. If a,b,c is right angle triangle numbers, then we add 1 to
 * counter. Finally return the perimeter with the most triangle numbers.
 * 
 * @author Tiger yi
 * 
 */
public class Problem39 {

	public void rightTriangles() {
		int max = 0;
		int n = 0;
		for (int total = 5; total <= 1000; total++) {
			int time = 0;
			for (int a = 1; a < total / 3; a++) {
				for (int b = a + 1; b < total / 2; b++) {
					int c = total - a - b;
					if (total > b) {
						if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
							time += 1;
						}
					}
				}
			}
			if (time > max) {
				max = time;
				n = total;
			}
		}

		System.out.println(n);
	}

	public static void main(String[] args) {
		new Problem39().rightTriangles();

	}

}
