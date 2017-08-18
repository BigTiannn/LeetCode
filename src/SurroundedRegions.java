import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SurroundedRegions {
	
	private static class Coordinate {
		int row;
		int col;
		
		Coordinate (int r, int c) {
			this.row = r;
			this.col = c;
		}
	}
	
	// BFS to find those inactive 'O's, 
	// then the remaining 'O's are those need to be painted to 'X'
	public static void solution (char[][] board) {
		if (board == null || board.length == 0)
			return ;
		
		int m = board.length;
		int n = board[0].length;
		List<Coordinate> list = new ArrayList<>();
		
		// top & bottom border
		for (int i = 0; i < n; i ++) {
			if (board[0][i] == 'O')  list.add(new Coordinate(0, i));
			if (board[m - 1][i] == 'O')  list.add(new Coordinate(m - 1, i));
		}
		
		// left & right border
		for (int i = 0; i < m; i ++) {
			if (board[i][0] == 'O')  list.add(new Coordinate(i, 0));
			if (board[i][n - 1] == 'O')  list.add(new Coordinate(i, n - 1 ));
		}
		
		// BFS to find all inactive 'O' and paint to 'P'
		int ptr = 0;
		while (ptr < list.size()) {
			Coordinate coor = list.get(ptr);
			board[coor.row][coor.col] = 'P';
			if (coor.row > 0 && board[coor.row - 1][coor.col] == 'O')
				list.add(new Coordinate(coor.row - 1, coor.col));
			if (coor.row < m - 1 && board[coor.row + 1][coor.col] == 'O')
				list.add(new Coordinate(coor.row + 1, coor.col));
			if (coor.col > 0 && board[coor.row][coor.col - 1] == 'O')
				list.add(new Coordinate(coor.row, coor.col - 1));
			if (coor.col < n - 1 && board[coor.row][coor.col + 1] == 'O')
				list.add(new Coordinate(coor.row, coor.col + 1));
			ptr ++;
		}
		
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
				if (board[i][j] == 'P') board[i][j] = 'O';
			}
		}
		
		return;
	}
	
	// bfs
	public static void solution2(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0)    return;
    
    int m = board.length, n = board[0].length;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i ++) {
      if (board[0][i] == 'O') queue.add(i);
      if (board[m - 1][i] == 'O') queue.add((m - 1) * n + i);
    }
    for (int i = 0; i < m; i ++) {
      if (board[i][0] == 'O') queue.add(i * n);
      if (board[i][n - 1] == 'O') queue.add(i * n + n - 1);
    }
    while (!queue.isEmpty()) {
      int pos = queue.poll();
      int row = pos / n, col = pos % n;
      board[row][col] = '1';
      if (row - 1 >= 0 && board[row - 1][col] == 'O') queue.add((row - 1) * n + col);
      if (row + 1 < m && board[row + 1][col] == 'O') queue.add((row + 1) * n + col);
      if (col - 1 >= 0 && board[row][col - 1] == 'O') queue.add(row * n + col - 1);
      if (col + 1 < n && board[row][col + 1] == 'O') queue.add(row * n + col + 1);
    }
    for (int i = 0; i < m; i ++) {
      for (int j = 0; j < n; j ++) {
        if (board[i][j] == 'O')  board[i][j] = 'X';
        if (board[i][j] == '1')  board[i][j] = 'O';
      }
    }
    return;
	}
	
	// dfs: This solution causes java.lang.StackOverflowError, because for a large board, 
	// too many method calls are pushed to the stack and causes the overflow.
	public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0)    return;
    
    int m = board.length, n = board[0].length;
    for (int i = 0; i < n; i ++) {
      if (board[0][i] == 'O') dfs(board, 0, i);
      if (board[m - 1][i] == 'O') dfs(board, m - 1, i);
    }
    for (int i = 0; i < m; i ++) {
      if (board[i][0] == 'O')  dfs(board, i, 0);
      if (board[i][n - 1] == 'O')  dfs(board, i, n - 1);
    }
    for (int i = 0; i < m; i ++) {
      for (int j = 0; j < n; j ++) {
        if (board[i][j] == 'O')  board[i][j] = 'X';
        if (board[i][j] == '1')  board[i][j] = 'O';
      }
    }
    return;
  }
  private void dfs(char[][] board, int i, int j) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return;
    if (board[i][j] != 'O') return;
    board[i][j] = '1';
    dfs(board, i - 1, j);
    dfs(board, i + 1, j);
    dfs(board, i, j - 1);
    dfs(board, i, j + 1);
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c1 = {'X','O','X','O','X','O'};
		char[] c2 = {'O','X','O','X','O','X'};
		char[] c3 = {'X','O','X','O','X','O'};
		char[] c4 = {'O','X','O','X','O','X'};
		
//		char[][] c = {c1, c2, c3, c4};
		char[][] cc = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		
		solution2(cc);
		
		for (int i = 0; i < cc.length; i ++)
			System.out.println(Arrays.toString(cc[i]));
	}

}
