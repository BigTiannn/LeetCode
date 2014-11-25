/**
 * https://oj.leetcode.com/problems/lru-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key 
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently 
 * used item before inserting a new item.
 * 
 * @author BigTiannn {11-24-2014}
 *
 */

import java.util.HashMap;

public class LRUCache {
	
	private int capacity;
    private int currLen;
    private HashMap<Integer, DoubleLinkedListNode> map;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    
    private class DoubleLinkedListNode {
        int key;
        int value;
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;
        
        private DoubleLinkedListNode(int key, int val) {
            this.key = key;
            this.value = val;
            this.pre = null;
            this.next = null;
        }
    }
    
 // Assume that capacity must be greater than 1
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currLen = 0;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // move this node to the head of the double linked list
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            
            return node.value;
        } else
            return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            
            if (this.currLen < this.capacity) {
                this.currLen ++;
            } else {
                // since capacity >= 1, this.end mustn't be null when capacity hits the limit
                map.remove(this.end.key);
                removeNode(this.end);
            }
        }
        return;
    }
    
    private void addToHead(DoubleLinkedListNode node) {
        node.next = this.head;
        node.pre = null;
        if (this.head != null)
            head.pre = node;
        if (this.end == null)
            this.end = node;
            
        this.head = node;
    }
    
    private void removeNode(DoubleLinkedListNode node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            // node is head
            this.head = node.next;
        }
        
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            // node is end
            this.end = node.pre;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lru = new LRUCache(1);
		lru.set(2, 1);
		System.out.println(lru.get(2));
		lru.set(3, 2);
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
	}

}
