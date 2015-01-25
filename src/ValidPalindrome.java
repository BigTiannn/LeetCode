
public class ValidPalindrome {
	
	public static boolean Solution (String s) {
		if (s == null) return true;
        
        s = s.toLowerCase().trim();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i ++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j --;
                continue;
            }
            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else {
                return false;
            }
        }
        
        return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = ".,";
		
		System.out.println(Solution(s1));
		System.out.println(Solution(s2));
		System.out.println(Solution(s3));
		
	}

}
