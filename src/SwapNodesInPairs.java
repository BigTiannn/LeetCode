/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author BigTiannn {10-27-2014}
 *
 */

public class SwapNodesInPairs {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode newHead = head, ptr = head, prev = null;
		
        while (ptr != null && ptr.next != null) {
        	if (prev == null) {
        		newHead = head.next;
        		ListNode nextHead = ptr.next.next;
        		ptr.next.next = ptr;
        		ptr.next = nextHead;
        	} else {
	        	ListNode nextHead = ptr.next.next;
	        	prev.next = ptr.next;
	        	ptr.next.next = ptr;
	        	ptr.next = nextHead;
        	}
        	prev = ptr;
        	ptr = ptr.next;
        }
        
        return newHead;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
