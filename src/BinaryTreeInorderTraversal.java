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
	        
	  if (root == null)  return trace;
	            
	  TreeNode curr = root;
	  while(!toVisit.isEmpty() || curr != null) {
	    if (curr != null){
	    	toVisit.push(curr);
	    	curr = curr.left;
	    } else {
	    	curr = toVisit.pop();
	    	trace.add(curr.val);
	    	curr = curr.right;
	    }
	  }  
	  return trace;
  }
	
	/**
	 * Morris Traversal
	 * time complexity: O(n) (every edge is visited at most twice)
	 * space complexity: O(1)
	 * @param root
	 * @return
	 */
	public static List<Integer> solution2(TreeNode root) {
	  List<Integer> res = new ArrayList<>();
	  TreeNode curr = root, prev = null;
	  
	  while (curr != null) {
      if (curr.left == null) {
        res.add(curr.val);
        curr = curr.right;
      } else {
        prev = curr.left;
        while (prev.right != null && prev.right != curr) { // find the rightmost child of the left sub-tree
          prev = prev.right;
        }
        if (prev.right == null) {  // assign curr to the rightmost non-empty child
          prev.right = curr;
          curr = curr.left;
        } else {                 // the left sub-tree is all visited, recover the right child to its original
          prev.right = null;
          res.add(curr.val);
          curr = curr.right;
        }
      }
    }
	  
	  return res;
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
