/**
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 * Given an integer n, generate a square matrix filled with 
 * elements from 1 to n^2 in spiral order.
 * For example, n = 3,
 * Return
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * @author BigTiannn {11-22-2014}
 *
 */
public class SpiralMatrixII {
	
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int count = 1;
        
        while (top <= n / 2) {
            // top
            for (int i = left; i < right; i ++) {
                res[top][i] = count ++;
            }
            // right
            for (int i = top; i < bottom; i ++) {
                res[i][right] = count ++;
            }
            // bottom
            for (int i = right; i > left; i --) {
                res[bottom][i] = count ++;
            }
            // left
            for (int i = bottom; i > top; i --) {
                res[i][left] = count ++;
            }
            top ++;
            bottom --;
            left ++;
            right --;
        }
        
        // n is odd number
        if (n % 2 == 1) {
            res[n / 2][n / 2] = count;
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
