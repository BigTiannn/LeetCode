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
	  ListNode prev = new ListNode(0), head = prev;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      ListNode node = new ListNode((sum + carry) % 10);
      carry = (sum + carry) / 10;
      prev.next = node;
      prev = node;
    }
    return head.next;	
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
