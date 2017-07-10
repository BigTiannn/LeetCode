import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/#/description
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author BigTiannn
 *
 */

public class FractionToRecurringDecimal {
  
   // Attention: convert numerator & denominator to long to handle Integer.MIN_VALUE
  public static String solution(int numerator, int denominator) {
    // <residue - index> map
    Map<Long, Integer> map = new HashMap<>();
    boolean negFlag = false;
    
    if ( (numerator > 0) ^ (denominator > 0) )  negFlag = true;
    if ( numerator == 0)    return "0";
    
    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    long intPart = num / den;
    long residue = num % den;
    String res = negFlag ? "-" : "";
    res += Long.toString(intPart);
    
    if (residue != 0) {
      res += '.';
      map.put(residue, res.length());
      while (residue != 0) {
        long currRes = residue * 10 / den;
        residue = residue * 10 % den;
        res += currRes;
        if (map.containsKey(residue)) {
          String firstHalf = res.substring(0, map.get(residue));
          String rearHalf = res.substring(map.get(residue));
          res = firstHalf + "(" + rearHalf + ")";
          break;
        }
        map.put(residue, res.length());
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String res = FractionToRecurringDecimal.solution(-1, -2147483648);
    System.out.println(res);
  }

}
