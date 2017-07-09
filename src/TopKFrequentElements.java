import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: 
 * You may assume k is always valid, 1 <= k <= number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author BigTiannn
 *
 */

public class TopKFrequentElements {
  // use priority queue
  public static List<Integer> solution (int nums[], int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (a,b)->(b.getValue()-a.getValue()));
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      queue.offer(entry);
    }
    
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < k; i ++ ) {
      Map.Entry<Integer, Integer> entry = queue.poll();
      res.add(entry.getKey());
    }
    return res;
  }
  
  // use bucket sort. the range of number's frequency is known
  public static List<Integer> solution2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i ++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    
    List<Integer> buckets[] = new List[nums.length + 1];
    for (int num : map.keySet()) {
        int freq = map.get(num);
        if (buckets[freq] == null) {
            buckets[freq] = new ArrayList<Integer>();
        }
        buckets[freq].add(num);
    }
    
    List<Integer> res = new ArrayList<>();
    for (int i = nums.length; i >= 0 && res.size() < k; i --) {
        if (buckets[i] != null) {
            res.addAll(buckets[i]);
        }
    }
    return res;
}

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
