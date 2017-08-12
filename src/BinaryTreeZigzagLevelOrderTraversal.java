/**
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 * @author BigTiannn {11-07-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> solution(TreeNode root) {
    List<List<Integer>> retList = new ArrayList<>();
    
    if (root == null) return retList;
        
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
	
	// two stacks
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    
    if (root == null)   return res;
    
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    s1.push(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      while (!s1.isEmpty()) {
        TreeNode node = s1.pop();
        list.add(node.val);
        if (node.left != null)  s2.push(node.left);
        if (node.right != null) s2.push(node.right);
      }
      res.add(list);
      list = new ArrayList<Integer>();
      while (!s2.isEmpty()) {
        TreeNode node = s2.pop();
        list.add(node.val);
        if (node.right != null) s1.push(node.right);
        if (node.left != null)  s1.push(node.left);
      }
      if (!list.isEmpty())  res.add(list);
    }
    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
