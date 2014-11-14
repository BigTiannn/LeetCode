/**
 * https://oj.leetcode.com/problems/combinations/
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example, if n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 * 
 * @author BigTiannn {11-13-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> retlist = new ArrayList<>();
        List<Integer> currlist = new ArrayList<>();
        
        if (n < k)
            return retlist;
            
        helper(n, k, 1, retlist, currlist);
        
        return retlist;
    }
	
	public void helper(int n, int k, int start, List<List<Integer>> retlist, List<Integer> currlist) {
        if (currlist.size() == k) {
            retlist.add(new ArrayList<Integer>(currlist));
            return;
        }
        
        for (int i = start; i <= n; i ++) {
            currlist.add(i);
            helper(n, k, i + 1, retlist, currlist);
            currlist.remove(currlist.size() - 1);
        }
        
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
