/**
 * https://oj.leetcode.com/problems/n-queens-ii/
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * @author BigTiannn {11-16-2014}
 *
 */

public class NQueensII {
	
	public static int totalNQueens(int n) {
        int[] colPos = new int[n];
        int[] total = {0};
        
        helper(0, n, colPos, total);
        
        return total[0];
    }
    
    public static void helper(int row, int n, int[] colPos, int[] total) {
        if (row == n) {
            total[0] ++;
            return;
        }
        
        for (int i = 0; i < n; i ++) {
            colPos[row] = i;
            if (isValid(row, colPos)) {
                helper(row + 1, n, colPos, total);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(8));
	}

}
