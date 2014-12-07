/**
 * http://oj.leetcode.com/problems/permutations/
 * Given a collection of numbers, return all possible permutations.
 * 
 * @author BigTiannn {12-06-2014}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	/* non-recursive implementation
	 * loop through the array, add a new element to the previous result in each iteration
	 */
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null)
        	return result;
        
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i ++) {
        	ArrayList<ArrayList<Integer>> current = new ArrayList<>();
        	
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
	public List<List<Integer>> permute_r(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
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
            visited[i] = true;;
            list.add(num[i]);
            helper(num, step + 1, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
	
	// recursive implementation 2
	public static void perm(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
		if (start >= num.length) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < num.length; i ++)
				list.add(num[i]);
			result.add(list);
		}
		
		for (int i = start; i < num.length; i ++) {
			swap(num, start, i);
			perm(num, start + 1, result);
			swap(num, start, i);
		}
			
	}
	
	public static void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	
	public static void main(String[] args) {
//		int[] num = {1, 2, 3};
//		ArrayList<ArrayList<Integer>> res = permute(num);
//		for(ArrayList<Integer> list : res)
//			System.out.println(Arrays.toString(list.toArray()));
		
		int[] num = {1, 2, 3};
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		perm(num, 0, res);
		for(ArrayList<Integer> list : res)
			System.out.println(Arrays.toString(list.toArray()));
	}

}
