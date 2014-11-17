/**
 * https://oj.leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
 * such that no two queens attack each.
 * 
 * @author BigTiannn {11-16-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	
	public static List<String[]> solveNQueens(int n) {
        int[] colPos = new int[n];
        List<String[]> res = new ArrayList<>();
        
        helper(0, n, colPos, res);
        
        return res;
    }
	
	public static void helper(int row, int n, int[] colPos, List<String[]> res) {
        if (row == n) {
            res.add(printQueen(colPos));
            return;
        }
        
        for (int i = 0; i < n; i ++) {
            colPos[row] = i;
            if (isValid(row, colPos)) {
                helper(row + 1, n, colPos, res);
            }
        }
    }
    
    public static boolean isValid(int row, int[] colPos) {
        for (int i = 0; i < row; i ++) {
            if (colPos[i] == colPos[row] ||
                Math.abs(colPos[i] - colPos[row])  == row - i)
                return false;
        }
        return true;
    }
    
    public static String[] printQueen(int[] colPos) {
        String[] res = new String[colPos.length];
        for (int i = 0; i < colPos.length; i ++) {
            char[] s = new char[colPos.length];
            Arrays.fill(s, '.');
            s[colPos[i]] = 'Q';
            res[i] = String.copyValueOf(s);
            System.out.println(res[i]);
        }
        System.out.println("--------------------");
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQueens(3);
	}

}
