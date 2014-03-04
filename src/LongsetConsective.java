import java.util.HashMap;
import java.util.Map;


public class LongsetConsective {
	
	public static int Solution(int[] num) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 1;
		for (int i = 0; i < num.length; i ++) {
			if (map.containsKey(num[i]))
				continue;
			else {
				map.put(num[i], 1);
				if (map.containsKey(num[i] - 1))
					maxLen = Math.max(maxLen, mergeInterval(map, num[i] - 1, num[i]));
				if (map.containsKey(num[i] + 1))
					maxLen = Math.max(maxLen, mergeInterval(map, num[i], num[i] + 1));
			}
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
		int[] num = {100, 1, 4, 200, 3, 2};
		System.out.println(Solution(num));
	}

}
