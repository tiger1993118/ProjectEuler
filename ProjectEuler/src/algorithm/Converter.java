package algorithm;

public class Converter {
	
	public static int[][] parseIntArray(String[][] s) {
		int[][] sets = new int[s.length][];
		for(int i=0; i<s.length; i++) {
			sets[i] = new int[s[i].length];
			for(int j=0; j<s[i].length; j++) {
				sets[i][j] = Integer.parseInt(s[i][j]);
			}
		}
		return sets;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
