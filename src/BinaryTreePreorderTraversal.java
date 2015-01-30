/**
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * @author BigTiannn
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static ArrayList<Integer> Solution (TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		traverse(root, list);
		return list;
	}
	
	private static void traverse (TreeNode node, ArrayList<Integer> list) {
		if (node == null)
			return;
		
		list.add(node.val);
		traverse(node.left, list);
		traverse(node.right, list);
	}
	
	//no recursive implementation
	public static List<Integer> Solution2 (TreeNode root) {
		List<Integer> res = new ArrayList<>();
        if (root == null)   return res;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		root.left = node1;
		root.right = node2;
		node1.left = null;
		node1.right = null;
		node2.left = null;
		node2.right = null;
		System.out.println(Arrays.toString(Solution2(root).toArray()));
	}

}
