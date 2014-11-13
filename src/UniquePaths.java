/**
 * https://oj.leetcode.com/problems/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach 
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 
 * @author BigTiannn {11-12-2014}
 *
 */
public class UniquePaths {
	
	public int uniquePaths(int m, int n) {
		int trace[][] = new int[m][n];
        
        // initialize
        for (int i = 0; i < n; i ++)
            trace[0][i] = 1;
        for (int i = 0; i < m; i ++)
            trace[i][0] = 1;
            
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                trace[i][j] = trace[i - 1][j] + trace[i][j - 1];
            }
        }
        
        return trace[m-1][n-1];
    }
	
	// optimize space complexity
	public int uniquePaths_2(int m, int n) {
		int trace[] = new int[n];
        
        // initialize
        for (int i = 0; i < n; i ++)
            trace[i] = 1;
        
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                trace[j] += trace[j - 1];
            }
        }
        
        return trace[n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
