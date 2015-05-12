/**Problem22.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
6:23:35 PM
 */
package Problem21to30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem22 {

	public void nameScores() throws IOException {
		List<String> names = readFile();
		Collections.sort(names);

		BigInteger total = new BigInteger("0");
		for (int i = 0; i < names.size(); i++) {
			String current = names.get(i);
			BigInteger score = new BigInteger("0");
			for (char c : current.toCharArray()) {
				int a = (int) c - 64;
				if (a > 0 && a < 27) {
					score = score.add(BigInteger.valueOf(a));
				}
			}
			//System.out.println(current + score + "-" + (i + 1));
			score = score.multiply(BigInteger.valueOf((i + 1)));
			total = total.add(score);

		}
		System.out.println(total);
	}

	public List<String> readFile() throws IOException {
		String everything;
		BufferedReader br = new BufferedReader(new FileReader(
				"raw/p022_names.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

			}
			everything = sb.toString();
		} finally {
			br.close();
		}
		return Arrays.asList(everything.split(","));
	}

	public static void main(String[] args) throws IOException {
		new Problem22().nameScores();
	}

}
