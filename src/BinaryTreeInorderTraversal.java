import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> trace = new ArrayList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        
        if (root == null)
            return trace;
        
        toVisit.push(root);
        while(!toVisit.isEmpty()) {
            TreeNode node = toVisit.pop();
            
            if (node.left == null || visited.contains(node.left)) {
                trace.add(node.val);
                visited.add(node);
                System.out.println(node.val);
            }
            
            if (node.right != null)
                toVisit.push(node.right);
            if (!visited.contains(node))
                toVisit.push(node);
            if (node.left != null && !visited.contains(node.left))
                toVisit.push(node.left);   
        }
        
        return trace;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
//		node2.left = node3;
//		node2.right = node4;
		
		System.out.println(Arrays.toString(inorderTraversal(node1).toArray()));
	}

}
