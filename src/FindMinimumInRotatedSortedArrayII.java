/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * 
 * @author BigTiannn {11-13-2014}
 *
 */

public class FindMinimumInRotatedSortedArrayII {
	
	public int findMin(int[] num) {
		int low = 0, high = num.length - 1;
        int ret = num[0];
        
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (num[low] < num[mid]) {
                ret = Math.min(ret, num[low]);
                low = mid + 1;
            } else if (num[low] > num[mid]) {
                ret = Math.min(ret, num[mid]);
                high = mid - 1;
            } else {
                low ++;
            }
        }
        
        ret = Math.min(ret, num[low]);
        ret = Math.min(ret, num[high]);
        
        return ret;
    }
	
	// solution on LeetCode oj
	public int findMin_oj(int[] A) {
		int L = 0, R = A.length - 1;
		while (L < R && A[L] >= A[R]) {
			int M = (L + R) / 2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else if (A[M] < A[L]) {
				R = M;
			} else {   // A[L] == A[M] == A[R]
				L = L + 1;
			}
		}
		return A[L];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
