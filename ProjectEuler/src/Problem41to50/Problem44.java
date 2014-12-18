/**Problem44.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-17
11:40:54 AM
 */
package Problem41to50;

/**
 * TODO Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2. The first
 * ten pentagonal numbers are:
 * 
 * 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
 * 
 * It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference,
 * 70 − 22 = 48, is not pentagonal.
 * 
 * Find the pair of pentagonal numbers, Pj and Pk, for which their sum and
 * difference are pentagonal and D = |Pk − Pj| is minimised; what is the value
 * of D?
 * 
 * Solution : Algroithm to check whether a number is pentagonal or not.
 * Pn=n(3n−1)/2 ==> 3n^2 - n - 2Pn = 0 using the root, we could compute the root
 * by (-b + sqrt(b^2 - 4ac)) / 2a, check if the root is an natrual number or
 * not, if yes, then the number is pentagonal.
 * 
 * @author Tiger yi
 * 
 */
public class Problem44 {

	public int limit = 10000;

	public void pentagonNumbers() {

		for (int i1 = 1; i1 <= limit; i1++) {
			for (int i2 = i1 + 1; i2 <= limit; i2++) {
				int n1 = i1 * (i1 * 3 - 1) / 2;
				int n2 = i2 * (i2 * 3 - 1) / 2;

				if (isPentagon(n2 + n1)) {
					if (isPentagon(n2 - n1))
						System.out.println(n2 - n1);
				}
			}
		}
	}

	public boolean isPentagon(int n) {
		int root = (int) (1 + Math.sqrt(1 + 24 * n)) / 6;
		if (root * (root * 3 - 1) / 2 == n)
			return true;
		return false;
	}

	public static void main(String[] args) {
		new Problem44().pentagonNumbers();
	}

}
