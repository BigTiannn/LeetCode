/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * 
 * @author BigTiannn
 */

public class MaximumProductSubarray {
	
	public static int solution1 (int[] A) {
		if (A.length == 0)
			return -1;
		
		int maxPos = A[0], minNeg = A[0], maxProduct = A[0];
		
		for (int i = 1; i < A.length; i ++) {
			if (A[i] >= 0) {
				maxPos = Math.max(maxPos * A[i], A[i]);
				minNeg = Math.min(minNeg * A[i], A[i]);
			} else {
				int tmp = maxPos;
				maxPos = Math.max(minNeg * A[i], A[i]);
				minNeg = Math.min(tmp * A[i], A[i]);
			}
			maxProduct = Math.max(maxPos, maxProduct);
		}
		
		return maxProduct;
  }
	
	public int solution2(int[] nums) {
    int ret = nums[0], currMax = nums[0], currMin = nums[0];
    for (int i = 1; i < nums.length; i ++) {
      int temp = currMax;
      currMax = Math.max(Math.max(currMin * nums[i], currMax * nums[i]), nums[i]);
      currMin = Math.min(Math.min(currMin * nums[i], temp * nums[i]), nums[i]);
      ret = Math.max(ret, currMax);
    }
    return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A1[] = {2, 3, -2, 4};
		int A2[] = {1, -2, -3, 0, 7, -8, -2};
		int A3[] = {6, -3, -10, 0, 2};
		int A4[] = {-1, -3, -10, 0, 60};
		int A5[] = {-2, -3, 0, -2, -40};
		int A6[] = {0, 0, -20, 0};
		int A7[] = {-1};
		int A8[] = {-2, 0, -1};
		int A9[] = {-1, -1};
		int A10[] = {-1, -2, -3, 0};
		int A11[] = {-3, 0, 1, -2};
//		System.out.println(MaximumProductSubarray.maxProduct(A1));
//		System.out.println(MaximumProductSubarray.maxProduct(A2));
//		System.out.println(MaximumProductSubarray.maxProduct(A3));
//		System.out.println(MaximumProductSubarray.maxProduct(A4));
//		System.out.println(MaximumProductSubarray.maxProduct(A5));
//		System.out.println(MaximumProductSubarray.maxProduct(A6));
		System.out.println(MaximumProductSubarray.solution1(A7));
		System.out.println(MaximumProductSubarray.solution1(A8));
		System.out.println(MaximumProductSubarray.solution1(A9));
		System.out.println(MaximumProductSubarray.solution1(A10));
		System.out.println(MaximumProductSubarray.solution1(A11));
	}

}
