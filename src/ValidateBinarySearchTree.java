/**
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * @author BigTiannn {11-16-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isValidBST(TreeNode root) {
        List<Integer> trace = inOrderTraversal(root);
        
        for (int i = 1; i < trace.size(); i ++) {
            if (trace.get(i) <= trace.get(i - 1))
                return false;
        }
        
        return true;
    }
    
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> trace = new ArrayList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        
        if (root == null)
            return trace;
            
        TreeNode curr = root;
        while(!toVisit.isEmpty() || curr != null) {
            if (curr != null){
                toVisit.push(curr);
                curr = curr.left;
            } else {
                curr = toVisit.pop();
                trace.add(curr.val);
                curr = curr.right;
            }
        }
        
        return trace;
    }
    
    /*
     * Solution 2: recursive with [min, max]
     */
    public boolean isValidBST_2(TreeNode root) {
        return checkBST(root, null, null);
    }
    
    public boolean checkBST(TreeNode root, Integer max, Integer min) {
        if (root == null)
            return true;
            
        if (max != null && root.val >= max ||
            min != null && root.val <= min)
            return false;
        
        return checkBST(root.left, root.val, min) && checkBST(root.right, max, root.val);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
