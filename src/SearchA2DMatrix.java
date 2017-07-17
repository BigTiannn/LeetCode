/**
 * https://oj.leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
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
	
	// solution 2: binary search
	public boolean searchMatrix_2(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
        
    int low = 0, high = m * n - 1;
        
    while (low <= high) {
      int mid = (low + high) / 2;
      int val = matrix[mid / n][mid % n];
      if (val > target) {
        high = mid - 1;
      } else if (val < target) {
        low = mid + 1;
      } else {
        return true;
      }
    }    
    return false;
  }
	
	// solution 3: improved the solution 2, two-time binary search
	public boolean solution(int[][] matrix, int target) {
	  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
	    return false;
	  
	  int m = matrix.length, n = matrix[0].length;
	  int low = 0, high = m - 1;
	  while (low <= high) {
	    int mid = (low + high) / 2;
	    if (matrix[mid][0] == target) {
	      return true;
	    } else if (matrix[mid][0] > target) {
	      high = mid - 1;
	    } else {
	      low = mid + 1;
	    }
	  }
	  
	  if (high < 0) return false;
	  
	  int row = high;
	  low = 0;
	  high = n - 1;
	  while (low <= high) {
	    int mid = (low + high) / 2;
	    if (matrix[row][mid] == target) {
	      return true;
	    } else if (matrix[row][mid] > target) {
	      high = mid - 1;
	    } else {
	      low = mid + 1;
	    }
	  }
	  
	  return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
