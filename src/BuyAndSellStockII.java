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
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		
        int buy = 0, sell = 1;
        int total_profit = 0;
        while (sell < prices.length) {
        	while (sell < prices.length && prices[buy] >= prices[sell]) {
        		buy ++;
        		sell ++;
        	}
        	if (sell >= prices.length)
        		break;
        	int new_sell = sell + 1;
        	while (new_sell < prices.length && prices[new_sell] >= prices[sell]) {
        		new_sell ++;
        		sell ++;
        	}
        	total_profit += prices[sell] - prices[buy];
        	buy = new_sell;
        	sell = buy + 1;
        }
        
        return total_profit;
    }

	public static void main(String[] args) {
		int[] prices = {2, 1, 2, 0, 1};
//		int[] prices = {6,1,3,2,4,7};
//		int[] prices = {2,1};
		System.out.println(maxProfit(prices));
	}

}
