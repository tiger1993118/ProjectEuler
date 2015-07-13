/**Problem99.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 12, 2015 at 11:35:33 PM
 */
package Problem91to100;

import java.util.List;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem99 {

	public static void largestExponential() {
		List<String> rows = File.readFile("raw/p099_base_exp.txt", "\n");
		String[] r1 = rows.get(0).trim().split(",");
		Integer cB = Integer.valueOf(r1[0]);
		Integer cE = Integer.valueOf(r1[1]);
		Integer nB, nE;
		Integer max = 1;
		Integer line = 0;
		for (String row : rows) {
			line++;

			String[] number = row.trim().split(",");
			nB = Integer.valueOf(number[0]);
			nE = Integer.valueOf(number[1]);
			// cB^cE & nB^nE
			if (cB <= nB && cE <= nE) {
				cB = nB;
				cE = nE;
			} else if (cB <= nB && cE >= nE) {
				Double x = (double) nE / (cE - nE);
				Double result = Math.pow((double) cB / nB, x);
				result *= cB;
				if (result < 1) {
					cB = nB;
					cE = nE;
					max = line;
				}
			} else if (cB >= nB && cE <= nE) {
				Double x = (double) cE / (nE - cE);
				Double result = Math.pow((double) nB / cB, x);
				result *= nB;
				if (result > 1) {
					cB = nB;
					cE = nE;
					max = line;
				}
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		largestExponential();
	}
}
