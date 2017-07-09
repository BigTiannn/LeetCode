/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that 
 * they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and 
 * you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * @author BigTiannn
 *
 */

public class TwoSumII {
  
  public int[] solution(int[] numbers, int target) {
    int head = 0, tail = numbers.length - 1;
    int res[] = new int[2];
    while (head < tail) {
        if (numbers[head] + numbers[tail] > target) {
            tail --;
        } else if (numbers[head] + numbers[tail] < target) {
            head ++;
        } else {
            res[0] = head + 1;
            res[1] = tail + 1;
            break;
        }
    }
    return res;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
