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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
