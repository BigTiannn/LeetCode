
public class StrStr {
	
	public static String strStr(String haystack, String needle) {
		if (needle == null)
			return null;
		
		int needleLen = needle.length();
        for (int i = 0; i <= haystack.length() - needleLen; i ++) {
        	if (needle.equals(haystack.substring(i, i + needleLen))) {
        		return haystack.substring(i);
        	}
        }
        
        return null;
    }

	public static void main(String[] args) {
		String s1 = "", s2 = "";
		System.out.println(strStr(s1, s2));

	}

}
