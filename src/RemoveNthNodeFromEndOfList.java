/**
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author BigTiannn {10-24-2014}
 *
 */

public class RemoveNthNodeFromEndOfList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode endPtr = head, nthPtr = head, nthPrev = head;
        
        // move endPtr to be n nodes ahead of nthPtr
        int i = 0;
        for (; endPtr != null && i < n; i ++)
        	endPtr = endPtr.next;
        
        // check the validation of n
        if (i != n) {
        	System.out.println("Invalid argument n: n should be less or equal to the length of the list.");
        	return head;
        }
        
        // move nthPtr to the n_th node from the end of list
        for (; endPtr != null; endPtr = endPtr.next, nthPtr = nthPtr.next)
        	nthPrev = nthPtr;
        
        if (nthPtr == head)
        	return head.next;
        
        nthPrev.next = nthPtr.next;
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		removeNthFromEnd(node1, 7);
	}

}
