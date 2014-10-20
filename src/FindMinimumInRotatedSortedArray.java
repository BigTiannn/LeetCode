
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
}
