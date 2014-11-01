/**
 * https://oj.leetcode.com/problems/3sum-closest/
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that 
 * each input would have exactly one solution.
 * 
 * @author BigTiannn {10-31-2014}
 *
 */

import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
	
	public static int threeSumClosest(int[] num, int target) {
        int diff = Integer.MAX_VALUE;
        int ret = 0;
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i ++) {
        	int start = i + 1, end = num.length - 1;
        	while (start < end) {
        		int sum = num[i] + num[start] + num[end];
        		int newDiff = Math.abs(sum - target);
        		if (newDiff < diff) {
    				diff = newDiff;
    				ret = sum;
    			}
        		if (sum < target) {
        			start ++;
        		} else if (sum > target) {
        			end --;
        		} else {
        			return target;
        		}
        	}
        }
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,-1,-1,3};
		int[] num2 = {-1,2,1,-4};
		int ret = threeSumClosest(num2, -1);
		System.out.println(ret);

	}

}
