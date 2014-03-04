
public class ValidPalindrome {
	
	public static boolean Solution (String s) {
		
		if (s == null)
			return true;
		
		int i = 0, j = s.length() - 1;
		s = s.toLowerCase();
		while (i<j) {
			while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i)))
				i ++;
			while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j)))
				j --;
			if (i >=s.length() || j < 0)
				return true;
			if (s.charAt(i) != s.charAt(j))
				return false;
			else {
				i ++;
				j --;
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
