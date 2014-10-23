/**
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * @author	BigTiannn {10-22-2014}
 * 
 */

public class ReverseNodesInKGroup {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1)
			return head;
		
		ListNode headptr = head, tailptr = head, nexthead = head;
		ListNode lastTail = null, newhead = null, ret = null, newtail = null;
		while (tailptr != null && nexthead != null) {
			headptr = nexthead;
			tailptr = nexthead;
			// traverse to the end of k-group
			for(int i = 0; i < k - 1 && tailptr != null; i ++) {
				tailptr = tailptr.next;
			}
			if (tailptr == null) {
				if (ret == null)
					ret = head;
				return ret;
			}
			if (ret == null)
				ret = tailptr;
			
			nexthead = tailptr.next;
			newtail = headptr;
			newhead = tailptr;
			
			// reverse the k-group
			ListNode tmp;
			while(headptr != tailptr) {
				tmp = headptr;
				headptr = headptr.next;
				tmp.next = tailptr.next;
				tailptr.next = tmp;
			}
			
			if (lastTail != null)
				lastTail.next = newhead;
			lastTail = newtail;
		}
		
        return ret;
    }
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
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
		
		printList(reverseKGroup(node1, 2));
		printList(reverseKGroup(node1, 3));
		
	}

}
