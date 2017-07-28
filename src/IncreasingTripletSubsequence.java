import java.util.Arrays;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/tabs/description
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3 
 * exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5], return true.
 * Given [5, 4, 3, 2, 1], return false.
 * 
 * @author BigTiannn
 *
 */
public class IncreasingTripletSubsequence {
  
  // time complexity: O(n^2)
  // space complexity: O(n)
  public static boolean solution(int[] nums) {
    // dp[i] stores how many numbers before i are smaller than nums[i]
    int dp[] = new int[nums.length];
    // initialize dp[] with 1
    for (int i = 0; i < nums.length; i ++) 
      dp[i] = 1;
    
    for (int i = 0; i < nums.length; i ++) {
      for (int j = 0; j < i; j ++) {
        if (nums[j] < nums[i]) 
          dp[i] = Math.max(dp[i], dp[j] + 1);
        if (dp[i] >= 3)   return true;
      }
    }
    return false;
  }
  
  // time complexity: O(n)
  // space complexity: O(1)
  public static boolean solution2(int[] nums) {
    int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= smallest) smallest = num;
      else if (num <= secondSmallest) secondSmallest = num;
      else return true;
    }
    return false;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int test[] = {2, 4, -2, -3};
    System.out.println(solution(test));
  }

}
