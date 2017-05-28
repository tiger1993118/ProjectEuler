/**Problem59.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jan 2, 2015 at 2:04:59 PM
 */
package part1.problem051to060;

import java.util.ArrayList;
import java.util.List;

import algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem59 {

	public List<Integer> keys;

	public void xorDecryption() {
		keys = new ArrayList<Integer>();
		List<String> raw = File.readFile("raw/p059_cipher.txt", ",");
		for (String s : raw)
			keys.add(Integer.parseInt(s.trim()));
		for (int n1 = 97; n1 < 123; n1++) {
			for (int n2 = 97; n2 < 123; n2++) {
				for (int n3 = 97; n3 < 123; n3++) {
					String ret = "";
					Integer sum = 0;
					boolean valid = true;
					for (int i = 0; i < keys.size(); i++) {
						int[] n = { n1, n2, n3 };
						int rem = i % 3;
						int ascii = keys.get(i) ^ n[rem];
						if (!(32 <= ascii && ascii < 127)) {
							valid = false;
							i = keys.size();
						} else {
							sum += ascii;
							ret += (char) ascii;
						}
					}
					if (valid)
						System.out.println(sum + "-" + ret);

				}
			}
		}

	}

	public static void main(String[] args) {
		new Problem59().xorDecryption();

	}

}
