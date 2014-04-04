import java.util.LinkedList;
import java.util.Queue;

/***
 * http://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest 
 * path from the root node down to the nearest leaf node.
 * 
 * @author BigTiannn
 */

public class MinimumDepthOfBinaryTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	// BFS
	public static int minDepth(TreeNode root) {
        int minDepth = 1;
        
        if(root == null)
        	return 0;
        
        Queue<TreeNode> toVisit = new LinkedList<>();
        toVisit.add(root);
        Queue<TreeNode> newToVisit = null;
        while(!toVisit.isEmpty()) {
        	if (newToVisit == null)
        		newToVisit = new LinkedList<>();
        		
        	TreeNode curr = toVisit.poll();
        	if (curr.left == null && curr.right == null)
        		return minDepth;
        	
        	if (curr.left != null)
        		newToVisit.add(curr.left);
        	
        	if (curr.right != null)
        		newToVisit.add(curr.right);
        	
        	if (toVisit.isEmpty()) {
        		toVisit = newToVisit;
        		newToVisit = null;
        		minDepth += 1;
        	}
        }
        
        return minDepth;
    }

	public static void main(String[] args) {
		
	}

}
