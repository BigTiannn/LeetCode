import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/#/description
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author BigTiannn
 *
 */
public class TwoSum {

  public int[] solution(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int res[] = new int[2];
    for (int i = 0; i < nums.length; i ++) {
        if (map.containsKey(target - nums[i])) {
            res[0] = map.get(target - nums[i]);
            res[1] = i;
            break;
        } else {
            map.put(nums[i], i);
        }
    }
    return res;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
