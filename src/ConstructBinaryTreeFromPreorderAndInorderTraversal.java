import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * @author BigTiannn {11-19-2014}
 *
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(inorder.length != preorder.length || inorder.length == 0)
        return null;
    
    int n = inorder.length - 1;
    return helper(preorder, inorder, 0, n, 0, n);
  }
	
	public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
    if (preStart > preEnd)  return null;
            
    TreeNode root = new TreeNode(preorder[preStart]);
    
    int rootIndex = inStart;
    while (inStart <= inEnd) {
      if (inorder[rootIndex] == preorder[preStart])
        break;
      rootIndex ++;
    }
        
    // inorder:
    // [inStart, rootIndex - 1] is the left subtree, 
    // [rootIndex + 1, inEnd] is the right subtree
    // length(left subtree) = rootIndex - 1 - (inStart - 1) = rootIndex - inStart
    // length(right subtree) = inEnd - (inStart - 1) - (rootIndex - inStart) = inEnd - rootIndex + 1
    // preorder:
    // [preStart + 1, preStart + rootIndex - inStart] is the left subtree, 
    // [preStart + rootIndex - inStart + 1, preEnd] is the right subtree
    
    root.left = helper(preorder, inorder, preStart + 1, preStart + rootIndex - inStart, inStart, rootIndex - 1);
    root.right = helper(preorder, inorder, preStart + rootIndex - inStart + 1, preEnd, rootIndex + 1, inEnd);
    
    return root;
  }
	
	public TreeNode solution2(int[] preorder, int[] inorder) {
    int n = preorder.length;
    
    if (n == 0) return null;
    
    TreeNode root = new TreeNode(preorder[0]);
    for (int i = 0; i < n; i ++) {
      if (inorder[i] == preorder[0]) {
        int leftCount = i;
        int rightCount = n - i - 1;
        root.left = buildTree(
          Arrays.copyOfRange(preorder, 1, i + 1),
          Arrays.copyOfRange(inorder, 0, i)
        );
        root.right = buildTree(
          Arrays.copyOfRange(preorder, i + 1, n),
          Arrays.copyOfRange(inorder, i + 1, n)
        );
        break;
      }
    }
    return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
