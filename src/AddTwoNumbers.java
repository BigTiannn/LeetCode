/**
 * https://oj.leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author BigTiannn {10-27-2014}
 *
 */

public class AddTwoNumbers {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode prev = head;
		int carry = 0;
        while (l1 != null && l2 != null) {
        	int sum = l1.val + l2.val + carry;
        	carry = sum /10;
        	ListNode curr = new ListNode(sum % 10);
        	prev.next = curr;
        	prev = curr;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        while (l1 != null) {
        	int sum = l1.val + carry;
        	carry = sum /10;
        	ListNode curr = new ListNode(sum % 10);
        	prev.next = curr;
        	prev = curr;
        	l1 = l1.next;
        }
        
        while (l2 != null) {
        	int sum = l2.val + carry;
        	carry = sum /10;
        	ListNode curr = new ListNode(sum % 10);
        	prev.next = curr;
        	prev = curr;
        	l2 = l2.next;
        }
        
        if (carry != 0) {
        	ListNode curr = new ListNode(carry);
        	prev.next = curr;
        }
        	
        return head.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
