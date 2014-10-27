import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time 
 * complexity should be O(log (m+n)).
 * 
 * @author BigTiannn {10-26-2014}
 *
 */

public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if (total % 2 == 1)
        	return findKth(A, B, total / 2 + 1);
        else
        	return (findKth(A, B, total / 2) +
        			findKth(A, B, total / 2 + 1)) / 2;
    }
	
	// find the k-th biggest element in A with B
	public static double findKth(int A[], int B[], int k) {
		// always let A be shorter than B
		if (A.length > B.length)
			return findKth(B, A, k);
		
		if (A.length == 0)
			return B[k - 1];
		
		if (k == 1)
			return Math.min(A[0], B[0]);
		
		int pa = Math.min(k / 2, A.length), pb = k - pa;
		if (A[pa - 1] < B[pb - 1]) {
			return findKth(Arrays.copyOfRange(A, pa, A.length), B, k - pa);
		} else if (A[pa - 1] > B[pb - 1]) {
			return findKth(A, Arrays.copyOfRange(B, pb, B.length), k - pb);
		} else {
			return A[pa - 1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1}, B[] = {1};
		findMedianSortedArrays(A, B);
	}

}
