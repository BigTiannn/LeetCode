/**
 * https://oj.leetcode.com/problems/combination-sum-ii/
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * 
 * @author BigTiannn {11-19-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> reslist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(num);
        
        helper(num, target, 0,  reslist, list);
        
        return reslist;
    }
    
    public static void helper(int[] num, int target, int start, List<List<Integer>>reslist, List<Integer>list) {
		if (target == 0) {
            reslist.add(new ArrayList<Integer>(list));
            return;
        }
            
        for (int i = start; i < num.length && num[i] <= target; i ++) {
            if (i > start && num[i] == num[i - 1])
                continue;
            list.add(num[i]);
            helper(num, target - num[i], i + 1, reslist, list);
            list.remove(list.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
