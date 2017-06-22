import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * You need to find the largest value in each row of a binary tree.
 * Example:
 * Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

 * Output: [1, 3, 9]
 * 
 * @author BigTiannn
 */

public class FindLargestValueInEachTreeRow {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        if (root == null)   return ret;
            
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int rowSize = queue.size();
        
        while (rowSize > 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < rowSize; i ++) {
                TreeNode node = queue.poll();
                if (node.val > max) max = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            rowSize = queue.size();
            ret.add(max);
        }
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
