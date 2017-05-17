/**Problem67.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 29, 2015 at 12:02:05 PM
 */
package part1.problem061to070;

import java.util.ArrayList;
import java.util.List;

import Algorithm.File;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem67 {

	public static void problem67() {
		List<String> s_rows = File.readFile("raw/p067_triangle.txt", "\n");
		List<List<Integer>> rows = new ArrayList<List<Integer>>();
		for (String s : s_rows) {
			List<Integer> row = new ArrayList<Integer>();
			String[] s_row = s.split(" ");
			for (String s_num : s_row) {
				row.add(Integer.parseInt(s_num.trim()));
			}
			if (rows.size() != 0) {
				List<Integer> last_row = rows.get(rows.size() - 1);
				for (Integer i = 0; i < row.size(); i++) {
					if (i == 0) {
						row.set(i, row.get(i) + last_row.get(i));
					} else if (i == (row.size() - 1)) {
						row.set(i, row.get(i) + last_row.get(i - 1));
					} else {
						row.set(i,
								row.get(i)
										+ Math.max(last_row.get(i - 1),
												last_row.get(i)));
					}
				}
			}
			rows.add(row);
		}
		Integer max = 0;
		for (Integer num : rows.get(rows.size() - 1)) {
			max = Math.max(max, num);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		problem67();

	}

}
