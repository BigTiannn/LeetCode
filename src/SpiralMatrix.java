/**
 * https://oj.leetcode.com/problems/spiral-matrix/
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 * For example, Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author BigTiannn {11-30-2014}
 * 
 */

import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0)
            return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // x for row, y for col
        int x = 0, y = 0;
        
        while (m > 0 && n > 0) {
            // special cases: only one row/column left
            if (m == 1) {
                for (int i = 0; i < n; i ++)
                    res.add(matrix[x][y ++]);
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i ++)
                    res.add(matrix[x ++][y]);
                break;
            }
            
            // top
            for (int i = 0; i < n - 1; i ++)
                res.add(matrix[x][y ++]);
                
            // right
            for (int i = 0; i < m - 1; i ++)
                res.add(matrix[x ++][y]);
                
            // bottom
            for (int i = 0; i < n - 1; i ++)
                res.add(matrix[x][y --]);
                
            // left
            for (int i = 0; i < m - 1; i ++)
                res.add(matrix[x --][y]);
                
            x ++;
            y ++;
            m -= 2;
            n -= 2;
        }
        
        return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
