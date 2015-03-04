/**
 * https://oj.leetcode.com/problems/rotate-array/
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * @author BigTiannn {03-03-2015}
 *
 */

public class RotateArray {
	
	// space complexity: O(k)
	public void rotate_1(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        
        int[] tmp = new int[k];
        for (int i = 0; i < k; i ++)
            tmp[i] = nums[len - k + i];
        for (int i = len - k - 1; i >= 0; i --)
            nums[i + k] = nums[i];
        for (int i = 0; i < k; i ++)
            nums[i] = tmp[i];
        return;
    }
	
    // in-place implementation
    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return;
    }
    
    private void reverse(int[] array, int start, int end) {
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start ++;
            end --;
        }
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
