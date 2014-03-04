/***
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Design an algorithm to find the maximum profit. 
 * You may complete at most two transactions.
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * 
 * @author BigTiannn
 *
 */
public class BuyAndSellStockIII {
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		
        int[] left_max_profit = new int[prices.length];
        int[] right_max_profit = new int[prices.length];
        
        int left_min = prices[0];
        for (int i = 1; i < prices.length; i ++) {
        	left_max_profit[i] = prices[i] - left_min > left_max_profit[i-1] ? 
        			prices[i] - left_min : 
        				left_max_profit[i-1];
        	left_min = prices[i] < left_min ? prices[i] : left_min;
        }
        
        int right_max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i --) {
        	right_max_profit[i] = right_max - prices[i] > right_max_profit[i+1] ? 
        			right_max - prices[i] : 
        				right_max_profit[i+1];
        	right_max = prices[i] > right_max ? prices[i] : right_max;
        }
        
        int max_two_transaction = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
        	if (max_two_transaction < left_max_profit[i] + right_max_profit[i + 1])
        		max_two_transaction = left_max_profit[i] + right_max_profit[i + 1];
        }
        
        return Math.max(max_two_transaction, left_max_profit[prices.length - 1]);
    }

	public static void main(String[] args) {
		int[] prices = {2,1};
		System.out.println(maxProfit(prices));
	}

}
