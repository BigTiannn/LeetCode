/**
 * http://oj.leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * 
 * @author BigTiannn {12-06-2014}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null)
        	return result;
        
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i ++) {
        	HashSet<ArrayList<Integer>> current = new HashSet<>();
        	
        	for (ArrayList<Integer> list : result) {
        		for (int j = 0; j <= list.size(); j ++) {
        			list.add(j, num[i]);
        			ArrayList<Integer> tmp = new ArrayList<>(list);
        			current.add(tmp);
        			list.remove(j);
        		}
        	}
        	result = new ArrayList<ArrayList<Integer>>(current);
        }
        
        return result;
    }
	
	// recursive implementation
	public List<List<Integer>> permuteUnique_r(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        Arrays.sort(num);
        helper(num, 0, res, list, visited);
        return res;
    }
    
    public void helper(int[] num, int step, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (step == num.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < num.length; i ++) {
            if (visited[i])
                continue;
            if (i > 0 && num[i] == num[i - 1] && !visited[i - 1])
                continue;
            visited[i] = true;;
            list.add(num[i]);
            helper(num, step + 1, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

	public static void main(String[] args) {
		int[] num = {1, 1, 2};
		ArrayList<ArrayList<Integer>> res = permuteUnique(num);
		for(ArrayList<Integer> list : res)
			System.out.println(Arrays.toString(list.toArray()));
	}

}
