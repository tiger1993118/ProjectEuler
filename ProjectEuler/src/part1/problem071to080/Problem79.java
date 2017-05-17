/**Problem79.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 8, 2015 at 10:23:17 AM
 */
package part1.problem071to080;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem79 {

	public static void passwordDerivation() {
		List<String> lines = File.readFile("raw/p079_keylog.txt", "\n");
		for (Integer i = 0; i < lines.size(); i++) {
			lines.set(i, lines.get(i).trim());
		}
		Map<Integer, Integer> n1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> n2 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> n3 = new HashMap<Integer, Integer>();
		Map<Integer, Set<Integer>> behind = new HashMap<Integer, Set<Integer>>();

		for (String line : lines) {
			Integer i1 = Character.getNumericValue(line.charAt(0));
			Integer i2 = Character.getNumericValue(line.charAt(1));
			Integer i3 = Character.getNumericValue(line.charAt(2));
			if (!n1.containsKey(i1))
				n1.put(i1, 1);
			else
				n1.replace(i1, n1.get(i1) + 1);

			if (!n2.containsKey(i2))
				n2.put(i2, 1);
			else
				n2.replace(i2, n2.get(i2) + 1);

			if (!n3.containsKey(i3))
				n3.put(i3, 1);
			else
				n3.replace(i3, n3.get(i3) + 1);

			if (!behind.containsKey(i1)) {
				behind.put(i1, new HashSet<Integer>());
			}
			behind.get(i1).add(i2);
			behind.get(i1).add(i3);
			if (!behind.containsKey(i2)) {
				behind.put(i2, new HashSet<Integer>());
			}
			behind.get(i2).add(i3);
		}
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(behind);
	}

	public static void main(String[] args) {
		passwordDerivation();

	}

}
