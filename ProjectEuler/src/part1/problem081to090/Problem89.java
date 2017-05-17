/**Problem89.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 5, 2015 at 2:15:34 PM
 */
package part1.problem081to090;

import java.util.List;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem89 {

	public static void romanNumerals() {
		List<String> romans = File.readFile("raw/p089_roman.txt", "\n");
		for (String roman : romans) {
			System.out.println(roman.trim());
		}
	}

	public static void main(String[] args) {
		romanNumerals();
	}

}
