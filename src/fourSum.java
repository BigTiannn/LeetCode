/**
 * https://oj.leetcode.com/problems/4sum/
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? Find all unique quadruplets in the 
 * array which gives the sum of target.
 * 
 * @author BigTiannn {10-31-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
	
	public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i ++) {
        	if (i > 0 && num[i] == num[i - 1])
        		continue;
        	for (int j = i + 1; j < num.length - 2; j ++) {
        		if (j > i + 1 && num[j] == num[j - 1])
        			continue;
        		int start = j + 1, end = num.length - 1;
        		while (start < end) {
        			if (num[i] + num[j] + num[start] + num[end] < target)
        				start ++;
        			else if (num[i] + num[j] + num[start] + num[end] > target)
        				end --;
        			else {
        				List<Integer> list = new ArrayList<>();
        				list.add(num[i]);
        				list.add(num[j]);
        				list.add(num[start]);
        				list.add(num[end]);
        				ret.add(list);
        				start ++;
        				end --;
        				while (start < end && num[start] == num[start - 1])
        					start ++;
        				while (end > start && num[end] == num[end + 1])
        					end --;
        			}
        		}
        	}
        }
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {0, 0, 0, 0};
		List<List<Integer>> ret = fourSum(num, 0);
		System.out.println(Arrays.toString(ret.toArray()));
	}

}
