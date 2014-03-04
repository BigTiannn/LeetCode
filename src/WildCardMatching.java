
public class WildCardMatching {
	
	public static boolean isMatch(String s, String p) {
        return false;
    }

	public static void main(String[] args) {
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa","*"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("ab","?*"));
		System.out.println(isMatch("aab","c*a*b"));
		//2147483647
		System.out.println(Integer.MAX_VALUE);
	}

}
