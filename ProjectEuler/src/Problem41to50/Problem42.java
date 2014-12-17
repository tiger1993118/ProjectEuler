/**Problem42.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-16
11:10:13 PM
 */
package Problem41to50;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * TODO The nth term of the sequence of triangle numbers is given by, tn =
 * ½n(n+1); so the first ten triangle numbers are:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value. For
 * example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value
 * is a triangle number then we shall call the word a triangle word.
 * 
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
 * containing nearly two-thousand common English words, how many are triangle
 * words?
 * 
 * 
 * Solution : Read the input file and split into words. Loop through all the
 * words, compute every value of them. tn = ½n(n+1), so that we reverse the
 * formula, v * 2 = n(n+1), I square root (v*2) and fetch the integer part,
 * which is n. if (n)*(n+1) is equal to v, then it is a triangle number, count
 * them all and return.
 * 
 * @author Tiger yi
 * 
 */
public class Problem42 {

	public void codedTriangle() {
		List<String> words = null;
		int ret = 0;
		try {
			words = readFile("raw/p042_words.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String word : words) {
			int count = 0;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (c != '"') {
					count += ((int) c - 64);
				}
			}
			if (isTriangle(count)) {
				ret += 1;
			}
		}
		System.out.println(ret);
	}

	public boolean isTriangle(int n) {
		n = n * 2;
		int a = (int) Math.sqrt(n);
		if (a * (a + 1) == n) {
			return true;
		}
		return false;
	}

	public List<String> readFile(String filename) throws IOException {
		String everything;
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

			}
			everything = sb.toString();
		} finally {
			br.close();
		}
		return Arrays.asList(everything.split(","));
	}

	public static void main(String[] args) {
		new Problem42().codedTriangle();
	}

}
