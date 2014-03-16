import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/***
 * http://oj.leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * 
 * @author BigTiannn
 */
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

	public static void main(String[] args) {
		int[] num = {1, 1, 2};
		ArrayList<ArrayList<Integer>> res = permuteUnique(num);
		for(ArrayList<Integer> list : res)
			System.out.println(Arrays.toString(list.toArray()));
	}

}
