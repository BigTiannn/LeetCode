/***
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * You may complete as many transactions as you like (ie, buy one and sell one share of 
 * the stock multiple times). However, you may not engage in multiple transactions at the 
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author BigTiannn
 *
 */
public class BuyAndSellStockII {
	
	public static int solution1(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		
		int profit = 0, i = 0;
    while (i < prices.length) {
      // find next local minimum
      while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
      int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
      // find next local maximum
      while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
      profit += i < prices.length ? prices[i++] - min : 0;
    }
    return profit;
  }

	public static int solution2(int[] prices) {
	  if (prices == null || prices.length < 2)
      return 0;
	  
	  int profit = 0;
    for (int i = 0; i < prices.length - 1; i ++) {
      if (prices[i + 1] > prices[i])
        profit += prices[i + 1] - prices[i];
    }
    return profit;
	}
	
	public static void main(String[] args) {
		int[] prices = {2, 1, 2, 0, 1};
//		int[] prices = {6,1,3,2,4,7};
//		int[] prices = {2,1};
		System.out.println(solution1(prices));
	}

}
