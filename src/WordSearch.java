/**
 * https://oj.leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * @author BigTiannn {11-14-2014}
 *
 */

public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if(search(board, word, i, j, 0, visited))
                    return true;
            }
        }
        
        return false;
    }
	
	public boolean search(char[][] board, String word, int row, int col, int windex, boolean[][] visited) {
    if (board[row][col] != word.charAt(windex)) return false;  
    if (windex == word.length() - 1)  return true;
        
    visited[row][col] = true;
    // search upwards
    if (row - 1 >= 0 && !visited[row - 1][col] && 
        search(board, word, row - 1, col, windex + 1, visited))
      return true;
    // search downwards
    if (row + 1 < visited.length && !visited[row + 1][col] && 
        search(board, word, row + 1, col, windex + 1, visited))
      return true;
    // search leftwards
    if (col - 1 >= 0 && !visited[row][col - 1] && 
        search(board, word, row, col - 1, windex + 1, visited))
      return true;
    // search rightwards
    if (col + 1 < visited[0].length && !visited[row][col + 1] && 
        search(board, word, row, col + 1, windex + 1, visited))
      return true;
    
    visited[row][col] = false;
    return false;
  }
	
	// a more concise way to write search function
	private boolean helper(char[][] board, String word, int start, int x, int y, boolean[][] visited) {
    if (start == word.length()) return true;
    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)   return false;
    if (word.charAt(start) != board[x][y] || visited[x][y])  return false;
    
    visited[x][y] = true;
    boolean flag = helper(board, word, start + 1, x - 1, y, visited) ||
        helper(board, word, start + 1, x + 1, y, visited) ||
        helper(board, word, start + 1, x, y - 1, visited) ||
        helper(board, word, start + 1, x, y + 1, visited);
        
    visited[x][y] = false;
    return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
