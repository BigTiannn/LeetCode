/**
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * Given m, n satisfy the following condition: 1 <= m <= n<= length of list.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * @author BigTiannn {10-28-2014}
 *
 */

public class ReverseLinkedListII {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode prevM = fakeHead;
        for (int i = 0; i < m - 1; i ++)
        	prevM = prevM.next;
        
        ListNode mPtr = prevM.next, curr = mPtr.next;
        for (int i = m; i < n; i ++) {
        	mPtr.next = curr.next;
        	curr.next = prevM.next;
        	prevM.next = curr;
        	curr = mPtr.next;
        }
        
        return fakeHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
