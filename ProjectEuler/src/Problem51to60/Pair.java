/**Pair.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-29
10:50:17 PM
 */
package Problem51to60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pair {

	public List<String> player1;
	public List<String> player2;
	public Map<Integer, Integer> values1;
	public Map<Integer, Integer> values2;
	public Map<Integer, Integer> suits1;
	public Map<Integer, Integer> suits2;

	public Pair(List<String> pair) {
		player1 = new ArrayList<String>();
		player2 = new ArrayList<String>();

		for (int i = 0; i < pair.size(); i++) {
			if (i < 5)
				player1.add(pair.get(i));
			else
				player2.add(pair.get(i));
		}
		values1 = new HashMap<Integer, Integer>();
		values2 = new HashMap<Integer, Integer>();
		suits1 = new HashMap<Integer, Integer>();
		suits2 = new HashMap<Integer, Integer>();
		getCards(player1, values1, suits1);
		getCards(player2, values2, suits2);
	}

	public void getCards(List<String> cards, Map<Integer, Integer> values,
			Map<Integer, Integer> suits) {
		getValues(cards, values);
		getSuits(cards, suits);
	}

	public void getSuits(List<String> cards, Map<Integer, Integer> suits) {
		for (String card : cards) {
			Integer key = 0;
			char c = card.charAt(1);
			if (c == 'D')
				key = 1;
			else if (c == 'C')
				key = 2;
			else if (c == 'H')
				key = 3;
			else if (c == 'S')
				key = 4;

			if (!suits.containsKey(key))
				suits.put(key, 1);
			else
				suits.put(key, suits.get(key) + 1);
		}
	}

	public void getValues(List<String> cards, Map<Integer, Integer> values) {
		for (String card : cards) {
			Integer key;
			char c = card.charAt(0);
			if (c == 'T')
				key = 10;
			else if (c == 'J')
				key = 11;
			else if (c == 'Q')
				key = 12;
			else if (c == 'K')
				key = 13;
			else if (c == 'A')
				key = 14;
			else
				key = Character.getNumericValue(c);

			if (!values.containsKey(key))
				values.put(key, 1);
			else
				values.put(key, values.get(key) + 1);
		}

	}

	public int getRank(Map<Integer, Integer> values, Map<Integer, Integer> suits) {
		Integer score;
		Integer[] scores = new Integer[6];
		for (Integer i = 0; i < 6; i++)
			scores[i] = 0;
		List<Integer> valueKeys = new ArrayList<Integer>();
		valueKeys.addAll(values.keySet());
		Collections.sort(valueKeys);
		Set<Integer> suitKeys = suits.keySet();
		// Royal Flush
		if (valueKeys.size() == 5 && suitKeys.size() == 1
				&& valueKeys.contains(10) && valueKeys.contains(11)
				&& valueKeys.contains(12) && valueKeys.contains(13)
				&& valueKeys.contains(14))
			score = 10;
		// Straight Flush
		else if (valueKeys.size() == 5 && suitKeys.size() == 1
				&& valueKeys.get(1) - valueKeys.get(0) == 1
				&& valueKeys.get(2) - valueKeys.get(1) == 1
				&& valueKeys.get(3) - valueKeys.get(2) == 1
				&& valueKeys.get(4) - valueKeys.get(3) == 1)
			score = 9;
		// Four of a Kind
		else if (valueKeys.size() == 2 && values.values().contains(4))
			score = 8;
		// Full House
		else if (valueKeys.size() == 2 && values.values().contains(3))
			score = 7;
		// Flush
		else if (suitKeys.size() == 1)
			score = 6;
		// Straight
		else if (valueKeys.size() == 5
				&& valueKeys.get(1) - valueKeys.get(0) == 1
				&& valueKeys.get(2) - valueKeys.get(1) == 1
				&& valueKeys.get(3) - valueKeys.get(2) == 1
				&& valueKeys.get(4) - valueKeys.get(3) == 1)
			score = 5;
		// Three of a Kind
		else if (valueKeys.size() == 3 && values.values().contains(3))
			score = 4;
		// Two Pairs
		else if (valueKeys.size() == 3 && values.values().contains(2))
			score = 3;
		// One Pair
		else if (valueKeys.size() == 4 && values.values().contains(2))
			score = 2;
		else {
			score = 1;
			scores[0] = 1;
		}
		return score;
	}

	public int compare() {
		Integer s1 = getRank(values1, suits1);
		Integer s2 = getRank(values2, suits2);
		if (s1 > s2)
			return 1;
		else if (s1 == s2) {

			return 0;
		} else {
			return 0;
		}
	}

	public String toString() {
		return values2.toString();
	}

	public static void main(String[] args) {

	}

}
