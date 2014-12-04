/**SpecialPythagoreanTriplet.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
11:33:33 PM
 */
package Problem01to10;

public class Problem09 {

	public Problem09() {

	}

	public Integer sPT(int total) {
		Integer ret = 1;
		for (Integer a = 1; a <= total / 3; a++) {
			for (Integer b = a + 1; b <= (total - a) / 2; b++) {
				if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(
						(total - a - b), 2)) {
					return a * b * (total - a - b);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Problem09 P9 = new Problem09();
		System.out.println(P9.sPT(1000));
	}
}
