/**
 * https://leetcode.com/problems/number-of-islands/description/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands 
 * horizontally or vertically. You may assume all four edges of the grid are all 
 * surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * 
 * @author BigTiannn
 *
 */

public class NumberOfIslands {
  
  public int solution(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
        return 0;
    
    int m = grid.length, n = grid[0].length, count = 0;
    int[][] visited = new int[m][n];
    for (int i = 0; i < m; i ++) {
      for (int j = 0; j < n; j ++) {
        if (grid[i][j] == '1' && visited[i][j] == 0) {
          findIsland(grid, visited, i, j);
          count ++;
        }
      }
    }
    return count;
  }
  private void findIsland(char[][] grid, int[][] visited, int i, int j) {
    int m = grid.length, n = grid[0].length;
    visited[i][j] = 1;
    if (i - 1 >= 0 && grid[i - 1][j] == '1' && visited[i - 1][j] == 0) {
      findIsland(grid, visited, i - 1, j);
    }
    if (i + 1 < m && grid[i + 1][j] == '1' && visited[i + 1][j] == 0) {
      findIsland(grid, visited, i + 1, j);
    }
    if (j - 1 >= 0 && grid[i][j - 1] == '1' && visited[i][j - 1] == 0) {
      findIsland(grid, visited, i, j - 1);
    }
    if (j + 1 < n && grid[i][j + 1] == '1' && visited[i][j + 1] == 0) {
      findIsland(grid, visited, i, j + 1);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
