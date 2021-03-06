/**Digits.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-31
9:25:06 AM
 */
package algorithm;

import java.math.BigInteger;

public class Digits {

	public static Integer digitSum(String s) {
		Integer sum = 0;
		for (char c : s.toCharArray()) {
			if (c != '.')
				sum += Character.getNumericValue(c);
		}
		return sum;
	}

	public static Integer digitSquareSum(String s) {
		Integer sum = 0;
		for (char c : s.toCharArray()) {
			if (c != '.') {
				int i = Character.getNumericValue(c);
				sum += i * i;
			}
		}
		return sum;
	}

	public static int numOfDigits(String s) {
		return s.length();
	}

	public static int lastNDigits(Integer i, Integer n) {
		String s = i.toString();
		if (s.length() < n)
			return i;
		else
			return Integer.valueOf(s.substring(s.length() - n, s.length()));
	}

	public static long lastNDigits(Long i, Integer n) {
		String s = i.toString();
		if (s.length() < n)
			return i;
		else
			return Long.valueOf(s.substring(s.length() - n, s.length()));
	}

	public static long lastNDigits(String s, Integer n) {
		if (s.length() < n)
			return Long.valueOf(s);
		else
			return Long.valueOf(s.substring(s.length() - n, s.length()));
	}
	
	public static BigInteger lastNDigits(BigInteger b, Integer n) {
		String s = b.toString();
		if (s.length() <= n) {
			return b;
		}else {
			return new BigInteger(s.substring(s.length() - 9));
		}
	}
	
	public static BigInteger firstNDigits(BigInteger b, Integer n) {
		String s = b.toString();
		if (s.length() <= n) {
			return b;
		}else {
			return new BigInteger(s.substring(0, n));
		}
	}

	public static void main(String[] args) {
	}
}
