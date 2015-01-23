/**
 * https://oj.leetcode.com/problems/rotate-list/
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * Note that n can be larger than the size of the list
 * 
 * @author BigTiannn {10-28-2014}
 *
 */

public class RotateList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return null;
			
		if (n == 0)
		    return head;
			
        ListNode tailPtr = head, nthPtr = head, newHead = head;
        
        // move tailPtr n nodes ahead of nthPtr
        int i = 0;
        while(i < n) {
        	if (tailPtr == null)
        		tailPtr = head.next;
        	else
        		tailPtr = tailPtr.next;
        	i ++;
        }
        
        // n is the length of the list
        if (tailPtr == null) {
        	return head;
        }
        
        // move tailPtr to be the last node, and nthPtr to be (n-1) node
        while (tailPtr.next != null) {
        	tailPtr = tailPtr.next;
        	nthPtr = nthPtr.next;
        }
        
        newHead = nthPtr.next;
        tailPtr.next = head;
        nthPtr.next = null;
        
        return newHead;
    }
	
	// form a circle
	public ListNode rotateRight_2(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
            
        // n can be larger than the length of list
        // 1. get the length of list
        ListNode ptr = head;
        int len = 1;
        while (ptr.next != null) {
            ptr = ptr.next;
            len ++;
        }
        n = len - n % len;
        
        // 2. link the tail to the head and form a circle
        ptr.next = head;
        
        // 3. cut the circle at (len - n)th node
        for (int i = 0; i < n; i ++) {
            ptr = ptr.next;
        }
        head = ptr.next;
        ptr.next = null;
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// some extreme cases
		// {1}, 99
		// {1, 2}, 3
		// {}, 1
	}

}
