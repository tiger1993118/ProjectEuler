package part2.problem101to110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import algorithm.File;
import algorithm.Tuple;

public class Problem107 {

	
	public static void solve() {
		// Read File
		String[][] s = File.readFile("raw/p107_network.txt", "\n", ",");
		
		//Construction
		Boolean[][] connected = new Boolean[s.length][];// is vertex i connected to j
		List<Integer> all = new ArrayList<Integer>();// All the distances sorted from smallest to largest
		// The Map between distance and the edge(i.e. the endpoints tuple)
		HashMap<Integer, List<Tuple<Integer, Integer>>> map = new HashMap<Integer, List<Tuple<Integer, Integer>>>();
		List<Tuple<Integer, Integer>> values;// The edge(i.e. the endpoints tuple)
		int total_weight = 0;// Total weight of the graph
		for(int i=0; i<s.length; i++) {
			Integer dis;
			// Initialize array for vertex i
			connected[i] = new Boolean[s[i].length];
			for(int j=0; j<s[i].length; j++) {
				if(!s[i][j].equals("-")) { 
					// There is edge between vertex i and j
					dis = Integer.parseInt(s[i][j]);// weight between vertex i and j
					total_weight += dis;// Add to total weight
					all.add(dis);// Add distance to all distances
					if(map.containsKey(dis)) {// Set the corresponding key-value in map
						values = map.get(dis);
						values.add(new Tuple<Integer, Integer>(i, j));
						//IMPORTANT NOTES
						// UPDATE VALUES, IT WILL AUTOMATICALLY UPDATE THE HASHMAP
						//SAME THING APPLIES TO ANY DATA STRUCTURE
						// ARRAY, LIST, ...
						// you're just storing a copy of the pointer, not the list.
						// Java is pass-by-reference-by-value.
					} else {
						values = new ArrayList<Tuple<Integer, Integer>>();
						values.add(new Tuple<Integer, Integer>(i, j));
						map.put(dis, values);
					}
				}
				if(i == j) 
					connected[i][j] = true;// The vertex is connected to itself
				else
					connected[i][j] = false;// Initially, nothing connected, since no edges were chosen
			}
		}
		Collections.sort(all);
		total_weight /= 2;
		//Minimum-edges method
		Integer i, j;
		int total_edges = 0;
		int mini_weight = 0;// total weight of the minimum graph
		for(int dis : all) {// Current minimum weight of edge
			values = map.get(dis);// The edge corresponding to this distance
			// The endpoint vertices i and j
			i = values.get(0).x;
			j = values.get(0).y;
			//Check Connection
			// If i and j not connected, add this edge to minimum set
			if (!connected[i][j]) {
				// Updating connectivity of these points
				Boolean i_connected, j_connected;
				for(int k = 0; k < connected.length; k++) {// Updating connection of i first
					i_connected =  connected[i][k];
					if(i_connected) {// All the vertices connected to i
						for(int l = 0; l < connected.length; l++) {
							j_connected =  connected[j][l];// All the vertices connected to j
							if(j_connected) {// They are connected now
								connected[k][l] = true;
							}
						}
					}
				}
				for(int k = 0; k < connected.length; k++) {// Updating connection of i first
					j_connected =  connected[j][k];
					if(j_connected) {// All the vertices connected to j
						for(int l = 0; l < connected.length; l++) {
							i_connected =  connected[i][l];// All the vertices connected to j
							if(i_connected) {// They are connected now
								connected[k][l] = true;
							}
						}
					}
				}
				mini_weight += dis;// Update total mini weights
				total_edges += 1;// Update number of edges
			}			
			values.remove(0);// Remove the edge from the values
		}
		System.out.println(total_edges);
		System.out.println(total_weight - mini_weight);
	}
	
	public static void main(String[] args) {
		Problem107.solve();		
	}
}
