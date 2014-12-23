import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author BigTiannn
 *
 */
public class MajorityElement {
	
	/*
	 * Solution 1: Hashmap
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i ++) {
            if (!map.containsKey(num[i])) {
                map.put(num[i], 1);
            } else {
                map.put(num[i], map.get(num[i]) + 1);
            }
        }
        
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            if ((int)entry.getValue() >= (num.length + 1) / 2)
                return (int)entry.getKey();
        }
        
        return num[0];
    }
	
	/*
	 * Solution 2: Moore's Voting Algorithm
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public int majorityElement_2(int[] num) {
        int major = 0, counter = 1;
        for (int i = 1; i < num.length; i ++) {
            if (num[major] == num[i])
                counter ++;
            else
                counter --;
            if (counter == 0) {
                major = i;
                counter = 1;
            }
        }
        
        return num[major];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
