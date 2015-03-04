/**
 * Given a string containing tenary operator, like "a?b:c". Build a tree based on the string.
 * "a?b:c":
 *    a
 *   / \
 *   b  c
 *   
 * @author BigTiannn
 *
 */

public class TenaryOperatorToTree {
	
	public static class TreeNode {
		String val;
		TreeNode left;
		TreeNode right;
		TreeNode (String ch) {
			val = ch;
		}
	}
	
	public TreeNode convert(String expression) {
	    if (expression.length() == 1)   return new TreeNode(expression);
	    
	    TreeNode root = new TreeNode(expression.substring(0, 1));
	    
	    // divide the remaining string into two parts
	    // the 2nd letter should ?
	    int numOfQuesionMark = 0;
	    int index = 2;
	    for (; index < expression.length(); index ++) {
	        if (expression.charAt(index) == '?') {
	            numOfQuesionMark ++;
	        }
	        if (expression.charAt(index) == ':') {
	            numOfQuesionMark --;
	        }
	        if (numOfQuesionMark == -1)  break;
	    }
	    
	    root.left = convert(expression.substring(2, index));
	    root.right = convert(expression.substring(index + 1, expression.length()));
	    
	    return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("a?b:c");
	}

}
