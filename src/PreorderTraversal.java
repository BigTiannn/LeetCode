import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class PreorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static ArrayList<Integer> Solution (TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		traverse(root, list);
		return list;
	}
	
	private static void traverse (TreeNode node, ArrayList<Integer> list) {
		if (node == null)
			return;
		
		list.add(node.val);
		traverse(node.left, list);
		traverse(node.right, list);
	}
	
	//TODO: no recursive implementation
	public static ArrayList<Integer> Solution2 (TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> toVisit = new Stack<>(); 
		if (root != null) {
			toVisit.add(root);
			while (!toVisit.isEmpty()) {
				TreeNode curr = toVisit.pop();
				list.add(curr.val);
				if (curr.right != null)
					toVisit.push(curr.right);
				curr = curr.left;
				while (curr != null) {
					list.add(curr.val);
					if (curr.right != null)
						toVisit.push(curr.right);
					curr = curr.left;
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		root.left = node1;
		root.right = node2;
		node1.left = null;
		node1.right = null;
		node2.left = null;
		node2.right = null;
		System.out.println(Arrays.toString(Solution2(root).toArray()));
	}

}
