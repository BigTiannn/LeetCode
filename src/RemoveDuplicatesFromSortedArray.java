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
		if (A.length < 2)
            return A.length;
            
        int newLength = 1;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] == A[newLength - 1])
                continue;
            A[newLength ++] = A[i];
        }
        
        return newLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
