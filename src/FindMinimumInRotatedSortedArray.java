
/***
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * @author BigTiannn
 */

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return -1;
        
        for (int i = 0; i < num.length; i ++) {
            if (i + 1 < num.length && num[i] > num[i + 1]) {
                return num[i + 1];
            }
        }
        
        return num[0];
    }
	
	// binary search
	public int findMin_2(int[] num) {
		int low = 0, high = num.length - 1;
        int ret = num[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            ret = Math.min(ret, num[mid]);
            // the pivot is in the second half
            if (num[mid] <= num[high]) {
                high = mid - 1;
            }
            // the pivot is in the first half
            else {
                low = mid + 1;
            }
        }
        
        return ret;
    }
	
	/*
	 * This solution is wrong. It cannot pass [4,5,6,1,2,3]
	 * Compare to solution 2, 
	 * there are cases that num[mid] <= num[high] and num[low] <= num[mid] are true at the same time
	 * when this happens, we need to first check the first half
	 */
	public int findMin_3(int[] num) {
        int low = 0, high = num.length - 1;
        int ret = num[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            ret = Math.min(ret, num[mid]);
            // the pivot is in the second half
            if (num[low] <= num[mid]) {
                low = mid + 1;
            }
            // the pivot is in the first half
            else {
                high = mid - 1;
            }
        }
        
        return ret;
    }
}
