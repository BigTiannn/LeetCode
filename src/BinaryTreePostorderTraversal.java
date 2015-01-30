/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * @author BigTiannn
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	
	public static ArrayList<Integer> Solution (TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		
		if (root != null) {
			HashSet<TreeNode> visited = new HashSet<>();
			Stack<TreeNode> toVisit = new Stack<>();
			toVisit.push(root);
			while (!toVisit.isEmpty()) {
				TreeNode curr = toVisit.peek();
				if (curr.left != null  && !visited.contains(curr.left)) {
					toVisit.push(curr.left);
				} else {
					if (curr.right != null && !visited.contains(curr.right)) { 
						toVisit.push(curr.right);
					} else {
						list.add(curr.val);
						visited.add(curr);
						toVisit.pop();
					}
				}
			}
		}
		
		return list;
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        
        if (root == null)   return res;
        
        toVisit.push(root);
        while (!toVisit.isEmpty()) {
            TreeNode node = toVisit.peek();
            if (node.left != null && !visited.contains(node.left)) {
                toVisit.push(node.left);
            } else if (node.right != null && !visited.contains(node.right)) {
                toVisit.push(node.right);
            } else {
                res.add(node.val);
                toVisit.pop();
                visited.add(node);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = null;
		node4.left = null;
		node4.right = null;
		node5.left = node7;
		node5.right = null;
		node6.left = null;
		node6.right = node8;
		
		System.out.println(Arrays.toString(Solution(root).toArray()));
	}

}
