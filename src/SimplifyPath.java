/**
 * https://oj.leetcode.com/problems/simplify-path/
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * @author BigTiannn {10-28-2014}
 *
 */

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
	
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
        
        String[] pathArray = path.split("/");
        for (int i = 0; i < pathArray.length; i ++) {
            if (pathArray[i].equals(".") || pathArray[i].equals(""))
                continue;
        			
        	if (stack.isEmpty() && pathArray[i].equals(".."))
        	    continue;
        			
        	if (stack.isEmpty()) {
        		stack.add(pathArray[i]);
        	} else{
        		if (pathArray[i].equals(".."))
        			stack.pop();
        		else
        		    stack.add(pathArray[i]);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i ++) {
            sb.append("/");
            sb.append(stack.get(i));
        }
        
        return sb.toString().length() == 0 ? "/" : sb.toString();
    }
	
	public String simplifyPath_2(String path) {
		if (path == null)   return null;
        
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.trim().equals("")) {
                continue;
            } else if (dir.trim().equals(".")) {
                continue;
            } else if (dir.trim().equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.add(dir.trim());
            }
        }
        
        while (!stack.isEmpty()){
            sb.insert(0, "/" + stack.pop());
        }
        
        return (sb.length() == 0) ? "/" : sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "/abc/...";
//		String s = "/home//foo/";
		System.out.println(simplifyPath(s));
	}

}
