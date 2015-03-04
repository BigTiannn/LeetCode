/***
 * http://oj.leetcode.com/problems/restore-ip-addresses/
 * Given a string containing only digits, restore it by 
 * returning all possible valid IP address combinations.
 * 
 * @author BigTiannn
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIPAddress {
	
	public static boolean isValid (String str) {
		if (str.length() > 1 && str.charAt(0) == '0')
			return false;
		
		if (Integer.parseInt(str) <= 255 && Integer.parseInt(str) >= 0)
			return true;
		
		return false;
	}
	
	
	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<>();
		
        // sanity check
		if (s.length() < 4 || s.length() > 12)
			return res;
		
		for (int i = 0; i < 3; i ++) {
			String firstSeg = s.substring(0, i + 1);
			if (!isValid(firstSeg) || s.length() - i - 1 > 9 || s.length() - i - 1 < 3)
				continue;
			for (int j = i + 1; j < s.length() && j <= i + 3; j ++) {
				String secondSeg = s.substring(i + 1, j + 1);
				if (!isValid(secondSeg) || s.length() - j - 1 > 6 || s.length() - j - 1 < 2)
					continue;
				for (int k = j + 1; k < s.length() && k <= j + 3; k ++) {
					String thirdSeg = s.substring(j + 1, k + 1);
					if (!isValid(thirdSeg) || s.length() - k - 1 > 3 || s.length() - k - 1 < 1)
						continue;
					String forthSeg = s.substring(k + 1, s.length());
					if (isValid(thirdSeg) && isValid(forthSeg)) {
						res.add(firstSeg + "." + secondSeg + "." + thirdSeg + "." + forthSeg);
					}
				}
			}
		}
		
		return res;
    }
	
	// implementation 2
	public List<String> restoreIpAddresses_2(String s) {
        List<String> res = new ArrayList<>();
        String[] addr = new String[4];
        
        dfs(s, addr, 0, 0, res);
        
        return res;
    }
    
    private void dfs(String s, String[] segs, int start, int step, List<String> res) {
        if (start == s.length() && step == 4) {
            res.add(segs[0] + "." + segs[1] + "." + segs[2] + "." + segs[3]);
            return;
        }
        
        // prune
        if (s.length() - start > (4 - step) * 3 ||
            s.length() - start < 4 - step)
            return;
        
        int num = 0;
        for (int i = start; i < Math.min(start + 3, s.length()); i ++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num <= 255) {
                segs[step] = s.substring(start, i + 1);
                dfs(s, segs, i + 1, step + 1, res);
            }
            // don't allow leading zero, but single zero is ok
            if (num == 0)   break;
        }
    }
	
	public static void main(String[] args) {
//		String test = "25525511135";
//		String test = "101023";
		String test = "0000";
		System.out.println(Arrays.toString(restoreIpAddresses(test).toArray()));
	}

}
