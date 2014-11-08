/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
 * @author BigTiannn {11-07-2014}
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
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
		
		return retList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
