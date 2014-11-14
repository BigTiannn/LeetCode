/**
 * https://oj.leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top 
 * left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * @author BigTiannn {11-13-2014}
 *
 */

public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int path[] = new int[n];
        
        // initialize
        path[0] = grid[0][0];
        for (int i = 1; i < n; i ++)
            path[i] = path[i - 1] + grid[0][i];
        
        // DP
        for (int i = 1; i < m; i ++) {
            path[0] += grid[i][0];
            for (int j = 1; j < n; j ++) {
                path[j] = Math.min(path[j - 1], path[j]) + grid[i][j];
            }
        }
        
        return path[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
