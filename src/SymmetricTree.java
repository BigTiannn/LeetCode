/**
 * https://oj.leetcode.com/problems/symmetric-tree/
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * 
 *      1
 *     / \
 * 	  2   2
 *   / \ / \
 *  3  4 4  3
 *  
 * @author BigTiannn {10-22-2014}
 * 
 */

import java.util.Stack;

public class SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/************************* Iterative Solution *************************/
	public boolean isSymmetric_iterative(TreeNode root) {
		if (root == null)
            return true;
            
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            
            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            
            stack.push(p.left);
            stack.push(q.right);
            
            stack.push(p.right);
            stack.push(q.left);
        }
        
        return true;
    }
	
	/************************* Recursive Solution *************************/
	public boolean isSymmetric_recursive(TreeNode root) {
		if (root == null)
			return true;
		
        return isTwoSymmetricTrees(root.left, root.right);
    }
	
	public boolean isTwoSymmetricTrees(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		
		if (tree1 == null || tree2 == null)
			return false;
		
		return (tree1.val == tree2.val) &&
				isTwoSymmetricTrees(tree1.left, tree2.right) &&
				isTwoSymmetricTrees(tree1.right, tree2.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
