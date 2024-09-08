/*
You are given an array prices where prices[i] is the price of a given stock on the  day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: [3, 2, 6, 5, 0, 3]
Expected Output: 4
Justification: Buy the stock on day 2 (price = 2) and sell it on day 3 (price = 6). Profit = 6 - 2 = 4.

Example 2:
Input: [8, 6, 5, 2, 1]
Expected Output: 0
Justification: Prices are continuously dropping, so no profit can be made
 */
public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {

        int minSofar = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            minSofar = Math.min(minSofar, price);
            int profit = price - minSofar;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
