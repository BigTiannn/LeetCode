/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * @author BigTiannn {11-15-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> reslist = new ArrayList<>();
        List<Integer> currlist = new ArrayList<>();
        
        Arrays.sort(num);
        helper(num, 0, currlist, reslist);
        reslist.add(new ArrayList<Integer>());
        
        return reslist;
    }
	
	public void helper(int[] num, int start, List<Integer> currlist, List<List<Integer>> reslist) {
        for (int i = start; i < num.length; i ++) {
            if (i > start && num[i] == num[i - 1])
                continue;
            currlist.add(num[i]);
            reslist.add(new ArrayList<>(currlist));
            helper(num, i + 1, currlist, reslist);
            currlist.remove(currlist.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
