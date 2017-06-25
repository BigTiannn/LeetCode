/**
 * Implement pow(x, n) where n is double
 * 
 * @author BigTiannn {06-24-2016}
 *
 */

public class Pow2 {
	
	public double solution(double x, double n) {
		double lowerPower = Math.floor(n), 
		       upperPower = Math.ceil(n);
		
		double lowerVal = calcIntPower(x, (int) lowerPower), 
		       upperVal = calcIntPower(x, (int) upperPower);
		
		double res = Integer.MAX_VALUE, preRes;
		
		do {
		  preRes = res;
		  double midPower = 0.5 * (lowerPower + upperPower);
      double midVal =  Math.sqrt(lowerVal * upperVal);
      x = Math.sqrt(x);
      res = midVal;
//      System.out.println(midVal);
		  if ( n < midPower ) {
		    upperPower = midPower;
        upperVal = midVal;
		  } else if (n > midPower) {
		    lowerPower = midPower;
        lowerVal = midVal;
		  }
		} while (preRes != res && !Double.isNaN(preRes) && !Double.isNaN(res));
		
		return res;
	}
	
	private double calcIntPower(double x, int n) {
		return (n < 0) ? 1.0 / calcIntPowerHelper(x, -n) : calcIntPowerHelper(x, n);
	}
	
	private double calcIntPowerHelper(double x, int n) {
	  if (n == 0)  return 1;
	  
	  double half = calcIntPowerHelper(x, n / 2);
	  if ( (n & 1) == 1 ) return half * half * x;
	  else   return half * half;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Pow2 instance = new Pow2();
	  System.out.println(instance.solution(3, 1) + "\t" + Math.pow(3, 1));
	  System.out.println(instance.solution(3, 2.2) + "\t" + Math.pow(3, 2.2));
	  System.out.println(instance.solution(3, 2.8) + "\t" + Math.pow(3, 2.8));
	  System.out.println(instance.solution(1, 1) + "\t" + Math.pow(1, 1));
	  System.out.println(instance.solution(3, 0) + "\t" + Math.pow(3, 0));
	  System.out.println(instance.solution(0, 1) + "\t" + Math.pow(0, 1));
	  System.out.println(instance.solution(-3, 2) + "\t" + Math.pow(-3, 2));
	  System.out.println(instance.solution(-3, 1.1) + "\t" + Math.pow(-3, 1.1));
	  System.out.println(instance.solution(3, -0.1) + "\t" + Math.pow(3, -0.1));
	  System.out.println(instance.solution(1.1, -0.1) + "\t" + Math.pow(1.1, -0.1));
	  System.out.println(instance.solution(1.2, Math.PI) + "\t" + Math.pow(1.2, Math.PI));
	}

}
