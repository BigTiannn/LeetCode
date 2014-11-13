/**
 * https://oj.leetcode.com/problems/search-insert-position/
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * 
 * @author BigTiannn {11-12-2014}
 *
 */

public class SearchInsertPosition {
	public static int searchInsert(int[] A, int target) {
		return binarySearch(A, 0, A.length - 1, target);
    }
	
	public static int binarySearch(int[] A, int start, int end, int target) {
		if (start > end)
            return start;
            
        int middle = (start + end) / 2;
        if (target < A[middle])
            return binarySearch(A, start, middle - 1, target);
        else if (target == A[middle])
            return middle;
        else
            return binarySearch(A, middle + 1, end, target);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1};
		System.out.println(searchInsert(A, 0));
	}

}
