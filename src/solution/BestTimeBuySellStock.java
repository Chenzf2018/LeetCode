package solution;

/**
 * leetcode_121_买卖股票的最佳时机
 * @author Chenzf
 * @date 2020/7/29
 * @version 1.0
 */

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxPrice) {
                maxPrice = prices[i] - minPrice;
            }
        }

        return maxPrice;
    }
}
