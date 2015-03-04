/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example, Given n = 3, your program should return all 5 unique BST's shown below.
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 * @author BigTiannn {11-24-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x; 
			left = null; 
			right = null; 
		}
	}
	
	public List<TreeNode> generateTrees(int n) {
		return buildBST(1, n);
    }
	
	public List<TreeNode> buildBST(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        
        if (start > end) {
            res.add(null);	// pay attention here!
            return res;
        }
        
        for (int i = start; i <= end; i ++) {
            List<TreeNode> leftList = buildBST(start, i - 1);
            List<TreeNode> rightList = buildBST(i + 1, end);
            
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TreeNode> res = new ArrayList<>();
		System.out.println(res.size());
		res.add(null);
		System.out.println(res.size());
	}

}
