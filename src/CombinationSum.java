/**
 * https://oj.leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * @author BigTiannn {11-19-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> reslist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        helper(candidates, target, 0,  reslist, list);
        
        return reslist;
    }
	
	public void helper(int[] candidates, int target, int start, List<List<Integer>>reslist, List<Integer>list) {
		if (target == 0) {
            reslist.add(new ArrayList<Integer>(list));
            return;
        }
            
        for (int i = start; i < candidates.length && candidates[i] <= target; i ++) {
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i, reslist, list);
            list.remove(list.size() - 1);	// pay attention here! 
            // cannot write as list.remove(candidates[i]), because it gonna treat candidates[i] as the index of list instead of the element
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
