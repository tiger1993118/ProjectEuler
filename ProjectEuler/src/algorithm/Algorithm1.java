/**Algorithm1.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-21
3:14:23 PM
 */
package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Algorithm1 {

	public static boolean isPermuted(Integer n1, Integer n2) {
		String s1 = n1.toString();
		String s2 = n2.toString();
		Map<Character, Integer> m1 = new HashMap<Character, Integer>();
		Map<Character, Integer> m2 = new HashMap<Character, Integer>();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		for (char c : c1) {
			if (m1.containsKey(c))
				m1.put(c, m1.get(c) + 1);
			else
				m1.put(c, 1);
		}
		for (char c : c2) {
			if (m2.containsKey(c))
				m2.put(c, m2.get(c) + 1);
			else
				m2.put(c, 1);
		}
		if (m1.equals(m2))
			return true;
		return false;
	}

}
