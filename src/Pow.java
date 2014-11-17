/**
 * https://oj.leetcode.com/problems/powx-n/
 * Implement pow(x, n).
 * 
 * @author BigTiannn {11-16-2014}
 *
 */

public class Pow {
	public double pow(double x, int n) {
		if (n == 0)
            return 1;
            
        boolean flag = false;
        if (n < 0)
            flag = true;
            
        n = Math.abs(n);
        
        double res = 1, np = x;
        while (n > 0) {
            if (n % 2 == 1)
                res = res * np;
            np *= np;
            n /= 2;
        }
        
        return flag ? 1.0 / res : res;
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

	}

}
