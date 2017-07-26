/**
 * https://oj.leetcode.com/problems/valid-sudoku/
 * The Sudoku board could be partially filled, where empty cells 
 * are filled with the character '.'
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated.
 * 
 * @author BigTiannn {10-23-2014}
 *
 */

public class ValidSudoku {
	
	public static boolean solution(char[][] board) {
		if (board.length != 9 || board[0].length != 9)
      return false;
        
		// check every row
    for (int i = 0; i < 9; i ++) {
      boolean number[] = new boolean[10];
      for (int j = 0; j < 9; j ++) {
        if (board[i][j] == '.')
          continue;
        if (number[board[i][j] - '0']) //existed
          return false;
        else
          number[board[i][j] - '0'] = true;
      }
    }
        
    // check every column
    for (int i = 0; i < 9; i ++) {
      boolean number[] = new boolean[10];
      for (int j = 0; j < 9; j ++) {
        if (board[j][i] == '.')
          continue;
        if (number[board[j][i] - '0'])
          return false;
        else
          number[board[j][i] - '0'] = true;
      }
    }
        
    // check every 3*3 box
    for (int m = 0; m < 9; m += 3) {
      for (int n = 0; n < 9; n += 3) {
        boolean number[] = new boolean[10];
        for (int i = 0; i < 3; i ++) {
          for (int j = 0; j < 3; j ++) {
            if (board[m + i][n + j] == '.')
              continue;
            if (number[board[m + i][n + j] - '0'])
              return false;
            else
              number[board[m + i][n + j] - '0'] = true;
          }
        }
      }
    }
    return true;
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  char[][] test = {
	      {'.','.','4','.','.','.','6','3','.'},
	      {'.','.','.','.','.','.','.','.','.'},
	      {'5','.','.','.','.','.','.','9','.'},
	      {'.','.','.','5','6','.','.','.','.'},
	      {'4','.','3','.','.','.','.','.','1'},
	      {'.','.','.','7','.','.','.','.','.'},
	      {'.','.','.','5','.','.','.','.','.'},
	      {'.','.','.','.','.','.','.','.','.'},
	      {'.','.','.','.','.','.','.','.','.'}
	  };
	  System.out.println(solution(test));
	}

}
