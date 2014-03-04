import java.util.ArrayList;


public class SpiralMatrix {
	
	public static ArrayList<Integer> Solution(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		int layer = Math.min(n, m) / 2;
		
		for (int i = 0; i < layer; i ++) {
			// top row
			for (int j = i; j < m - i - 1; j ++) {
				result.add(matrix[i][j]);
			}
			// right column
			for (int j = i; j < n - i - 1; j ++) {
				result.add(matrix[j][m - i - 1]);
			}
			// bottom row
			for (int j = m - i - 1; j > i; j --) {
				result.add(matrix[n - i - 1][j]);
			}
			// left column
			for (int j = n - i - 1; j > i; j --) {
				result.add(matrix[j][i]);
			}
		}
		
		// special cases
		if (m % 2 == 1 && n % 2 == 1) {
			if (m >= n) {
				for (int i = layer; i < m - layer; i ++)
					result.add(matrix[layer][i]);
			} else {
				for (int i = layer; i < n - layer; i ++)
					result.add(matrix[i][layer]);
			}
		}
		
		if (m % 2 == 1 && n % 2 == 0 && n > m) {
			for (int i = layer; i < n - layer; i ++)
				result.add(matrix[i][layer]);
		}
		
		if (n % 2 == 1 && m % 2 == 0 && m > n) {
			for (int i = layer; i < m - layer; i ++)
				result.add(matrix[layer][i]);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
