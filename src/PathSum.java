import java.util.HashSet;
import java.util.Stack;

/***
 * http://oj.leetcode.com/problems/path-sum/
 * Given a binary tree and a sum, determine if the tree 
 * has a root-to-leaf path such that adding up all the 
 * values along the path equals the given sum.
 * 
 * @author BigTiannn
 */
public class PathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	//recursive
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (sum == root.val)
				return true;
			else
				return false;
		}
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	// non-recursive, DFS
	public static boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) 
			return false;
		
		Stack<TreeNode> toVisit = new Stack<>();
		HashSet<TreeNode> visited = new HashSet<>();
		toVisit.add(root);
		
		int currSum = root.val;
		while(!toVisit.isEmpty()) {
			TreeNode curr = toVisit.peek();
			if (curr.left == null && curr.right == null && currSum == sum)
				return true;
			
			if (curr.left != null && !visited.contains(curr.left)) {
				currSum += curr.left.val;
				toVisit.push(curr.left);
			} else if (curr.right != null && !visited.contains(curr.right)) {
				currSum += curr.right.val;
				toVisit.push(curr.right);
			} else {
				visited.add(curr);
				currSum -= curr.val;
				toVisit.pop();
			}
		}
		
		return false;
    }

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		
		TreeNode node4 = new TreeNode(11);
		node2.left = node4;
		node2.right = null;
		
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(2);
		node4.left = node5;
		node4.right = node6;
		node5.left = null;
		node5.right = null;
		node6.left = null;
		node6.right = null;
		
		TreeNode node7 = new TreeNode(13);
		node7.left = null;
		node7.right = null;
		TreeNode node8 = new TreeNode(4);
		node3.left = node7;
		node3.right = node8;
		
		TreeNode node9 = new TreeNode(1);
		node8.left = null;
		node8.right = node9;
		node9.left = null;
		node9.right = null;
		
		System.out.println(hasPathSum2(node1, 22));
	}

}
