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
        if (board[row][col] != word.charAt(windex))
            return false;
            
        if (windex == word.length() - 1)
            return true;
            
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
