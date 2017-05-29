package part2.problem101to110;

import java.util.Arrays;

public class Problem106 {
	
	public static void solve() {
		int total = 0;
		for(int i = 1; i <= 6; i++) {
			// Count the number of comparsion of subset for each size 
			total += rec_check_subset(12, new Integer[i], new Integer[i], 0, 0, i, 0);
		}
		// Divided by 2 because AD vs BC was counted the 2nd time as BC vs AD
		System.out.println(total/2);
	}
	
	private static int rec_check_subset(int set_size, Integer[] indexA, Integer[] indexB, int layerA, int layerB, int size, int total) {
		if(layerA == size && layerB == size) {// Find subset A and B
			// The necessity to compare A and B 
			// if not all the elements in A are strictly smaller than the elements in B, or vice versa
			boolean[] check = {false, false};
			for(int i = 0; i < size; i++) {
				if(indexA[i] < indexB[i])// If some element in A is smaller than element in B, check check[0]
					check[0] = true;
				else if(indexB[i] < indexA[i])// If some element in A is larger than element in B, check check[0] 
					check[1] = true;
			}
			if(check[0] && check[1])//If both conditions satisfied, we need to compare these two subsets 
				total += 1;
		}
		else if(layerA == size) {// Determine subset B after subset A is all set
			int start;
			if(layerB == 0) {// First 
				start = 0;
			}else {// Last value + 1
				start = indexB[layerB-1] + 1;
			}
			for(int i = start; i < set_size; i++) {// Loop the value 
				if(!(Arrays.asList(indexA).contains(i))) {
					indexB[layerB] = i;
					total = rec_check_subset(set_size, indexA, indexB, layerA, layerB+1, size, total);
				}
			}
		}else {// Determine subset A first
			int start;
			if(layerA == 0) {// First 
				start = 0;
			}else {// Last value + 1
				start = indexA[layerA-1] + 1;
			}
			int limit = set_size - (size - indexA.length);
			for(int i = start; i < limit; i++) {// Loop the value 
				indexA[layerA] = i;
				total = rec_check_subset(set_size, indexA, indexB, layerA+1, layerB, size, total);
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		Problem106.solve();
	}
}
