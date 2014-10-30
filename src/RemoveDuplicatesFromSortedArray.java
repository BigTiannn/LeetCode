/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given a sorted array, remove the duplicates in place such that each 
 * element appear only once and return the new length.
 * 
 * @author BigTiannn {10-29-2014}
 *
 */

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		
		int newLen = A.length;
		int ptr = 0;
        for (int i = 1; i < A.length; i ++) {
        	if (A[i] != A[ptr]) {
        		ptr ++;
        		A[ptr] = A[i];
        	} else {
        		newLen --;
        	}
        }
        
        return newLen;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
