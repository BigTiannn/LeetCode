import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
	public static void Solution (char[][] board) {
		if (board == null || board.length == 0)
			return ;
		
		int m = board.length;
		int n = board[0].length;
		List<Coordinate> list = new ArrayList<>();
		
		// top & bottom border
		for (int i = 0; i < n; i ++) {
			if (board[0][i] == 'O') {
				list.add(new Coordinate(0, i));
			}
			if (board[m-1][i] == 'O') {
				list.add(new Coordinate(m - 1, i));
			}
		}
		
		// left & right border
		for (int i = 0; i < m; i ++) {
			if (board[i][0] == 'O') {
				list.add(new Coordinate(i, 0));
			}
			if (board[i][n-1] == 'O') {
				list.add(new Coordinate(i, n - 1 ));
			}
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
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'P')
					board[i][j] = 'O';
			}
		}
		
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c1 = {'X','O','X','O','X','O'};
		char[] c2 = {'O','X','O','X','O','X'};
		char[] c3 = {'X','O','X','O','X','O'};
		char[] c4 = {'O','X','O','X','O','X'};
		
		char[][] c = {c1, c2, c3, c4};
		
		Solution(c);
		
		for (int i = 0; i < c.length; i ++)
			System.out.println(Arrays.toString(c[i]));
	}

}
