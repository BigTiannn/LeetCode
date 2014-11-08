/**
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * @author BigTiannn {11-07-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        
        if (root == null)
        	return retList;
        
        boolean left_to_right = true;
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
        	List<Integer> list = new ArrayList<>();
        	for (TreeNode node : curr)
        		list.add(node.val);
        		
        	List<TreeNode> next = new ArrayList<>();
        	for (int i = curr.size() - 1; i >= 0; i --) {
        		if (left_to_right) {
        			if (curr.get(i).right != null)
        				next.add(curr.get(i).right);
        			if (curr.get(i).left != null)
        				next.add(curr.get(i).left);
        		} else {
        			if (curr.get(i).left != null)
        				next.add(curr.get(i).left);
        			if (curr.get(i).right != null)
        				next.add(curr.get(i).right);
        		}
        	}
        	
        	left_to_right = !left_to_right;
        	retList.add(list);
        	curr = new ArrayList<>(next);
        }
        
        return retList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
