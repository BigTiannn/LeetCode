/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author BigTiannn {10-30-2014}
 *
 */

public class RemoveDuplicatesFromSortedArrayII {
	
	public static int removeDuplicates(int[] A) {
		int flag = 0, ptr = 0, newLen = A.length;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] == A[ptr]) {
                flag ++;
                if (flag >= 2) {
                    newLen --;
                } else {
                    A[++ ptr] = A[i];
                }
            } else {
                flag = 0;
                A[++ ptr] = A[i];
            }
        }
        return newLen;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[1];
		int len = removeDuplicates(A);
		for (int i = 0;i < A.length; i ++)
			System.out.print(A[i]);
		System.out.println();
		System.out.println(len);
		
	}

}
