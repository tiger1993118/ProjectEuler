/**SumSquareDifference.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
11:08:26 PM
 */
package Problem01to10;

public class Problem06 {

	public Problem06() {

	}

	public Integer sSD(Integer n) {
		Integer ret = 0;
		for (int p1 = 1; p1 < n; p1++) {
			for (int p2 = p1 + 1; p2 <= n; p2++) {
				ret += p1 * p2;
			}
		}
		ret *= 2;
		return ret;
	}

	public static void main(String[] args) {
		Problem06 SSD = new Problem06();
		System.out.println(SSD.sSD(100));
	}
}
