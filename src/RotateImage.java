/**
 * https://oj.leetcode.com/problems/rotate-image/
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * @author BigTiannn {11-12-2014}
 *
 */

public class RotateImage {
	
	public void rotate(int[][] matrix) {
        int m = matrix.length;
        
        // first transposition
        for (int i = 0; i < m; i ++) {
            for (int j = i + 1; j < m; j ++) {
                swap(matrix, i, j, j ,i);
            }
        }
        
        // reverse every row
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < m / 2; j ++) {
                swap(matrix, i, j, i, m - j - 1);
            }
        }
    }
	
	public void swap(int m[][], int x1, int y1, int x2, int y2) {
        int tmp = m[x1][y1];
        m[x1][y1] = m[x2][y2];
        m[x2][y2] = tmp;
    }
	
	// solution2: rotate every layer
	public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i ++) {
            for (int j = i; j < n - i - 1; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
