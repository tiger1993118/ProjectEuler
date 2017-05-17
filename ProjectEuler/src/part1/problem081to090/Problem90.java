/**Problem90.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 5, 2015 at 10:39:46 PM
 */
package part1.problem081to090;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem90 {

	public static void cubeDigitPair() {
		List<Integer> possibleDice = new ArrayList<Integer>();
		int total = 0;
		for (int n = 12345; n <= 456789; n++) {
			if (isDice(n)) {
				System.out.println(n);
				possibleDice.add(n);
			}
		}
		for (Integer na : possibleDice) {
			for (Integer nb : possibleDice) {
				if (na != nb) {
					if (isArrangement(na, nb)) {
						System.out.println(na + "-" + nb);
						total++;
					}
				}
			}
		}
		System.out.println(total / 2);
	}

	public static boolean isArrangement(Integer da, Integer db) {
		Set<Integer> dicea = new HashSet<Integer>();
		if (da < 100000)
			dicea.add(0);
		for (char c : da.toString().toCharArray()) {
			int i = Character.getNumericValue(c);
			dicea.add(i);
			if (i == 6)
				dicea.add(9);
			else if (i == 9)
				dicea.add(6);
		}
		Set<Integer> diceb = new HashSet<Integer>();
		if (db < 100000)
			diceb.add(0);
		for (char c : db.toString().toCharArray()) {
			int i = Character.getNumericValue(c);
			diceb.add(i);
			if (i == 6)
				diceb.add(9);
			else if (i == 9)
				diceb.add(6);
		}
		int[] squares = { 1, 4, 9, 16, 25, 36, 49, 64, 81 };
		for (int square : squares) {
			int na, nb;
			if (square < 10) {
				na = 0;
				nb = square;
			} else {
				na = square / 10;
				nb = square - na * 10;
			}
			if (!(dicea.contains(na) && diceb.contains(nb))
					&& !(diceb.contains(na) && dicea.contains(nb)))
				return false;

		}
		return true;
	}

	public static boolean isDice(Integer n) {
		Set<Character> distinctDigits = new HashSet<Character>();
		List<Integer> digits = new ArrayList<Integer>();
		if (n < 100000) {
			distinctDigits.add('0');
			digits.add(0);
		}
		int curr = 0;
		for (char c : n.toString().toCharArray()) {
			int d = Character.getNumericValue(c);
			if (d > curr) {
				distinctDigits.add(c);
				digits.add(d);
				curr = d;
			} else {
				return false;
			}
		}
		if (!digits.contains(2) && !digits.contains(5))
			return false;
		if (!digits.contains(0)
				&& (!digits.contains(1) || !digits.contains(4) || (!digits
						.contains(9) && !digits.contains(6))))
			return false;
		if (!digits.contains(3) && (!digits.contains(9) && !digits.contains(6)))
			return false;
		if (!digits.contains(4) && (!digits.contains(9) && !digits.contains(6)))
			return false;
		if (!digits.contains(1)
				&& ((!digits.contains(9) && !digits.contains(6)) || !digits
						.contains(8)))
			return false;
		return true;
	}

	public static void main(String[] args) {
		cubeDigitPair();
	}
}
