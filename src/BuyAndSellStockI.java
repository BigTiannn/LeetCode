/***
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * At most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * @author BigTiannn
 *
 */
public class BuyAndSellStockI {
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		
        int max = prices[0], min = prices[0], max_prof = 0;
        for (int i = 1; i < prices.length; i ++) {
        	if (prices[i] > max) {
        		max = prices[i];
        		if (max - min > max_prof)
        			max_prof = max - min;
        	}
        	if (prices[i] < min) {
        		min = prices[i];
        		max = -1;
        	}
        }
        
        return max_prof;
    }
	
	public static void main (String[] args) {
		int[] prices = {4, 2, 1};
		System.out.println(maxProfit(prices));
	}
}
