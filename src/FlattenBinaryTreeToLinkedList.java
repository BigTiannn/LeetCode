import java.util.HashSet;
import java.util.Stack;

/***
 * http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Given a binary tree, flatten it to a linked list in-place.
 * In the flattened tree, each node's right child points to 
 * the next node of a pre-order traversal.
 * 
 * @author BigTiannn
 */

public class FlattenBinaryTreeToLinkedList {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	// pre-order traversal
	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		
		Stack<TreeNode> toVisit = new Stack<>();
		toVisit.add(root);
		TreeNode preNode = null;
		while(!toVisit.isEmpty()) {
			TreeNode curr = toVisit.pop();
			if (curr.right != null) {
				toVisit.add(curr.right);
			}
			if (curr.left != null) {
				toVisit.add(curr.left);
			}
			if (preNode != null) {
				preNode.left = null;
				preNode.right = curr;
			}
			preNode = curr;
		}
		
		return;
    }
	
	public void flatten_iterative(TreeNode root) {
        if (root == null)   return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
                
            node.left = null;
            if (!stack.isEmpty()) {
                node.right = stack.peek();
            }
        }
        return ;
    }
	
	// recursive
	public static void flatten2(TreeNode root) {
		if (root == null)
			return;
		visit(root);
	}
	
	public static TreeNode visit(TreeNode node) {
		if (node.left == null && node.right == null)
			return node;
		
		TreeNode left = node.left;
		TreeNode right = node.right;
		node.left = null;
		if (left != null) {
			node.right = left;
			node = visit(left);
		}
		if (right != null) {
			node.right = right;
			node = visit(right);
		}
		return node;
	}
	

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
//		node1.right = node5;
//		node2.left = node3;
		node2.right = node3;
//		node5.right = node6;
		
		flatten2(node1);
		TreeNode curr = node1;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.right;
		}
	}

}
