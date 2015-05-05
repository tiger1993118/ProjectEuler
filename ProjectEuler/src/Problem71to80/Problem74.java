/**Problem74.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 9:47:23 AM
 */
package Problem71to80;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem74 {

	public static int[] digitFactorial = new int[10];

	public static void digitFactorialChains() {

		for (Integer i = 0; i < 10; i++) {
			Integer pro = 1;
			for (Integer n = 1; n <= i; n++)
				pro *= n;
			digitFactorial[i] = pro;
		}
		int limit = 1000000;
		int[] numFactorial = new int[limit * 10];
		int ret = 0;
		for (Integer i = 0; i < limit; i++) {
			int n = i;
			int count = 0;
			List<Integer> track = new ArrayList<Integer>();
			do {
				if (numFactorial[n] != 0) {
					count += numFactorial[n];
					break;
				} else {
					track.add(n);
					n = getFactorial(n);
					count++;
				}
			} while (!track.contains(n));
			for (Integer inum = 0; inum < track.size(); inum++) {
				numFactorial[track.get(inum)] = count - inum;
			}
			if (count == 60)
				ret++;
		}
		System.out.println(ret);
	}

	public static int getFactorial(Integer n) {
		int total = 0;
		for (char c : n.toString().toCharArray()) {
			total += digitFactorial[Character.getNumericValue(c)];
		}
		return total;
	}

	public static void main(String[] args) {
		digitFactorialChains();

	}
}
