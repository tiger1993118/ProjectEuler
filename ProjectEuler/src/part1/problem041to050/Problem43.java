/**Problem43.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-16
11:33:03 PM
 */
package part1.problem041to050;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO The number, 1406357289, is a 0 to 9 pandigital number because it is made
 * up of each of the digits 0 to 9 in some order, but it also has a rather
 * interesting sub-string divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note
 * the following:
 * 
 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is
 * divisible by 5 d5d6d7=357 is divisible by 7 d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13 d8d9d10=289 is divisible by 17 Find the sum of
 * all 0 to 9 pandigital numbers with this property.
 * 
 * Solution : Loop through every permutation of 10 digits gonna take a while.
 * Starting with last 3 digits only have 999 possibilities, find out the
 * three-digit that could be divided by 17 and is pandigital. Then from now,
 * grab every first 2 digits of numbers we have, concatenate with next digit
 * that have not been used, check whether it could be divided by next
 * prime(13,11,...2). Repeated it till the last prime 2, and do not forget to
 * concatenate with the last unused digit and that are all our final numbers.
 * Return the sum of them all.
 * 
 * @author Tiger yi
 * 
 */
public class Problem43 {

	public int[] primes = { 2, 3, 5, 7, 11, 13 };

	public void divisibility() {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int n10 = 10; n10 < 1000; n10++) {
			if (n10 % 17 == 0 && isPandigital(n10)) {
				numbers.add(n10);
			}
		}
		long ret = 0;
		List<Integer> newNumbers = loop(numbers, 5);
		for (Integer n : newNumbers) {
			Set<Integer> digits = new HashSet<Integer>();
			for (int i = 0; i < 10; i++) {
				digits.add(i);
			}
			String s = n.toString();
			for (int i = 0; i < s.length(); i++) {
				digits.remove(Character.getNumericValue(s.charAt(i)));
			}
			if (s.length() < 9) {
				digits.remove(0);
				s = "0" + s;
			}
			int digit = digits.iterator().next();
			long thisI = Long.valueOf(digit + s);
			System.out.println(thisI);
			ret += thisI;
		}
		System.out.println(ret);

	}

	public List<Integer> loop(List<Integer> numbers, int n) {
		List<Integer> newNumbers = new ArrayList<Integer>();
		if (n == -1) {
			return numbers;
		}

		for (Integer number : numbers) {
			Set<Integer> digits = new HashSet<Integer>();
			for (int i = 0; i < 10; i++) {
				digits.add(i);
			}
			String s = number.toString();
			for (int i = 0; i < s.length(); i++) {
				digits.remove(Character.getNumericValue(s.charAt(i)));
			}
			if (s.length() < (8 - n)) {
				digits.remove(0);
				s = "0" + s;
			}
			String s2 = s.substring(0, 2);
			for (int digit : digits) {

				int newI = Integer.parseInt(digit + s2);
				if (newI % primes[n] == 0) {
					newNumbers.add(Integer.parseInt(digit + s));

				}
			}
		}

		return loop(newNumbers, n - 1);
	}

	public boolean isPandigital(Integer n) {
		String s = n.toString();
		if (s.length() < 3) {
			s = "0" + s;
		}
		return (s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s
				.charAt(1) != s.charAt(2));
	}

	public static void main(String[] args) {
		//new Problem43().divisibility();
		for (int i = 0; i < 100; i++){
			if ((315*i - 1) % 11 == 0){
				System.out.println(i*315 - 1);
			}
		}
	}

}
