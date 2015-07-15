package Problem91to100;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Algorithm.File;

/**Problem98.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 13, 2015 at 6:31:38 PM
 */

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem98 {

	public static List<Integer> squares;

	public static Integer max = 0;

	public static void anagramicSquares() {
		Integer square = 0;
		squares = new ArrayList<Integer>();
		squares.add(square);
		for (Integer i = 1; i < 40000; i++) {
			square += (2 * i - 1);
			squares.add(square);
		}
		List<String> names = File.readFile("raw/p098_words.txt", ",");
		Map<Map<Character, Integer>, List<String>> alphaToNames = new HashMap<Map<Character, Integer>, List<String>>();
		for (String n : names) {
			String name = n.trim().replace("\"", "");
			Map<Character, Integer> alpha = new HashMap<Character, Integer>();
			for (Character c : name.toCharArray()) {
				if (alpha.containsKey(c))
					alpha.replace(c, alpha.get(c) + 1);
				else
					alpha.put(c, 1);

			}
			if (alphaToNames.containsKey(alpha)) {
				alphaToNames.get(alpha).add(name);
			} else {
				List<String> newNames = new ArrayList<String>();
				newNames.add(name);
				alphaToNames.put(alpha, newNames);
			}
		}
		for (List<String> l : alphaToNames.values()) {
			if (l.size() > 1) {
				computeAnagram(l);
			}
		}
		System.out.println(max);
	}

	public static void computeAnagram(List<String> names) {
		for (int i1 = 0; i1 < names.size(); i1++) {
			for (int i2 = i1 + 1; i2 < names.size(); i2++) {
				String name1 = names.get(i1);
				String name2 = names.get(i2);
				if (name1.length() == name2.length()) {
					Set<Character> setAlpha = new HashSet<Character>();
					List<Character> listAlpha = new ArrayList<Character>();
					for (Character c : name1.toCharArray()) {
						setAlpha.add(c);
						listAlpha.add(c);
					}
					if (name1.length() == setAlpha.size()) {
						System.out.println(name1 + "-" + name2);
						for (int i = (int) Math.sqrt(Math.pow(10,
								setAlpha.size() - 1)) + 1; i < Math.sqrt(Math
								.pow(10, setAlpha.size())); i++) {
							Integer square1 = squares.get(i);
							List<Character> listSquare = new ArrayList<Character>();
							Set<Character> setSquare = new HashSet<Character>();
							for (char c : square1.toString().toCharArray()) {
								listSquare.add(c);
								setSquare.add(c);
							}
							if (setSquare.size() == setAlpha.size()) {
								String sSquare2 = "";
								for (Character c : name2.toCharArray()) {
									sSquare2 = sSquare2
											+ listSquare.get(listAlpha
													.indexOf(c));
								}
								Integer square2 = Integer.valueOf(sSquare2);
								if (squares.get((int) Math.sqrt(square2))
										.equals(square2)
										&& square2.toString().length() == sSquare2
												.length()) {
									max = Math.max(max, square1);
									max = Math.max(max, square2);
									System.out.println(square1 + "-" + square2);
								}

							}
						}

					}
				}
			}
		}
	}

	public static void main(String[] args) {
		anagramicSquares();

	}

}
