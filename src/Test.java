import java.util.HashMap;


public class Test {
  public int solution(String s) {
    int start = 0, end = 0, maxLen = 0;
    HashMap<Character, Integer> charIndexMap = new HashMap<>();
    
    while ( start < s.length() && end < s.length() ) {
        if ( charIndexMap.containsKey(s.charAt(end)) && charIndexMap.get(s.charAt(end)) > start ) {
            maxLen = (end - start > maxLen) ? (end - start) : maxLen;
            start = charIndexMap.get(s.charAt(end)) + 1;
            charIndexMap.put(s.charAt(end), end);
            // end = start + 1;
        } else {
            charIndexMap.put(s.charAt(end), end);
            end ++;
        }
    }
    maxLen = (end - start > maxLen) ? (end - start) : maxLen;
    return maxLen;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
