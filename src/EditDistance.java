import java.util.Arrays;


public class EditDistance {
	
	public static int minDistance(String word1, String word2) {
		if ((word1 == null || word1.length() ==0) && word2 != null) 
			return word2.length();
		if ((word2 == null || word2.length() ==0) && word1 != null)
			return word1.length();
		if (word1 == null && word2 == null)
			return 0;
		
		int m = word1.length(), n = word2.length();
		int[][] dist = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i ++)
			dist[i][0] = i;
		
		for (int j = 0; j <= n; j ++)
			dist[0][j] = j;
		
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if (word1.charAt(i) == word2.charAt(j))
					dist[i+1][j+1] = dist[i][j];
				else
					dist[i+1][j+1] = min(dist[i][j], dist[i][j+1], dist[i+1][j]) + 1;
			}
		}
		
		return dist[m][n];
	}
	
	public static int min(int num1, int num2, int num3) {
		int mid = num1 <= num2 ? num1 : num2;
		return mid<= num3 ? mid : num3;
	}

	public static void main(String[] args) {
		String word1 = "zologicoarchaeo";
		String word2 = "zogeo";
		System.out.println(minDistance(word1, word2));
	}

}
