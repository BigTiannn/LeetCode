import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/tabs/description
 * 
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must 
 * have the same probability of being returned.
 *
 * Example:
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * 
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * 
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * 
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 *
 * @author BigTiannn
 *
 */

public class InsertDeleteGetRandomO1 {
  private List<Integer> list;
  private HashMap<Integer, Integer> map;
  private Random random;
  /** Initialize your data structure here. */
  public InsertDeleteGetRandomO1() {
    list = new ArrayList<>();
    map = new HashMap<>();
    random = new Random();
  }
  
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    } else {
      list.add(val);
      map.put(val, list.size() - 1);
      return true;
    }
  }
  
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (map.containsKey(val)) {
      // swap val with the last item in the list
      int lastIdx = list.size() - 1;
      int idxOfVal = map.get(val);
      if (idxOfVal < lastIdx) {
          list.set(idxOfVal, list.get(lastIdx));
          map.put(list.get(lastIdx), idxOfVal);
      }            
      list.remove(lastIdx);
      map.remove(val);
      return true;
    } else {
      return false;
    }
  }
  
  /** Get a random element from the set. */
  public int getRandom() {
    int idx = random.nextInt(list.size());
    return list.get(idx);
  }
  
  public void print() {
    System.out.println(Arrays.toString(list.toArray()));
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    InsertDeleteGetRandomO1 randomSet = new InsertDeleteGetRandomO1();
    randomSet.insert(1);
    randomSet.print();
    randomSet.remove(2);
    randomSet.print();
    randomSet.insert(2);
    randomSet.print();
    System.out.println(randomSet.getRandom());
    randomSet.remove(1);
    randomSet.print();
    randomSet.insert(2);
    randomSet.print();
    System.out.println(randomSet.getRandom());
  }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
