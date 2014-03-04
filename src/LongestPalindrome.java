
public class LongestPalindrome {
	
	static String longestPalindromeDB(String s){
		int n = s.length();
		int longestBegin = 0;
		int maxlen = 1;
		Boolean table[][] = new Boolean[1000][1000];
		
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < n; j ++)
				table[i][j] = false;
		}
		
		for(int i = 0; i < n; i ++){
			table[i][i] = true;
		}
		
		for(int i = 0; i < n-1; i ++){
			if(s.charAt(i)==s.charAt(i+1)){
				table[i][i+1] = true;
				longestBegin = i;
				maxlen = 2;
			}
		}
		
		for(int len = 3; len <= n; len ++){
			for(int i = 0; i < n-len+1; i ++){
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j) && table[i+1][j-1] == true){
					table[i][j] = true;
					maxlen = len;
					longestBegin = i;
				}
			}
		}
		System.out.println("maxlen:" + maxlen);
		System.out.println("longestBegin:" + longestBegin);
		return s.substring(longestBegin, longestBegin+maxlen);
		
	}
	
	static String LongestPalindromeManacher(String s){
		;
		
		return s.substring(beginIndex, endIndex);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		abacdfgdcaba
//		babcbabcbaccba
		String test = LongestPalindrome.longestPalindromeDB("efabcdedcba");
		System.out.println(test);

	}

}
