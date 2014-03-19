import java.util.HashMap;
import java.util.Stack;

/***
 * http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * @author BigTiannn
 */
public class BinaryTreeMaximumPathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	// Post-order traversal
	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		
        HashMap<TreeNode, Integer> oneWayPathMap = new HashMap<>();
        Stack<TreeNode> toVisit = new Stack<>();
        int maxPath = root.val;
        
        toVisit.add(root);
        while(!toVisit.isEmpty()) {
        	TreeNode curr = toVisit.peek();
        	if (curr.left != null && !oneWayPathMap.containsKey(curr.left)) {
        		toVisit.add(curr.left);
        	} else if (curr.right != null && !oneWayPathMap.containsKey(curr.right)) {
        		toVisit.add(curr.right);
        	} else {
        		toVisit.pop();
        		int leftSubPath = (curr.left == null) ? 0 : oneWayPathMap.get(curr.left);
        		int rightSubPath = (curr.right == null) ? 0 : oneWayPathMap.get(curr.right);
        		int oneWayPath = maxThree(leftSubPath, rightSubPath, 0) + curr.val;
        		oneWayPathMap.put(curr, oneWayPath);
        		int roundWayPath = leftSubPath + rightSubPath + curr.val;
        		int path = Math.max(roundWayPath, oneWayPath);
        		if (path > maxPath)
        			maxPath = path;
        	}
        }
        
        return maxPath;
    }
	
	public static int maxThree(int val1, int val2, int val3) {
		int tmp1 = val1 > val2 ? val1 : val2;
		return tmp1 > val3 ? tmp1 : val3;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(-2);
		TreeNode node2 = new TreeNode(1);
//		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = null;
		node2.left = null;
		node2.right = null;
//		node3.left = null;
//		node3.right = null;
		
		System.out.println(maxPathSum(node1));
	}

}
