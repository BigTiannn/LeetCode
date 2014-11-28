/**
 * https://oj.leetcode.com/problems/scramble-string/
 * 
 * @author BigTiannn {11-27-2014}
 *
 */
public class ScrambleString {
	
	// recursive
	public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        int[] A = new int[26];
        for(int i = 0; i < s1.length(); i ++)
            A[s1.charAt(i) - 'a'] ++;
            
        for(int i = 0; i < s2.length(); i ++)
            A[s2.charAt(i) - 'a'] --;
            
        for(int i = 0; i < 26; i ++)
            if(A[i] != 0)
                return false;
        
        if(s1.length() == 1 && s2.length() == 1)
            return true;
            
        for (int i = 1; i < s1.length(); i ++) {
            boolean result = isScramble(s1.substring(0, i), s2.substring(0, i))
                            && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
            result = result || (isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length()))
                            && isScramble(s1.substring(i, s1.length()), s2.substring(0, s1.length() - i)));   
            if (result) return true;
        }   
        return false;  
    }
	
	// dp
	public boolean isScramble_dp(String s1, String s2) {
        if(s1==null || s2==null || s1.length() != s2.length())
            return false;
        if(s1.length()==0)
            return true;
            
        boolean[][][] res = new boolean[s1.length()][s2.length()][s1.length()+1];
        // initialize
        for(int i = 0; i < s1.length(); i ++) {
            for(int j = 0; j < s2.length(); j ++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        for(int len = 2; len <= s1.length(); len ++) {
            for(int i = 0; i < s1.length() - len + 1; i ++) {
                for(int j = 0; j < s2.length() - len + 1; j ++) {
                    for(int k = 1; k < len; k ++) {
                        res[i][j][len] |= res[i][j][k]&&res[i+k][j+k][len-k] || res[i][j+len-k][k]&&res[i+k][j][len-k];
                    }
                }
            }
        }
        return res[0][0][s1.length()]; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
