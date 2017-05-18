/**File.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-29
10:35:22 PM
 */
package Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class File {

	public static List<String> readFile(String filename, String delimiter) {
		String everything = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

			}
			everything = sb.toString();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return Arrays.asList(everything.split(delimiter));
	}

	public static String[][] readFile(String filename, String delimiter1,
			String delimiter2) {
		String everything = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

			}
			everything = sb.toString();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		
		String[] raws = everything.split(delimiter1);
		
		String[][] ret = new String[raws.length][];
		for (Integer i = 0; i < raws.length; i++) {
			ret[i] = raws[i].trim().split(delimiter2);
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(File.readFile("raw/p054_poker.txt", "\n"));

	}

}
