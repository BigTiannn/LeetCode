/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * @author BigTiannn {11-24-2014}
 *
 */

public class PopulatingNextRightPointersInEachNodeII {
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
		while (root != null) {
            TreeLinkNode prev = null;   // the prev node of current level
            TreeLinkNode next = null;   // the start of next level
            for (; root != null; root = root.next) {
                if (next == null)
                    next = (root.left != null) ? root.left : root.right;
                
                if (root.left != null) {
                    if (prev != null) {
                        prev.next = root.left;
                    }
                    prev = root.left;
                }
                
                if (root.right != null) {
                    if (prev != null) {
                        prev.next = root.right;
                    }
                    prev = root.right;
                }
            }
            root = next;
        }
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
