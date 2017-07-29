/**
 * https://leetcode.com/problems/game-of-life/tabs/description
 * 
 * According to the Wikipedia's article: "The Game of Life, also known 
 * simply as Life, is a cellular automaton devised by the British mathematician 
 * John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or 
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, 
 * diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its 
 * current state.
 * 
 * Follow up: 
 * Could you solve it in-place? Remember that the board needs to be updated at the 
 * same time: You cannot update some cells first and then use their updated values 
 * to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board 
 * is infinite, which would cause problems when the active area encroaches the border 
 * of the array. How would you address these problems?
 *
 * @author BigTiannn
 *
 */

public class GameOfLife {
  
  /**
   * [2nd bit, 1st bit] = [next state, current state]
   * 00  dead (next) <- dead (current)
   * 01  dead (next) <- live (current)  
   * 10  live (next) <- dead (current)  
   * 11  live (next) <- live (current) 
   * To get the current state: board[i][j] & 1
   * To get the next state: board[i][j] >> 1
   */
  
  public void gameOfLife(int[][] board) {
    int m = board.length, n = board[0].length;
    
    for (int i = 0; i < m; i ++) {
      for (int j = 0; j < n; j ++) {
        int currState = board[i][j] & 1;
        int liveNeighbors = getLiveNeighbors(board, m, n, i, j);
        // only care about when 2nd state turns to live b/c initially it's dead
        if (currState == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
          board[i][j] = 3;
        } else if (currState == 0 && liveNeighbors == 3) {
          board[i][j] = 2;
        }
      }
    }
    
    for (int i = 0; i < m; i ++) {
      for (int j = 0; j < n; j ++) {
        board[i][j] >>= 1;
      }
    }
    return;
 }

  private int getLiveNeighbors(int[][] board, int m, int n, int i, int j) {
    int count = 0;
    for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, m - 1); x ++) {
      for (int y = Math.max(0, j -1); y <= Math.min(j + 1, n - 1); y ++) {
        count += board[x][y] & 1;
      }
    }
    count -= board[i][j] & 1;
    return count;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
