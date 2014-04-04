import java.util.LinkedList;
import java.util.Queue;

/***
 * http://oj.leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 * 
 * @author BigTiannn
 */

public class BalancedBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	// recursive
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
    }
	
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;		
	}
	
	//recursive 2
	public int checkHeight(TreeNode root) {
		if (root == null)
			return 0;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return -1;
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1;
		
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		
		return Math.max(leftHeight, rightHeight) + 1;
 	}
	
	public boolean isBalanced2(TreeNode root) {
		if (checkHeight(root) == -1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node2.right = node3;
		
		isBalanced2(node1);
	}

}
