/**
 * https://oj.leetcode.com/problems/partition-list/
 * Given a linked list and a value x, partition it such that all 
 * nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes 
 * in each of the two partitions.
 * 
 * @author BigTiannn {10-28-2014}
 *
 */

public class PartitionList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode partition(ListNode head, int x) {
		ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prevSmall = fakeHead, prevBig = fakeHead, small = head, big = head;
        while (small != null && big != null) {
            // "big" points to the first element which is no smaller than x
            while (big != null && big.val < x) {
                prevBig = prevBig.next;
                big = big.next;
            }
            if (big == null)
                break;
            
            // "small" points to the first element which is smaller than x comes after "big"
            prevSmall = big;
            small = big.next;
            while(small != null && small.val >= x) {
                prevSmall = prevSmall.next;
                small = small.next;
            }
            if (small == null)
                break;
              
            // insert "small" before "big"
            prevSmall.next = small.next;
            prevBig.next = small;
            small.next = big;
            prevBig = small;
            
            small = big.next;
        }
        
        return fakeHead.next;
    }	
	
	public static ListNode partition_2(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode small = smallHead, big = bigHead;
        
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (curr.val < x) {
                small.next = curr;
                small = curr;
            } else {
                big.next = curr;
                big = curr;
            }
        }
        
        small.next = bigHead.next;
        big.next = null;    // very important!
        
        return smallHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		
		partition_2(node1, 3);
	}

}
