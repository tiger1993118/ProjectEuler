/**Digits.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-31
9:25:06 AM
 */
package Algorithm;

public class Digits {

	public static Integer digitSum(String s) {
		Integer sum = 0;
		for (char c : s.toCharArray()) {
			sum += Character.getNumericValue(c);
		}
		return sum;
	}

	public static int numOfDigits(String s) {
		return s.length();
	}

	public static int lastNDigits(Integer i, Integer n) {
		String s = i.toString();
		return Integer.valueOf(s.substring(s.length() - n, s.length()));
	}
	
	public static int lastNDigits(Long i, Integer n) {
		String s = i.toString();
		return Integer.valueOf(s.substring(s.length() - n, s.length()));
	}

	public static void main(String[] args) {
		System.out.println(lastNDigits(33123, 2));
	}

}
