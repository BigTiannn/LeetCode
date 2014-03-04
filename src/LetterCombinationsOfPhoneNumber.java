import java.util.ArrayList;
import java.util.Arrays;


public class LetterCombinationsOfPhoneNumber {
	public static ArrayList<String> Solution (String digits) {
		ArrayList<String> results = new ArrayList<>();
		String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		helper(digits, phone, 0, "", results);
		
		return results;
	}
	
	private static void helper (String digits, String[] phone, 
			int ptr, String midRes, ArrayList<String> results) {
		ArrayList<String> res = new ArrayList<>();
		
		if (ptr == digits.length()) {
			results.add(midRes);
			return ;
		}
		
		int number = digits.charAt(ptr) - '0';
		for (int j = 0; j < phone[number].length(); j ++) {
			String s = midRes + phone[number].charAt(j);
			helper(digits, phone, ptr + 1, s, results);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "23";
		ArrayList<String> results = Solution(digits);
		System.out.println(Arrays.toString(results.toArray()));

	}

}
