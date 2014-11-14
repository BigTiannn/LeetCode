/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 *
 * @author BigTiannn {11-13-2014}
 *
 */

public class SearchInRotatedSortedArrayII {
	
	public boolean search(int[] A, int target) {
		int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target)
                return true;
                
            // the pivot is in the second half of A
            if (A[low] < A[mid]) {
                if (target < A[mid] && target >= A[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // the pivot is in the first half of A
            else if (A[low] > A[mid]) {
                if (target > A[mid] && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else
                low ++;
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// corner case: A = {1, 3, 1, 1, 1}, target = 3
	}

}
