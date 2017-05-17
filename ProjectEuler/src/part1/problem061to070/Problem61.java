/**Problem61.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 26, 2015 at 1:35:07 AM
 */
package part1.problem061to070;

import java.util.ArrayList;
import java.util.List;

import Algorithm.Digits;
import Algorithm.Polygonal;

/**
 * @author Xiu Tiger Yi
 */
public class Problem61 {

	public static List<List<Integer>> all;

	public static List<Integer> threes;

	public static void initialize() {
		all = new ArrayList<List<Integer>>();

		threes = fourdigits(3);

		all.add(null);
		all.add(null);
		all.add(null);
		all.add(fourdigits(3));
		all.add(fourdigits(4));
		all.add(fourdigits(5));
		all.add(fourdigits(6));
		all.add(fourdigits(7));
		all.add(fourdigits(8));
	}

	public static void problem61() {
		Integer sum = 0;
		initialize();

		List<Integer> indexs = new ArrayList<Integer>();
		for (Integer i = 4; i < 9; i++)
			indexs.add(i);

		for (Integer eight : threes) {
			List<Integer> numbers = new ArrayList<Integer>();
			numbers.add(eight);
			List<Integer> ret = recurCyclic(Digits.lastNDigits(eight, 2),
					numbers, indexs);

			if (ret.size() == 6) {
				System.out.println(ret);
				for (Integer n : ret)
					sum += n;
			}
		}
		System.out.println(sum);
	}

	public static List<Integer> recurCyclic(Integer lastTwo,
			List<Integer> numbers, List<Integer> indexs) {
		if (numbers.size() == 6) {
			if (Digits.lastNDigits(numbers.get(5), 2) != (numbers.get(0) / 100))
				numbers.remove(5);
		} else {
			List<List<Integer>> listOfDigits = new ArrayList<List<Integer>>();
			for (Integer index : indexs) {
				listOfDigits.add(all.get(index));
			}

			for (Integer i = 0; i < listOfDigits.size(); i++) {
				List<Integer> digits = listOfDigits.get(i);
				List<Integer> newIndexs = new ArrayList<Integer>();
				newIndexs.addAll(indexs);
				newIndexs.remove((Integer) indexs.get(i));

				for (Integer digit : digits) {

					if (lastTwo == (digit / 100)) {

						Integer newLastTwo = Digits.lastNDigits(digit, 2);

						List<Integer> newNumbers = new ArrayList<Integer>();
						newNumbers.addAll(numbers);
						newNumbers.add(digit);

						List<Integer> ret = recurCyclic(newLastTwo, newNumbers,
								newIndexs);

						if (ret.size() == 6) {
							return ret;
						}
					} else if (lastTwo < (digit / 100)) {
						break;
					}
				}
			}
		}
		return numbers;
	}

	public static List<Integer> fourdigits(Integer type) {
		List<Integer> ret = new ArrayList<Integer>();

		Integer n = 1;
		while (f(n, type) < 1000) {
			n += 1;
		}

		while (f(n, type) < 10000) {
			ret.add(f(n, type));
			n += 1;
		}

		return ret;
	}

	public static Integer f(Integer n, Integer type) {

		switch (type) {
		case 3:
			return Polygonal.Triangle(n);
		case 4:
			return Polygonal.Square(n);
		case 5:
			return Polygonal.Pentagonal(n);
		case 6:
			return Polygonal.Hexagonal(n);
		case 7:
			return Polygonal.Heptagonal(n);
		case 8:
			return Polygonal.Octagonal(n);
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		problem61();

	}
}
