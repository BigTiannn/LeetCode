import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 * @author BigTiannn
 */
public class MaximumDepthOfBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	// recursive
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; 
    }
	
	// non-recursive (BFS)
	public int maxDepth2(TreeNode root) {
		if (root == null)	return 0;
		
		Queue<TreeNode> toVisit = new LinkedList<>();
		Queue<TreeNode> newToVisit = null;
		toVisit.add(root);
		int maxDepth = 0;
		
		while(!toVisit.isEmpty()) {
		    if (newToVisit == null)
		        newToVisit = new LinkedList<>();
		        
			TreeNode curr = toVisit.poll();
			if (curr.left != null)
				newToVisit.add(curr.left);
			if (curr.right != null)
				newToVisit.add(curr.right);
			if (toVisit.isEmpty()) {
				maxDepth ++;
				toVisit = newToVisit;
				newToVisit = null;
			}
		}
		
		return maxDepth;
	}
	
	public static void main(String[] args) {
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node1 = new TreeNode(1);
	}

}
