/**
 * Find longest increasing sequence in a 2d array
 * Consider  a 4 * 4 grid:
 *  2  3   4   5
 *  4  5  10  11
 * 20  6   9  12
 *  6  7   8  40
 * Output: 4 5 6 7 8 9 10 11 12
 *
 * @author BigTiannn {02/23/2015}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	// 1. fill the dp matrix
	public static int fill(int[][] grid, int r, int c, int[][] dp){
		int m = grid.length, n = grid[0].length;
		if (r < 0 || c < 0 || r >= m || c >= n)	return 0;
		
		if (dp[r][c] != 0)	return dp[r][c];
		
		int left = 0, right = 0, down = 0, up = 0;
		if (r - 1 >= 0 && grid[r - 1][c] == grid[r][c] + 1)
			up = fill(grid, r - 1, c, dp);
		if (r + 1 < m && grid[r + 1][c] == grid[r][c] + 1)
			down = fill(grid, r + 1, c, dp);
		if (c - 1 >= 0 && grid[r][c - 1] == grid[r][c] + 1)
			left = fill(grid,r,c-1,dp);
		if (c + 1 < n && grid[r][c + 1] == grid[r][c] + 1)
			right = fill(grid,r,c+1,dp);
		
		dp[r][c] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
		return dp[r][c];
	}
	
	// 2. loop the matrix for filling
	public static int filldp(int[][] grid, int[][] dp){
		if (grid.length == 0 || grid[0].length == 0)
			throw new IllegalArgumentException("");
		
		int m = grid.length, n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i ++){
			for (int j = 0; j < n; j ++){
				if (dp[i][j] == 0){
					max = Math.max(max, fill(grid, i, j, dp));
				} else {
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}
	
	//4. DFS for finding snake paths
	public static void findall(int[][] grid, int[][] dp, List<List<Integer>> paths, List<Integer> one, int r, int c){
		if(dp[r][c] == 1){
			one.add(grid[r][c]);
			paths.add(one);
			return;
		}
		
		one.add(grid[r][c]);
		if (r - 1 >= 0 && dp[r - 1][c] == dp[r][c] - 1 && grid[r - 1][c] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r - 1, c);
		if (r + 1 < grid.length && dp[r + 1][c] == dp[r][c] - 1 && grid[r + 1][c] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r + 1, c);
		if (c - 1 >= 0 && dp[r][c - 1] == dp[r][c] - 1 && grid[r][c - 1] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r, c - 1);
		if (c + 1 < grid[0].length && dp[r][c + 1] == dp[r][c] - 1 && grid[r][c + 1] == grid[r][c] + 1)
			findall(grid, dp, paths, new ArrayList<Integer>(one), r, c + 1);
	}
	
	// 3. main function for finding all the snake sequences
	// assume we just need to find the elements along the snake paths not the coordinates
	public static List<List<Integer>> findAllSnakes(int[][] grid){
		if (grid.length == 0 || grid[0].length == 0)
			throw new IllegalArgumentException("");
			
		List<List<Integer>> res = new ArrayList<>();
		int m = grid.length, n = grid[0].length;
		int[][] dp = new int[m][n];
			
		int max = filldp(grid, dp);
		for (int i = 0; i < m; i ++){
			for (int j = 0; j < n; j ++){
				if(dp[i][j] == max){
					findall(grid, dp, res, new ArrayList<Integer>(), i, j);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{2, 3, 4, 5}, {4, 5, 10, 11}, {20, 6, 9, 12}, {6, 7, 8, 40}};
		List<List<Integer>> res = findAllSnakes(grid);
		for (int i = 0; i < res.size(); i ++) {
			System.out.println(Arrays.toString(res.get(i).toArray()));
		}
	}

}
