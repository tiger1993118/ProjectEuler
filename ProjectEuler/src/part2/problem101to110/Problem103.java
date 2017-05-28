package part2.problem101to110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem103 {

	static int sum = 0;

	public static void solve() {
		int layer = 7;
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < layer; i++) {
			l.add(0);
		}
		for (int total = 140; total < 350; total++) {
			System.out.println(total);
			//init, current layer, total layer, current sum, total sum, order set
			rec_subset(20, 0, layer, 0, total, l);
		}
	}
	// Satisfied the second condition
	public static boolean check_second(List<Integer> set) {
		int left_sum = set.get(0);
		int right_sum = 0;
		for (int i = 1; i <= (set.size()) / 2; i++) {
			left_sum += set.get(i);
			right_sum += set.get(set.size() - i);
			if (left_sum <= right_sum) {
				return false;
			}
		}
		return true;
	}
	
	public static void print_array(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println("]");
	}
	
	public static boolean size_check(List<Integer> set, int[] index_list, int size, int curr_layer) {
		if(curr_layer == size) {
			if(size == 4) {
//				print_array(index_list);
				return (set.get(index_list[0]) + set.get(index_list[3])) != (set.get(index_list[1]) + set.get(index_list[2]));
			}else if(size == 6) {
//				print_array(index_list);
				return ((set.get(index_list[0]) + set.get(index_list[1]) + set.get(index_list[5])) != (set.get(index_list[2]) + set.get(index_list[3]) + set.get(index_list[4])))
						&& ((set.get(index_list[0]) + set.get(index_list[2]) + set.get(index_list[5])) != (set.get(index_list[1]) + set.get(index_list[3]) + set.get(index_list[4])))
						&& ((set.get(index_list[0]) + set.get(index_list[3]) + set.get(index_list[4])) != (set.get(index_list[1]) + set.get(index_list[2]) + set.get(index_list[5])))
						&& ((set.get(index_list[0]) + set.get(index_list[3]) + set.get(index_list[5])) != (set.get(index_list[1]) + set.get(index_list[2]) + set.get(index_list[4])))
						&& ((set.get(index_list[0]) + set.get(index_list[4]) + set.get(index_list[5])) != (set.get(index_list[1]) + set.get(index_list[2]) + set.get(index_list[3])));
			}
		}else {
			int start;
			if(curr_layer == 0) {
				start = 0;
			}else {// Last value + 1
				start = index_list[curr_layer-1] + 1;
			}
			int limit = set.size() - (size - curr_layer);
			for(int i = start; i <= limit; i++) {
				index_list[curr_layer] = i;
				if(!size_check(set, index_list, size, curr_layer+1)) {
//					print_array(index_list);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean subset_check(List<Integer> set) {
		if (!check_second(set)) {
			return false;
		}

//		if (set.size() == 4) {// a+d != b+c
//			return ((set.get(0) + set.get(3)) != (set.get(1) + set.get(2)));
//		}
//		if (set.size() == 5) {
//			return ((set.get(1) + set.get(4)) != (set.get(2) + set.get(3)))
//					&& ((set.get(0) + set.get(4)) != (set.get(2) + set.get(3)))
//					&& ((set.get(0) + set.get(4)) != (set.get(1) + set.get(3)))
//					&& ((set.get(0) + set.get(4)) != (set.get(1) + set.get(2)))
//					&& ((set.get(0) + set.get(3)) != (set.get(1) + set.get(2)));
//		}
		//if (set.size() == 7) 
//		System.out.println(set);
		return size_check(set, new int[] {0,0,0,0}, 4, 0) && size_check(set, new int[] {0,0,0,0,0,0}, 6, 0);
	}

	public static void rec_subset(int init, int curr_layer, int total_layer, int curr_sum, int total_sum,
			List<Integer> order_set) {
		if (curr_layer == total_layer - 1) {
			sum++;
			order_set.set(curr_layer, total_sum - curr_sum);
			// System.out.println(order_set);
			if (subset_check(order_set)) {
				System.out.println(order_set);
			}
		} else {
			int last_value;
			if (curr_layer == 0) {
				last_value = init;
			} else {
				last_value = order_set.get(curr_layer - 1) + 1;
			}
			int left_sum = total_sum - curr_sum;
			int limit = (int) Math.ceil((double) left_sum / (double) (total_layer - curr_layer))
					- (total_layer - curr_layer) / 2;
			for (int i = last_value; i <= limit; i++) {
				order_set.set(curr_layer, i);
				rec_subset(init, curr_layer + 1, total_layer, curr_sum + i, total_sum, order_set);
			}
		}
	}

	public static void main(String[] args) {
		 Problem103.solve();
	}

}
