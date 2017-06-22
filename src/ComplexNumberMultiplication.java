/***
 * https://leetcode.com/problems/complex-number-multiplication/
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 *
 * @author BigTiannn
 */

public class ComplexNumberMultiplication {
	private class ComplexNumber {
        int real;
        int imaginary;
        public ComplexNumber (int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }
        // e.g. 1+1i, 0+-2i
//        public ComplexNumber (String str) {
//        	int i = 0;
//        	while ( str.charAt(i) != '+' && i < str.length()) {
//        		i ++;
//        	}
//        	this.real = Integer.parseInt(str.substring(0, i));	// now i points to '+'
//        	int j = ++i;
//        	while ( str.charAt(i) != 'i' && i < str.length() ) {
//        		i ++;
//        	}
//        	this.imaginary = Integer.parseInt(str.substring(j, i));	// now i points to 'i'
//        }
        public ComplexNumber (String str) {
        	String tmp[] = str.split("\\+|i");
        	this.real = Integer.parseInt(tmp[0]);
        	this.imaginary = Integer.parseInt(tmp[1]);
        }
        /*
         * (a + bi)(c + di) = (ac - bd) + (ad + bc) * i
         */
        public ComplexNumber multiply (ComplexNumber num) {
            int real = this.real * num.real - this.imaginary * num.imaginary;
            int imaginary = this.real * num.imaginary + this.imaginary * num.real;
            return new ComplexNumber(real, imaginary);
        }
        public String toString() {
        	return Integer.toString(this.real) + '+' + Integer.toString(this.imaginary) + 'i';
        }
    }
	
    public String complexNumberMultiply(String a, String b) {
    	ComplexNumber num1 = new ComplexNumber(a);
    	ComplexNumber num2 = new ComplexNumber(b);
    	ComplexNumber multi = num1.multiply(num2);
    	return multi.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumber num = new ComplexNumberMultiplication().new ComplexNumber("0+-2i");
		System.out.println(num.real + " " + num.imaginary);
	}

}
