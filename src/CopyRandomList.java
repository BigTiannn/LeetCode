/**
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * @author BigTiannn
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CopyRandomList {
	
	//A linked list is given such that each node contains an additional 
	//random pointer which could point to any node in the list or null.
	//Return a deep copy of the list.
	
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		
		RandomListNode(int x) { 
			this.label = x;
		}
	};
	
	public RandomListNode solution(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode dummy = new RandomListNode(-1);
    RandomListNode p = head, prev = dummy;
    while (p != null) {
      RandomListNode node = new RandomListNode(p.label);
      prev.next = node;
      map.put(p, node);
      prev = prev.next;
      p = p.next;
    }
        
    p = head;
    RandomListNode q = dummy.next;
    while (p != null) {
      if (p.random != null) {
          q.random = map.get(p.random);
      }
      p = p.next;
      q = q.next;
    }
    
    return dummy.next;
  }
	
	public RandomListNode solution2(RandomListNode head) {
    if (head == null)   return null;
    // copy each node and append the newly created node to the original one
    RandomListNode p = head;
    while (p != null) {
      RandomListNode node = new RandomListNode(p.label);
      node.next = p.next;
      p.next = node;
      p = node.next;
    }
        
    // set the value of random field
    p = head;
    while (p != null) {
      if (p.random != null) p.next.random = p.random.next;
      p = p.next.next;
    }
        
    // return the newly created list
    p = head;
    RandomListNode dummy = new RandomListNode(-1);
    RandomListNode q = dummy;
    while (p != null) {
      q.next = p.next;
      q = q.next;
      p.next = q.next;
      p = p.next;
   }
    
    return dummy.next;
  }

	public RandomListNode solution3(RandomListNode head) {
	  // the map is "original node" - "new node" pair
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    for (RandomListNode node = head; node != null; node = node.next) {
      map.put(node, new RandomListNode(node.label));
    }
    for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
      RandomListNode newNode = (RandomListNode)entry.getValue();
      RandomListNode oriNode = (RandomListNode)entry.getKey();
      newNode.next = map.get(oriNode.next);
      newNode.random = map.get(oriNode.random);
    }
    return map.get(head);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
