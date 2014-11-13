/**
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 * Given a m x n matrix, if an element is 0, set its entire row 
 * and column to 0. Do it in place.
 * 
 * @author BigTiannn {11-12-2014}
 *
 */
public class SetMatrixZeroes {
	
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // check if the first row and col need to be zero
        boolean firstRowZero = false, firstColZero = false;
        for (int i = 0; i < n; i ++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        for (int i = 0; i < m; i ++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // traverse the rest of the matrix to find the rows and cols that need to be set to zero
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // set rows and cols to zero
        for (int i = 1; i < m; i ++) {
        	for (int j = 1; j < n; j ++) {
        		if (matrix[0][j] == 0 || matrix[i][0] == 0)
        			matrix[i][j] = 0;
        	}
        }
    
        if (firstRowZero) {
        	for (int i = 0; i < n; i ++)
        		matrix[0][i] = 0;
        }
    
        if (firstColZero) {
        	for (int i = 0; i < m; i ++)
        		matrix[i][0] = 0;
        }
    
        return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
