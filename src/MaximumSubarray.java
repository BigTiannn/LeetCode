/**
 * https://oj.leetcode.com/problems/maximum-subarray/
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.
 * For example, given the array [-2, 1, -3, 4, -1, 2, 1, -5, 4],
 * the contiguous subarray [4, -1, 2, 1] has the largest sum = 6.
 * 
 * @author BigTiannn {11-05-2014}
 *
 */

public class MaximumSubarray {
	// DP
	public int maxSubArray(int[] A) {
        int maxSum = A[0];
        int tmpSum = A[0];
        for (int i = 1; i < A.length; i ++) {
            maxSum = Math.max(maxSum, tmpSum);
            if (tmpSum < 0) {
                tmpSum = A[i];
            } else {
            	// also need to update the maxSum first
            	// for the case: [-1, 0, -2]
                tmpSum += A[i];
            }
        }
        
        /* A easier way to understand
        for (int i = 1; i < A.length; i ++) {
            if (tmpSum < 0) {
                maxSum = Math.max(maxSum, tmpSum);
                tmpSum = A[i];
            } else if (A[i] < 0) {
                maxSum = Math.max(maxSum, tmpSum);
                tmpSum += A[i];
            } else {
                tmpSum += A[i];
            }
        } */
        
        return Math.max(maxSum, tmpSum);
    }
	
	//TODO: divide-and-conquer

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
