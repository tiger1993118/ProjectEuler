/**Palindromic.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-29
7:51:02 PM
 */
package Algorithm;

import java.math.BigInteger;

public class Palindromic {

	public static boolean isPalindromic(String s) {
		String sc = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			sc += c;
		}
		if (sc.equals(s))
			return true;
		return false;
	}

	public static String reverse(String s) {
		String sc = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			sc += c;
		}
		return sc;
	}

	public static String addReverse(String s) {
		BigInteger reverse = new BigInteger(reverse(s.toString()));
		return reverse.add(new BigInteger(s)).toString();
	}

	public static void main(String[] args) {
		System.out.println(Palindromic.addReverse("17"));
	}

}
