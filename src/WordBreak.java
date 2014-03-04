import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {
	
	public static boolean Solution1 (String s, Set<String> dict) {
		if (s == null)
			return false;
		
		int len = s.length();
		boolean[] result = new boolean[len + 1];
		result[0] = true;
		
		for (int i = 1; i <= len; i ++) {
			for (int j = 0; j < i; j ++) {
				if (result[j] && dict.contains(s.substring(j, i))) {
					result[i] = true;
					break;
				}
			}
		}
		
		return result[len];
	}
	
	public static ArrayList<String> Solution2 (String s, Set<String> dict) {
		if (s == null || dict.size() <= 0)
			return null;
		
		int len = s.length();
		boolean[][] result = new boolean[len][len];
		
		for (int i = 0; i < len; i ++) {
			for (int j = i; j < len; j ++) {
				String subS = s.substring(i, j + 1);
				if (dict.contains(subS))
					result[i][j] = true;
				else
					result[i][j] = false;
			}
		}
		
//		for (int i = 0; i < len; i ++) {
//			for (int j = 0; j < len; j ++) {
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.print("\n");
//		}
		
		int j = 0;
		ArrayList<String> results = null;
		while (j < len) {
			if (result[0][j]) {
				ArrayList<Integer> seg = new ArrayList<>();
				seg.add(j);
//				System.out.println("1");
				helper(len, result, j + 1, j + 1, seg);
//				System.out.println(Arrays.toString(seg.toArray()));
				if (seg.get(seg.size() - 1) == len - 1) {
					System.out.println("2");
					String str = new String(s.substring(0, seg.get(0)+1));
					for (int i = 0; i < seg.size() - 1; i ++) {
						str += " " + s.substring(seg.get(i)+1, seg.get(i+1)+1);
					}
					if (results == null)
						results = new ArrayList<>();
					results.add(str);
				}
			}
			j ++;
		}
		
		return results;
	}
	
	public static void helper (int strLen, boolean[][] matrix, int row, int col, ArrayList<Integer> seg) {
		if (col == strLen - 1 && matrix[row][col]) {
			seg.add(col);
			return;
		}
		
		int i = col;
		while (i < strLen) {
			if (matrix[row][i]) {
				seg.add(i);
				helper(strLen, matrix, i + 1, i + 1, seg);
				seg.remove((Integer)i);
			}
			i ++;
		}
		
		return;
	}
	
	public static  ArrayList<String> wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || dict.size() <= 0) {
            return result;
        }
        
        int length = s.length();
        boolean[][] seg = new boolean[length][length + 1];
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                String t = s.substring(i, i + len);
                if (dict.contains(t)) {
                    seg[i][len] = true;
                    continue;
                }
                for (int k = 1; k < len; k++) {
                    if (seg[i][k] && seg[i + k][len - k]) {
                        seg[i][len] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < length; i ++) {
			for (int j = 0; j < length + 1; j ++) {
				System.out.print(seg[i][j] + " ");
			}
			System.out.print("\n");
		}
        
        if (!seg[0][length]) {
            return result;
        }
        
        int depth = 0;
        dfs(s, seg, 0, length, depth, result, new StringBuffer(), dict);
        return result;
    }
    
    private static void dfs(String s, boolean[][] seg, int start, int length,
        int depth, ArrayList<String> result, StringBuffer sb, Set<String> dict) {
        if (depth == length) {
            String t = sb.toString();
            result.add(t.substring(0, t.length() - 1));
            return;
        }
        
        for (int len = 1; len <= length; len++) {
            if (seg[start][len]) {
                String t = s.substring(start, start + len);
                if(!dict.contains(t)){
                    continue;
                }
                int beforeAddLen = sb.length();
                sb.append(t).append(" ");
                dfs(s, seg, start + len, length, start + len, result, sb, dict);
                sb.delete(beforeAddLen, sb.length());
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		Set<String> dict = new HashSet<>();
		String s1 = new String("leet");
		String s2 = new String("code");
//		String s3 = new String("sadd");
//		String s4 = new String("dog");
//		String s5 = new String("og");
		dict.add(s1);
		dict.add(s2);
//		dict.add(s3);
//		dict.add(s4);
//		dict.add(s5);
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//		String s1 = new String("a");
//		String s2 = new String("aa");
//		String s3 = new String("aaa");
//		String s4 = new String("aaaa");
//		String s5 = new String("aaaaa");
//		String s6 = new String("aaaaaab");
//		String s7 = new String("aaaaaaa");
//		String s8 = new String("aaaaaaaa");
//		String s9 = new String("aaaaaaaaa");
//		String s10 = new String("aaaaaaaaaa");
//		dict.add(s1);
//		dict.add(s2);
//		dict.add(s3);
//		dict.add(s4);
//		dict.add(s5);
//		dict.add(s6);
//		dict.add(s7);
//		dict.add(s8);
//		dict.add(s9);
//		dict.add(s10);
		ArrayList<String> ss = wordBreak(s, dict);
		if ( ss == null ) {
			System.out.println("null");
		} else {
			System.out.println(Arrays.toString(ss.toArray()));
		}

	}

}
