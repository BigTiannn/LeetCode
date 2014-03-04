import java.util.ArrayList;
import java.util.List;


public class SumRootLeafNumber {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) { 
			val = x;
		}
	}
	
	// BFS
	public static int Solution (TreeNode root) {
		if (root == null)
			return 0;
		
		int sum = 0;
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		int ptr = 0;
		
		while (ptr < list.size()) {
			int num = list.get(ptr).val;
			TreeNode left = list.get(ptr).left;
			TreeNode right = list.get(ptr).right;
			if (left != null) {
				left.val += num * 10;
				list.add(left);
			}
			if (right != null) {
				right.val += num * 10;
				list.add(right);
			}
			if (left == null && right == null) 
				sum += num;
			
			ptr ++;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
//		TreeNode n3 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = null;
		
		n2.left = null;
		n2.right = null;
		
//		n3.left = null;
//		n3.right = null;
		
		System.out.println(Solution(n1));
	}

}
