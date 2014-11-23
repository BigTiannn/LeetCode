/**
 * https://oj.leetcode.com/problems/sudoku-solver/
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * @author BigTiannn {11-22-2014}
 *
 */

public class SudokuSolver {
	
	public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        helper(board, 0, 0);
    }
	
	public boolean helper(char[][] board, int row, int col) {
        if (col >= 9)
            return helper(board, row + 1, 0);
        if (row == 9)
            return true;
            
        if (board[row][col] == '.') {
            // test every possible number
            for (int i = 1; i <= 9; i ++) {
                if (isValidGuess(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, row, col + 1))
                        return true;
                    board[row][col] = '.';
                }
            }
        } else {
            return helper(board, row, col + 1);
        }
        
        return false;
    }
	
	public boolean isValidGuess(char[][] board, int row, int col, int guess) {
        // check row
        for (int i = 0; i < 9; i ++) {
            if (i != col && board[row][i] - '0' == guess)
                return false;
        }
        
        // check column
        for (int i = 0; i < 9; i ++) {
            if (i != row && board[i][col] - '0' == guess)
                return false;
        }
        
        // check 3*3 cube
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i ++) {  
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j ++) {  
                if ((i != row || j != col) && board[i][j] - '0' == guess)  
                    return false;  
            }
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
