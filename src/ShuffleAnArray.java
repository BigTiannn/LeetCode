import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/#/description
 * Shuffle a set of numbers without duplicates.
 * 
 * Example:
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 
 * Proof:
 * The probability that ith element (including the last one) goes to last position is 1/n, 
 * because we randomly pick an element in first iteration.
 *
 * The probability that ith element goes to second last position can be proved to be 1/n 
 * dividing it in two cases.
 * Case 1: i = n-1 (index of last element):
 * The probability of last element going to second last position is = (probability that 
 * last element doesn't stay at its original position) x (probability that the index 
 * picked in previous step is picked again so that the last element is swapped)
 * So the probability = ((n-1)/n) x (1/(n-1)) = 1/n
 * Case 2: 0 < i < n-1 (index of non-last):
 * The probability of ith element going to second last position = (probability that ith 
 * element is not picked in previous iteration) x (probability that ith element is picked 
 * in this iteration)
 * So the probability = ((n-1)/n) x (1/(n-1)) = 1/n
 * 
 * We can easily generalize above proof for any other position.
 * 
 * @author BigTiannn
 *
 */

public class ShuffleAnArray {
  private int[] initialNums;
  private Random random;
  
  public ShuffleAnArray(int[] nums) {
    this.initialNums = nums;
    this.random = new Random();
  }
  
  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return this.initialNums;  
  }
  
  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int copy[] = this.initialNums.clone();
    for (int i = 1; i < copy.length; i ++) {
        int r = random.nextInt(i + 1);  // i + 1 is the boundary (exclusive)
        swap(copy, i, r);
    }
    return copy;
  }
  
  private void swap(int nums[], int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
