/**Problem54.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-29
10:43:42 PM
 */
package part1.problem051to060;

import java.util.Arrays;
import java.util.List;

import Algorithm.File;

public class Problem54 {

	public void pokerHands() {
		Integer total = 0;
		List<String> raw = File.readFile("raw/p054_poker.txt", "\n");
		for (String one : raw) {
			// System.out.print(one);
			List<String> lst = Arrays.asList(one.split(" "));
			Pair pair = new Pair(lst);
			total += pair.compare();
			// System.out.println(pair);
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		new Problem54().pokerHands();
	}

}
