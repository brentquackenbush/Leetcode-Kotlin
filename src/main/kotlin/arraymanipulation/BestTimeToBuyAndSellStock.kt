package arraymanipulation

/**
 * [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)
 *
 * @Difficulty=
 */
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        // Keep track of minimum price
        // Keep track of maximum profit
        var minPrice = prices[0]
        var maxProfit = Int.MIN_VALUE
        for(i in 1 until prices.size) {
            if(prices[i] < minPrice) {
                minPrice = prices[i]
            } else {
                if(prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice
                }
            }
        }
        return if(maxProfit <= 0) return 0 else maxProfit
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */