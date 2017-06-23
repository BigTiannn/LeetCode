/**
 * https://oj.leetcode.com/problems/powx-n/
 * Implement pow(x, n).
 * 
 * @author BigTiannn {11-16-2014}
 *
 */

public class Pow {
	public static double pow(double x, int n) {
		if (n == 0)	return 1;
        
        long absN = Math.abs((long)n);
        double res = 1;
        while (absN > 0) {
            if ((absN & 1) == 1)	// n is odd number
                res = res * x;
            x *= x;
            absN >>= 1;			    // n = n / 2 
        }
        
        return (n < 0) ? 1.0 / res : res;
    }
	
	// recursive
	public double pow_2(double x, int n) {
        return (n < 0) ? 1.0 / power(x, -n) : power(x, n);
    }
    
    public double power(double x, int n) {
        if (n == 0)
            return 1;
            
        double half = power(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(8.88023, 3));
	}

}
