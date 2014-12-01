/**
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * @author BigTiannn {11-27-2014}
 *
 */
public class IntersectionOfTwoLinkedLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        
        for (ListNode tmp = headA; tmp != null; tmp = tmp.next)
            lenA ++;
            
        for (ListNode tmp = headB; tmp != null; tmp = tmp.next)
            lenB ++;
            
        if (lenA >= lenB) {
            return getIntersection(headA, headB, lenA - lenB);
        } else {
            return getIntersection(headB, headA, lenB - lenA);
        }
    }
    
    // Assume that list A is longer than list B
    public ListNode getIntersection(ListNode headA, ListNode headB, int distance) {
        int i = 0;
        while (i < distance) {
            headA = headA.next;
            i ++;
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
