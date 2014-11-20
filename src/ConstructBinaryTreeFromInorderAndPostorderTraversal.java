/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * @author BigTiannn {11-19-2014}
 *
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length != postorder.length || inorder.length == 0)
            return null;
        
        int n = inorder.length - 1;
        return helper(inorder, postorder, 0, n, 0, n);
    }

	public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd)
            return null;
            
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int rootIndex = inStart;
        while (inStart <= inEnd) {
            if (inorder[rootIndex] == postorder[postEnd])
                break;
            rootIndex ++;
        }
        
        // inorder:
        // [inStart, rootIndex - 1] is the left subtree, 
        // [rootIndex + 1, inEnd] is the right subtree
        // length(left subtree) = rootIndex - 1 - (inStart - 1) = rootIndex - inStart
        // length(right subtree) = inEnd - (inStart - 1) - (rootIndex - inStart) = inEnd - rootIndex + 1
        // postorder:
        // [postStart, postStart + rootIndex - inStart - 1] is the left subtree, 
        // [postStart + rootIndex - inStart, postEnd - 1] is the right subtree
        
        root.left = helper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + rootIndex - 1 - inStart);
        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);
        
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
