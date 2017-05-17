/**Problem93.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 15, 2015 at 4:41:49 PM
 */
package part1.problem091to100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem93 {

	public static Set<Integer> outcome;

	public static void arithmeticExpressions() {
		Integer max = 28;
		outcome = new HashSet<Integer>();
		List<Integer> input = new ArrayList<Integer>();
		for (int a = 1; a < 10; a++) {
			input.add(a);
			for (int b = a + 1; b < 10; b++) {
				input.add(b);
				for (int c = b + 1; c < 10; c++) {
					input.add(c);
					for (int d = c + 1; d < 10; d++) {
						input.add(d);
						recurOutcome(input);
						Integer n;
						List<Integer> list = new ArrayList<Integer>();
						list.addAll(outcome);
						for (n = 1; outcome.contains(n); n++) {
						}
						if (n >= max) {
							max = n;
							System.out.println(input);
						}
						outcome.clear();
						input.remove((Integer) d);
					}
					input.remove((Integer) c);
				}
				input.remove((Integer) b);
			}
			input.remove((Integer) a);
		}
		System.out.println(max);
	}

	public static void recurOutcome(List<Integer> input) {
		if (input.size() == 0) {

		} else if (input.size() == 1) {
			if (input.get(0) > 0)
				outcome.add(input.get(0));
		} else {
			for (int ia = 0; ia < input.size(); ia++) {
				int a = input.get(ia);
				for (int ib = 0; ib < input.size(); ib++) {
					int b = input.get(ib);
					if (ia != ib) {
						// Two number operations
						Set<Integer> operations = new HashSet<Integer>();
						operations.add(a + b);
						operations.add(a - b);
						operations.add(a * b);
						if (b != 0 && a % b == 0)
							operations.add(a / b);
						if (operations.contains(0))
							operations.remove(0);

						for (Integer out : operations) {
							List<Integer> copy = new ArrayList<Integer>();
							copy.addAll(input);
							copy.remove((Integer) a);
							copy.remove((Integer) b);
							copy.add(0, out);
							recurOutcome(copy);
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		arithmeticExpressions();

	}

}
