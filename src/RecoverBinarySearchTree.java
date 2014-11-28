/**
 * https://oj.leetcode.com/problems/recover-binary-search-tree/
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. 
 * Could you devise a constant space solution?
 * 
 * @author BigTiannn {11-26-2014}
 *
 */

public class RecoverBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
        
    public void recoverTree(TreeNode root) {
        // inorder traverse the tree
        inorder(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
    
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        
        if (pre == null) {
            pre = root;
        } else {
            if (pre.val > root.val) {
                if (first == null)
                    first = pre;
                second = root;
            }
            pre = root;
        }
        
        inorder(root.right);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
