/***
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * At most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * 
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author BigTiannn
 *
 */

public class BuyAndSellStockI {
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)  return 0;
    
    int maxProfit = prices[1] - prices[0], minPrice = prices[0];
    for (int i = 1; i < prices.length; i ++) {
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);
    }
    if (maxProfit < 0) maxProfit = 0;
    
    return maxProfit;
  }
	
	public static void main (String[] args) {
		int[] prices = {4, 2, 1};
		System.out.println(maxProfit(prices));
	}
}
