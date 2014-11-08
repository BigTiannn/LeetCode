/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * @author BigTiannn {11-07-2014}
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> retList = new ArrayList<>();
		
		if (root == null)
			return retList;
		
		LinkedList<TreeNode> toVisit = new LinkedList<>();
		toVisit.add(root);
		while (!toVisit.isEmpty()) {
			int n = toVisit.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i ++) {
				TreeNode curr = toVisit.poll();
				list.add(curr.val);
				if (curr.left != null)
					toVisit.add(curr.left);
				if (curr.right != null)
					toVisit.add(curr.right);
			}
			
			retList.add(list);
		}
		
		// reverse the result list
		List<List<Integer>> result = new ArrayList<>();
		for (int i = retList.size() - 1; i >= 0; i --) {
			result.add(retList.get(i));
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
