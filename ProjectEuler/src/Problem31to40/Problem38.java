/**Problem38.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
4:23:21 PM
 */
package Problem31to40;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Take the number 192 and multiply it by each of 1, 2, and 3:
 * 
 * 192 × 1 = 192 192 × 2 = 384 192 × 3 = 576 By concatenating each product we
 * get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated
 * product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
 * and 5, giving the pandigital, 918273645, which is the concatenated product of
 * 9 and (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 * 
 * Observation : Because there is already a pandigital number starting with
 * 9(918273645), so if there is a bigger one, it could only start with 9. So the
 * Integer we are looking for is also starting with 9(because n = 1 firstly),
 * But we have no idea how many digits number is the Integer yet. If the
 * Integer(denote it n) is a two-digit number, then 1*n is still a two digit
 * number, 2*n must be a three digit number(for n is starting with 9), and same,
 * 3*n is a three digit number too. These three number contribute totally 8
 * digits, we only have 1 digit left, but we know that 4*n must have more than 1
 * digit, contradiction, n could not two digit number. Same goes with when n is
 * a three-digit number. But when n is a four-digit number starting with 9, n*1
 * is a four-digit number, n*2 is a five digit number, total nine digits, which
 * is we were looking for, so n must be a four-digit number(from1000 to
 * 9999).(Notice when n is more than four-digit, like five digit, then n*2 have
 * more 5 digits, so totally will exceed nine digits limit).
 * 
 * Solution : Loop through every four-digit numbers decreasingly(from 9999 to
 * 1000), so that the first one we found, must be the largest one. Follow the
 * rules of pandigital number, concatenate n and n*2 so that is pandigital
 * number 1 through 9.Return the number.
 * 
 * @author Tiger yi
 * 
 */
public class Problem38 {

	public void pandigitalMultiple() {
		for (int n = 9999; n > 9000; n--) {
			if (isPandigital(n)) {
				System.out.println(n + "" + n * 2);
				break;
			}
		}
	}

	public boolean isPandigital(Integer n1) {
		Integer n2 = n1 * 2;
		String s1 = n1.toString();
		String s2 = n2.toString();
		Set<Integer> digits = new HashSet<Integer>();
		for (int i = 1; i < 10; i++)
			digits.add(i);
		String[] a1 = s1.split("");
		String[] a2 = s2.split("");
		for (String s : a1) {
			if (!s.equals("")) {

				digits.remove(Integer.parseInt(s));
			}
		}
		for (String s : a2) {
			if (!s.equals("")) {
				digits.remove(Integer.parseInt(s));
			}
		}
		if (digits.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		new Problem38().pandigitalMultiple();

	}
}
