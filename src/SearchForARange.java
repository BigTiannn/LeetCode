/**
 * https://oj.leetcode.com/problems/search-for-a-range/
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * @author BigTiannn {11-14-2014}
 *
 */

public class SearchForARange {
	
    public int[] searchRange(int[] A, int target) {
    	int low = 0, high = A.length - 1;
        int ret[] = {-1, -1};
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < A[mid]) {
                high = mid - 1;
            } else if  (target > A[mid]){
                low = mid + 1;
            } else {
                while (mid >= 0 && A[mid] == target)
                    mid --;
                ret[0] = ++ mid;
                while (mid < A.length && A[mid] == target)
                    mid ++;
                ret[1] = -- mid;
                break;
            }
        }
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
