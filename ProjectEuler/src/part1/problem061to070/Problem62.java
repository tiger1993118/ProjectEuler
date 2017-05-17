/**Problem62.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 25, 2015 at 11:42:43 PM
 */
package part1.problem061to070;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiu Tiger Yi
 */
public class Problem62 {

	public Problem62() {

	}

	public Map<Digit, Integer> problem62() {

		Map<Digit, Integer> count = new HashMap<Digit, Integer>();
		Map<Digit, BigInteger> min = new HashMap<Digit, BigInteger>();
		for (Integer i = 0; i < 1000000; i++) {
			BigInteger base = new BigInteger(i.toString());
			BigInteger cube = base.pow(3);

			Digit d = new Digit(cube);

			if (!count.containsKey(d)) {
				count.put(d, 1);
				min.put(d, cube);
			} else {
				count.put(d, count.get(d) + 1);
				min.put(d, cube.min(min.get(d)));
				// if (count.get(d) >= 3) {
				// System.out.println(d.toString() + count.get(d));
				// }
				if (count.get(d) >= 5) {
					System.out.println(d.toString() + count.get(d));
					System.out.println(min.get(d));
					break;
				}
			}
		}
		return count;
	}

	public class Digit {

		private BigInteger bi;
		private Map<Character, Integer> digitCount;

		public Digit(BigInteger bi) {
			this.bi = bi;
			digitCount = new HashMap<Character, Integer>();
			initialize();
		}

		public void initialize() {
			for (char c : bi.toString().toCharArray()) {
				if (!digitCount.containsKey(c))
					digitCount.put(c, 1);
				else
					digitCount.put(c, digitCount.get(c) + 1);
			}
		}

		public Map<Character, Integer> getDigitCount() {
			return this.digitCount;
		}

		@Override
		public int hashCode() {
			return digitCount.hashCode();
		}

		public boolean equals(Object obj) {
			return digitCount.equals(((Digit) obj).getDigitCount());
		}

		@Override
		public String toString() {
			return digitCount.toString();
		}

	}

	public static void main(String[] args) {
		Problem62 p62 = new Problem62();

		Map<Digit, Integer> m = p62.problem62();

		for (Digit d : m.keySet()) {
			if (m.get(d) >= 3) {
				System.out.println(d.toString() + m.get(d));
			}

		}
		// Digit d = problem62.new Digit(new BigInteger("13123"));
		// Digit d2 = problem62.new Digit(new BigInteger("331112"));
		// Map<Digit, Integer> count = new HashMap<Digit, Integer>();
		// count.put(d, 1);
		// count.put(d2, 2);
		// System.out.println(count);
	}
}
