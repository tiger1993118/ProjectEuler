/**Problem52.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-21
1:44:09 PM
 */
package Problem51to60;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * TODO It can be seen that the number, 125874, and its double, 251748, contain
 * exactly the same digits, but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 * 
 * Observation : For numbers between 10^i and 10^(i+1), the number we are
 * looking for could only be smaller than 10^(i+1)/6, for 6x have to have same
 * number of digits as x, so that 6x could not exceed the limit.
 * 
 * Solution : For i is bigger than 1, numbers between 10^i and 10^(i+1) only
 * have to check numbers between 10^i and 10^(i+1)/6, If all x, 2x to 6x are
 * permuted, then return x.
 * 
 * 
 * @author Tiger yi
 * 
 */
public class Problem52 {

	public void permutedMultiply() {
		int limit = 1;
		boolean hasAnswer = false;
		while (!hasAnswer) {
			limit = limit * 10;
			for (int n = limit / 10; n < limit / 6; n++) {
				int time = 2;
				while (time <= 6 && isPermuted(n, n * time)) {
					time += 1;
				}
				if (time > 6) {
					System.out.println(n);
					hasAnswer = true;
				}
			}
		}
	}

	public boolean isPermuted(Integer n1, Integer n2) {
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

	public static void main(String[] args) {
		new Problem52().permutedMultiply();
	}

}
