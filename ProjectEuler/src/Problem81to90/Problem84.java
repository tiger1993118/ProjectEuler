/**Problem84.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 21, 2015 at 6:20:46 PM
 */
package Problem81to90;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem84 {

	static int limit = 2000_0000;

	static int iCH = 0;

	static int iCC = 0;

	static int posLimit = 40;

	static int cardLimit = 16;

	public static void monopolyOdds() {

		int diceRange = 4;

		int step1 = 0, step2 = 0;

		int[] track = new int[posLimit];

		int position = 0;

		int doublesCount = 0;
		for (int t = 0; t < limit; t++) {
			step1 = (int) Math.ceil(Math.random() * diceRange);
			step2 = (int) Math.ceil(Math.random() * diceRange);

			if (step1 == step2) {
				doublesCount++;
			} else {
				doublesCount = 0;
			}
			if (doublesCount == 3) {
				position = 10;
				doublesCount = 0;
			} else {
				position += (step1 + step2);
				if (position >= posLimit)
					position -= posLimit;
				if (position == 30) {// 30=Go 2 Jail
					position = 10;
				} else if (position == 2 || position == 17 || position == 33) {// 2,17,33=CC
					position = getCC(position);
				} else if (position == 7 || position == 22 || position == 36) {// 7,22,36=CH
					position = getCH(position);
				}
			}
			track[position]++;
		}
		for (int i = 0; i < posLimit; i++) {
			System.out.println(i + "-" + 100 * (double) track[i]
					/ (double) limit);
		}
		// for (int i = 0; i < stepTrack.length; i++) {
		// System.out.println(i + "-" + 100 * (double) stepTrack[i]
		// / (2 * (double) limit));
		// }
	}

	public static int getCC(int pos) {
		int[] CC = { 0, 10 };
		int ret = 50;
		if (iCC > 1) {
			ret = pos;
		} else if (iCC == 0 || iCC == 1) {
			ret = CC[iCC];
		}
		if (iCC + 1 == cardLimit) {// move to next card
			iCC = 0;
		} else {
			iCC++;
		}
		return ret;
	}

	public static int getCH(int pos) {
		int[] CH = { 0, 10, 11, 24, 39, 5 };
		int ret = 50;
		if (iCH < 6) {//
			ret = CH[iCH];
		} else if (iCH > 9) {// stay same position
			ret = pos;
		} else if (iCH == 6 || iCH == 7) {// go to next R
			if (pos == 7) {
				ret = 15;
			} else if (pos == 22) {
				ret = 25;
			} else if (pos == 36) {
				ret = 5;
			}
		} else if (iCH == 8) {// go to next U
			if (pos == 7 || pos == 36) {
				ret = 12;
			} else if (pos == 22) {
				ret = 28;
			}
		} else if (iCH == 9) {// go back 3 squares
			if (pos - 3 < 0) {
				ret = posLimit + pos - 3;
			} else {
				ret = pos - 3;
			}
		}
		if (iCH + 1 == cardLimit) {// move to next card
			iCH = 0;
		} else {
			iCH++;
		}
		return ret;
	}

	public static void main(String[] args) {
		monopolyOdds();
	}

}
