/**
 * https://leetcode.com/problems/gas-station/description/
 * There are N gas stations along a circular route, where the amount of gas 
 * at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to 
 * travel from station i to its next station (i+1). You begin the journey with 
 * an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit 
 * once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 *
 * @author BigTiannn
 *
 */

public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int gasSum = 0, costSum = 0;
		
		for (int i = 0; i < gas.length; i ++) {
			gasSum += gas[i];
			costSum += cost[i];
		}
		
		if (gasSum < costSum) 
			return -1;
		
		int start = 0, i = 0, residue = 0;
		while (true) {
			start = i % gas.length;
			i = start;
			residue = 0;
			System.out.println("start:" + start);
			do {
				residue += gas[i] - cost[i];
				i = ( i + 1 ) % gas.length;
				
				if (residue < 0)
					break;
			} while (i != start);
			
			System.out.println(i);
			
			if (i == start)
				return start;
				
		}
  }
	
	public int canCompleteCircuit2(int[] gas, int[] cost) {
      int start = 0, residue = 0, total = 0;
      for (int i = 0; i < gas.length; i ++) {
        residue += gas[i] - cost[i];
        total += gas[i] - cost[i];
        if (residue < 0) {
          start = i + 1;
          residue = 0;
        }
      }
      return total >= 0 ? start : -1;
    }
	
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 3};
		int[] cost = {2, 1, 5, 1};
		
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
