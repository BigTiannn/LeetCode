/**
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * @author BigTiannn
 */
import java.util.HashMap;
import java.util.Map;


public class LongsetConsective {
	
	public static int Solution(int[] num) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 1;
		for (int i = 0; i < num.length; i ++) {
			if (map.containsKey(num[i]))
				continue;
			
			map.put(num[i], 1);
			if (map.containsKey(num[i] - 1))
				maxLen = Math.max(maxLen, mergeInterval(map, num[i] - 1, num[i]));
			if (map.containsKey(num[i] + 1))
				maxLen = Math.max(maxLen, mergeInterval(map, num[i], num[i] + 1));
		}
		return maxLen;
	}
	
	private static int mergeInterval (Map<Integer, Integer> map, int left, int right) {
		int leftBorder = left - map.get(left) + 1;
        int rightBorder = right + map.get(right) - 1;
        int len = rightBorder - leftBorder + 1;
        map.put(leftBorder, len);
        map.put(rightBorder, len);
        return len;
	}

	public static void main(String[] args) {
		int[] num = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		System.out.println(Solution(num));
	}

}
