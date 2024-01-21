package arraymanipulation

/**
 * [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)
 *
 * @Difficulty=Medium
 */
class BestTimeToBuyAndSellStockII {

    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                result += (prices[i] - prices[i - 1])
            }
        }
        return result
    }
}
// Solution
/**
 * @Time_Complexity=O(n) One pass
 */
