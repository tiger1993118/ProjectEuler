/**EvenFibonacci.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
10:38:17 PM
 */
package Problem1to50;

import java.util.ArrayList;
import java.util.List;

public class EvenFibonacci {
	public List<Integer> listF;

	public EvenFibonacci() {
		listF = new ArrayList<Integer>();
		listF.add(1);
		listF.add(1);
	}

	public Integer total() {
		Integer ret = 0;
		for (int i : listF) {
			if (i % 2 == 0)
				ret += i;
		}
		if (listF.get(listF.size() - 1) % 2 == 0)
			ret -= listF.get(listF.size() - 1);
		return ret;
	}

	public Integer f(Integer x) {
		if (listF.get(listF.size() - 1) >= x)
			return total();
		else {
			Integer newF = listF.get(listF.size() - 1)
					+ listF.get(listF.size() - 2);
			listF.add(newF);
			return f(x);
		}

	}
}
