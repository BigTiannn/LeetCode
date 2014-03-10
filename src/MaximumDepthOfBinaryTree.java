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
		if (root == null)
			return 0;
		
		List<Queue<TreeNode>> waitinglist = new ArrayList<>();
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		waitinglist.add(q1);
		waitinglist.add(q2);
		
		q1.add(root);
		int depth = 0;
		while(!waitinglist.get(depth % 2).isEmpty()) {
			TreeNode curr = waitinglist.get(depth % 2).poll();
			if (curr.left != null)
				waitinglist.get((depth + 1) % 2).add(curr.left);
			if (curr.right != null)
				waitinglist.get((depth + 1) % 2).add(curr.right);
			if (waitinglist.get(depth % 2).isEmpty())
				depth ++;
		}
		
		return depth;
	}
	
	public static void main(String[] args) {
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node1 = new TreeNode(1);
	}

}
