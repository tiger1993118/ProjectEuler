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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem22 {

	public void nameScores() throws IOException {
		List<String> names = readFile();
		Collections.sort(names);

		int total = 0;
		for (int i = 0; i < names.size(); i++) {
			String current = names.get(i);
			int score = 0;
			for (int is = 0; is < current.length(); is++) {
				if (current.charAt(is) != '"') {
					int a = (int) current.charAt(is) - 64;
					System.out.println(current.charAt(is) + "-" + a);
					score += a;
				}
			}
			score = score * (i + 1);
			System.out.println(current + score + "-" + (i + 1) + "-" + score);
			total += score;

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
