/**
 * https://oj.leetcode.com/problems/subsets/
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * @author BigTiannn {11-15-2015}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	// solution 1
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> retlist = new ArrayList<>();
        List<Integer> currlist = new ArrayList<>();
        
        Arrays.sort(S);
            
        for (int i = 0; i <= S.length; i ++)
            helper(S, i, 0, retlist, currlist);
        
        return retlist;
    }
	
	public void helper(int[] S, int subsetLength, int start, List<List<Integer>> retlist, List<Integer> currlist) {
        if (currlist.size() == subsetLength) {
            retlist.add(new ArrayList<Integer>(currlist));
            return;
        }
        
        for (int i = start; i < S.length; i ++) {
            currlist.add(S[i]);
            helper(S, subsetLength, i + 1, retlist, currlist);
            currlist.remove(currlist.size() - 1);
        }
        
        return;
    }
	
	// solution 2
	public List<List<Integer>> subsets_2(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] selected = new boolean[S.length];
        Arrays.fill(selected, false);
        
        Arrays.sort(S);
        generate(S, selected, 0, res);
        
        return res;
    }
    
    private void generate(int[] S, boolean[] selected, int step, List<List<Integer>> res) {
        if (step == S.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < S.length; i ++) {
                if (selected[i])   list.add(S[i]); 
            }
            res.add(list);
            return;
        }
        
        selected[step] = false;
        generate(S, selected, step + 1, res);
        
        selected[step] = true;
        generate(S, selected, step + 1, res);
        
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
