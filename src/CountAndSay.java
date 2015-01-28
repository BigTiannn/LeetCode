/***
 * http://oj.leetcode.com/problems/count-and-say/
 * 
 * @author BigTiannn
 */
public class CountAndSay {
	
	public static String countAndSay(int n) {
		String s = "1";
		StringBuffer res = new StringBuffer("1");
        for (int i = 1; i < n; i ++) {
        	int count = 1;
        	res.setLength(0);
        	for (int j = 1; j < s.length(); j ++) {
        		if (s.charAt(j) == s.charAt(j - 1)) {
        			count ++;
        		} else {
        			res.append(Integer.toString(count) + s.charAt(j - 1));
        			count = 1;
        		}
        	}
        	res.append(Integer.toString(count) + s.charAt(s.length() - 1));
        	s = res.toString();
        }
        return res.toString();
    }
	

	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}

}
