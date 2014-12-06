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
	public static class TreeNode {
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
		// 1 3 4 6 7 8 10 13 14
		RecoverBinarySearchTree.TreeNode node1 = new RecoverBinarySearchTree.TreeNode(1);
		RecoverBinarySearchTree.TreeNode node3 = new RecoverBinarySearchTree.TreeNode(3);
		RecoverBinarySearchTree.TreeNode node4 = new RecoverBinarySearchTree.TreeNode(8);
		RecoverBinarySearchTree.TreeNode node6 = new RecoverBinarySearchTree.TreeNode(6);
		RecoverBinarySearchTree.TreeNode node7 = new RecoverBinarySearchTree.TreeNode(7);
		RecoverBinarySearchTree.TreeNode node8 = new RecoverBinarySearchTree.TreeNode(4);
		RecoverBinarySearchTree.TreeNode node10 = new RecoverBinarySearchTree.TreeNode(10);
		RecoverBinarySearchTree.TreeNode node13 = new RecoverBinarySearchTree.TreeNode(13);
		RecoverBinarySearchTree.TreeNode node14 = new RecoverBinarySearchTree.TreeNode(14);
		
		node8.left = node3;
		node8.right = node10;
		node3.left = node1;
		node3.right = node6;
		node6.left = node4;
		node6.right = node7;
		node10.right = node14;
		node14.left = node13;
		
		RecoverBinarySearchTree obj = new RecoverBinarySearchTree();
		obj.inorder(node8);
		System.out.println(obj.first.val);
		System.out.println(obj.second.val);
	}

}
