/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * @author BigTiannn
 *
 */

public class Trie {
  class TrieNode {
      char val;
      boolean isWord;
      TrieNode[] children = new TrieNode[26];
      TrieNode () {}
      TrieNode (char ch) {
        this.val = ch;
      }
  }
  private TrieNode root;
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
    root.val = ' ';
  }
  
  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i ++) {
      int charIndex = word.charAt(i) - 'a';
      if (node.children[charIndex] == null) {
        node.children[charIndex] = new TrieNode(word.charAt(i));
      }
      node = node.children[charIndex];
    }
    node.isWord = true;
    return;
  }
  
  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i ++) {
      int charIndex = word.charAt(i) - 'a';
      if (node.children[charIndex] == null) {
        return false;
      }
      node = node.children[charIndex];
    }
    return node.isWord;
  }
  
  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i ++) {
      int charIndex = prefix.charAt(i) - 'a';
      if (node.children[charIndex] == null) {
        return false;
      }
      node = node.children[charIndex];
    }
    return true;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Trie obj = new Trie();
    String word = "abc";
    obj.insert(word);
    boolean param_2 = obj.search(word);
    boolean param_3 = obj.startsWith("a");
  }

}
