/**
 * https://oj.leetcode.com/problems/insertion-sort-list/
 * Sort a linked list using insertion sort.
 * 
 * @author BigTiannn {10-23-2014}
 * 
 */

public class InsertionSortList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		
        ListNode sortedHead = head, sortedTail = head, unsortedHead = head.next;
        while (unsortedHead != null) {
        	ListNode curr = unsortedHead;
        	unsortedHead = unsortedHead.next;
        	
        	// traverse the sorted list to find the position
        	ListNode tmpCurr = sortedHead, tmpPrev = sortedHead;
        	while (tmpCurr != sortedTail) {
        		if (tmpCurr.val <= curr.val) {
        			tmpPrev = tmpCurr;
        			tmpCurr = tmpCurr.next;
        		} else
        			break;
        	}
        	
        	// corner case 1: handle with sortedTail node
        	if (tmpCurr == sortedTail) {
        		// insert after sortedTail, update sortedTail as curr
        		if (tmpCurr.val <= curr.val) {
        			tmpCurr.next = curr;
        			sortedTail = curr;
        			sortedTail.next = unsortedHead;
        			continue;
        		}
        	}
        	// corner case 2: update sortedHead as curr
        	if (tmpCurr == sortedHead) {
        		curr.next = sortedHead;
        		sortedHead = curr;
        		sortedTail.next = unsortedHead;
        	}
        	// ordinary cases: insert between tmpPrev and tmpCurr
        	else {
        		tmpPrev.next = curr;
        		curr.next = tmpCurr;
        		sortedTail.next = unsortedHead;
        	}
        }
        
        return sortedHead;
    }
	
	public static void print(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val);
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static ListNode insertionSortList_2(ListNode head) {
		if (head == null)   return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        
        while (curr != null) {
            ListNode prev = dummy, tmp = curr.next;
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            curr = tmp;
        }
        
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		print(insertionSortList_2(node1));
		
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(1);
		node3.next = node4;
		node4.next = node5;
		print(insertionSortList(node3));
	}

}
