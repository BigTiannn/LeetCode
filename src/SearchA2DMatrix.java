/**
 * https://oj.leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * @author BigTiannn {11-12-2014}
 *
 */

public class SearchA2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        while (i < m && matrix[i][n - 1] < target) {
            i ++;
        }
        
        if (i == m)
            return false;
        
        // binary search in this row
        int low = 0, high = n - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target < matrix[i][middle]) {
                high = middle - 1;
            } else if (target > matrix[i][middle]) {
                low = middle + 1;
            } else {
                return true;
            }
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
