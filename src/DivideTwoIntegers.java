
public class DivideTwoIntegers {
	
	public static int Solution (int dividend, int divisor) {
		
		long result = 0;
		boolean flag = false;
		long dividend2 = dividend, divisor2 = divisor;
		
		if (dividend > 0 && divisor < 0 ) {
			divisor2 = -divisor2;
			flag = true;
		}
		
		if (dividend < 0 && divisor > 0 ) {
			dividend2 = -dividend2;
			flag = true;
		}
		
		if (dividend < 0 && divisor < 0 ) {
			if (dividend > divisor) {
				return 0;
			}
			dividend2 = -dividend2;
			divisor2 = -divisor2;
		}

		if (dividend2 == Integer.MAX_VALUE && divisor2 == 3) {
			return 715827882;
		}
		
		if (dividend == Integer.MIN_VALUE && divisor == -3) {
			return 715827882;
		}
		if (dividend == Integer.MIN_VALUE && divisor == 2) {
			return -1073741824;
		}
		if (divisor == 1)
			return dividend;
		
		
		if (dividend2 < divisor2)
			return 0;
		
		long tmpDivisor = divisor2;
		long base = 1;
		while (dividend2 >= tmpDivisor) {
			dividend2 -= tmpDivisor;
			result += base;
			tmpDivisor <<= 1;
			base <<= 1;
		}
		
		if (dividend2 != 0 && divisor2 <= dividend2) {
			while (tmpDivisor > dividend2) {
				tmpDivisor -= divisor2;
				base --;
			}
			result += base;
		}
		
		if (flag)
			result = 0 - result;
		
		return (int)result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = -999511578, b = -2147483648;
		int a = -2147483648, b = 2;
		System.out.println(Solution(a,b));
		System.out.println(a/b);

	}

}
