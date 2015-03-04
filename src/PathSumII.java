
/***
 * http://oj.leetcode.com/problems/path-sum-ii/
 * Given a binary tree and a sum, find all root-to-leaf 
 * paths where each path's sum equals the given sum.
 * 
 * @author BigTiannn
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class PathSumII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) 
			return result;
		
		Stack<TreeNode> toVisit = new Stack<>();
		HashSet<TreeNode> visited = new HashSet<>();
		toVisit.add(root);
		
		ArrayList<Integer> path = new ArrayList<>();
		path.add(root.val);
		int currSum = root.val;
		while(!toVisit.isEmpty()) {
			TreeNode curr = toVisit.peek();
			if (curr.left == null && curr.right == null && currSum == sum) {
				ArrayList<Integer> list = new ArrayList<>(path);
				result.add(list);
			}
			
			if (curr.left != null && !visited.contains(curr.left)) {
				currSum += curr.left.val;
				path.add(curr.left.val);
				toVisit.push(curr.left);
			} else if (curr.right != null && !visited.contains(curr.right)) {
				currSum += curr.right.val;
				path.add(curr.right.val);
				toVisit.push(curr.right);
			} else {
				visited.add(curr);
				currSum -= curr.val;
				toVisit.pop();
				path.remove(path.size() - 1);
			}
		}
		
		return result;
	}
	
	// recursion
	public List<List<Integer>> pathSum_r(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        getAllPaths(root, sum, res, list);
        return res;
    }
    
    private void getAllPaths(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null)   return;
        
        list.add(root.val);
        
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(list));
            // pay attention here: cannot write "return"
            // we need to pop the last element before returning
        }
        
        getAllPaths(root.left, sum - root.val, res, list);
        getAllPaths(root.right, sum - root.val, res, list);
        list.remove(list.size() - 1);
        
        return;
    }
		
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		
		TreeNode node4 = new TreeNode(11);
		node2.left = node4;
		node2.right = null;
		
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(2);
		node4.left = node5;
		node4.right = node6;
		node5.left = null;
		node5.right = null;
		node6.left = null;
		node6.right = null;
		
		TreeNode node7 = new TreeNode(13);
		node7.left = null;
		node7.right = null;
		TreeNode node8 = new TreeNode(4);
		node3.left = node7;
		node3.right = node8;
		
		TreeNode node9 = new TreeNode(1);
		TreeNode node10 = new TreeNode(5);
		node8.left = node10;
		node8.right = node9;
		node9.left = null;
		node9.right = null;
		node10.left = null;
		node10.right = null;
		
		ArrayList<ArrayList<Integer>> res = pathSum(node1, 22);
		for (ArrayList<Integer> list : res)
			System.out.println(Arrays.toString(list.toArray()));
	}

}
