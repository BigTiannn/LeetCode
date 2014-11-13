/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author BigTiannn {11-12-2014}
 *
 */
public class PopulatingNextRightPointersInEachNode {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	// This recursive solution only works for complete binary trees
	public void connect(TreeLinkNode root) {
		if (root == null)
            return;
            
        if (root.left != null)
            root.left.next = root.right;
        if (root.right != null)
            root.right.next = (root.next == null) ? null : root.next.left;
        
        connect(root.left);
        connect(root.right);
        
        return;
    }
	
	// BFS or lever order traversal
	public void connect_solution2(TreeLinkNode root) {
		
        
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
