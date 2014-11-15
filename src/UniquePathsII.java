/**
 * https://oj.leetcode.com/problems/unique-paths-ii/
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. 
 * How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * @author BigTiannn {11-14-2014}
 *
 */
public class UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int path[] = new int [n];
        
        // initialize the first line
        for (int i = 0; i < n; i ++) {
            if (obstacleGrid[0][i] == 0)
                path[i] = 1;
            else
                break;
        }
        
        // DP
        for (int i = 1; i < m; i ++) {
            if (obstacleGrid[i][0] == 1)
                path[0] = 0;
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    path[j] = 0;
                } else {
                    path[j] += path[j - 1];
                }
            }
        }
        
        return path[n - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
