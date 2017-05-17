/**Problem99.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 12, 2015 at 11:35:33 PM
 */
package part1.problem091to100;

import java.util.List;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 * 
 *         log_10^a^b = b*log_10^a
 */
public class Problem99 {

	public static void largestExponential() {
		List<String> rows = File.readFile("raw/p099_base_exp.txt", "\n");
		String[] r1 = rows.get(0).trim().split(",");
		Integer cB = Integer.valueOf(r1[0]);
		Integer cE = Integer.valueOf(r1[1]);
		double curr = cE * Math.log10(cB);
		Integer nB, nE;
		Integer max = 1;
		Integer line = 0;
		for (String row : rows) {
			line++;

			String[] number = row.trim().split(",");
			nB = Integer.valueOf(number[0]);
			nE = Integer.valueOf(number[1]);
			double next = nE * Math.log10(nB);
			if (next > curr) {
				curr = next;
				max = line;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		largestExponential();
	}
}
