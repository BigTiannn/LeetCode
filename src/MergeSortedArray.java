/**
 * https://oj.leetcode.com/problems/merge-sorted-array/
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B. The number of elements initialized in A and 
 * B are m and n respectively.
 * 
 * @author BigTiannn {10-23-2014}
 *
 */

public class MergeSortedArray {
	
	public void merge(int A[], int m, int B[], int n) {
        int a = 0, b = 0;
        while (a < m && b < n) {
            // find all the elements B[b + i] <= A[a]
            int i = 0;
            for (; i + b < n && B[i + b] <= A[a]; i ++)
                ;
            // all the elements whose index falls [b, b + i) should be in front of A[i]
            if (i == 0) {
                a ++;
                continue;
            }
            // move elements whose index is greater than a backwards.
            for (int j = m - 1; j >= a; j --) {
                A[j + i] = A[j];
            }
            // insert B[i + b] into A from a to (a + i)
            for (int k = 0; k < i; k ++) {
                A[a + k] = B[b + k];
            }
            a += i;
            b += i;
            m += i;
        }
        
        // append the rest of B to A
        if (b < n) {
            for (int i = b; i < n; i ++) {
                A[m + i - b] = B[i];
            }
        }
        
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
