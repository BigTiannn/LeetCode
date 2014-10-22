
public class ZigZagConversion {
	
	public static String convert(String s, int nRows) {
		if (nRows <= 0)
			return null;
			
		if (nRows == 1 || s.length() <= 1)
		    return s;
		
		StringBuilder sb = new StringBuilder();
		int N = nRows + nRows - 2;
        int K = (s.length() % N == 0) ? s.length() / N : s.length() / N + 1;
        
        for (int i = 0; i < nRows; i ++) {
        	for (int j = 0; j < K; j ++) {
        		if (i + j * N < s.length()){
        			sb.append(s.charAt(i + j * N));
        		}
        		if (!(i == 0 || i == nRows - 1)) {
        			if ((j + 1) * N - i >= 0 && (j + 1) * N - i < s.length())
        				sb.append(s.charAt((j + 1) * N - i));
        		}
        	}
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "PAYPALISHIRING";
		String sol1 = "PAHNAPLSIIGYIR";
		System.out.println(sol1.equals(convert(s1, 3)));
		System.out.println(convert("ABCD", 3));
		System.out.println(convert("AB", 4));
	}

}
