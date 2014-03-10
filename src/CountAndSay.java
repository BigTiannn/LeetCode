/***
 * http://oj.leetcode.com/problems/count-and-say/
 * 
 * @author BigTiannn
 */
public class CountAndSay {
	
	public static String countAndSay(int n) {
		int strNum = 1;
		String tmp = "1";
		StringBuffer result = new StringBuffer("1");
        while (strNum < n) {
        	int counter = 1;
        	result.setLength(0);
        	int i = 1;
        	for (; i < tmp.length(); i ++) {
        		if (tmp.charAt(i) == tmp.charAt(i - 1)) {
        			counter ++;
        		} else {
        			result.append(Integer.toString(counter) + tmp.charAt(i - 1));
        			counter = 1;
        		}
        	}
        	
        	result.append(Integer.toString(counter) + tmp.charAt(i - 1));
        	
        	tmp = result.toString();
        	strNum ++;
        }
        
        return result.toString();
    }

	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}

}
