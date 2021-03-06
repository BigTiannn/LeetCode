/**
 * https://oj.leetcode.com/problems/3sum/
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array 
 * which gives the sum of zero.
 * 
 * @author BigTiannn {10-30-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] num, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		
		Arrays.sort(num);
    for (int i = 0; i < num.length - 2; i ++) {
      // avoid duplicated answers
      if (i > 0 && num[i] == num[i - 1])  continue;
        		
      int m = i + 1, n = num.length - 1;
      while (m < n) {
        if (num[m] + num[n] + num[i] < target) {
        	m ++;
        } else if (num[m] + num[n] + num[i] > target) {
        	n --;
        } else {
        	List<Integer> l = new ArrayList<>();
        	l.add(num[i]);
        	l.add(num[m]);
        	l.add(num[n]);
        	ret.add(l);
        	m ++;
        	n --;
        	// avoid duplicated answers
        	while (m < n && num[m] == num[m - 1])
        		m ++;
        	while (n > m && num[n] == num[n + 1])
        		n --;
        	}
        }
      }  
      return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,-1,-1,3};
		int[] num2 = {-1,2,1,-4};
		List<List<Integer>> ret = threeSum(num2, -1);
		for (List<Integer> list : ret)
			System.out.println(Arrays.toString(list.toArray()));
	}

}
