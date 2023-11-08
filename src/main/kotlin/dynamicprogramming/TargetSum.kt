package dynamicprogramming

/**
 * [494. Target Sum](https://leetcode.com/problems/target-sum/description/)
 *
 * @Difficulty=Medium
 */
class TargetSum {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val sum = nums.sum()
        if(sum < target || -sum > target) return 0

        var dp = IntArray(sum * 2 + 1) { 0 }
        dp[sum] = 1
        for(num in nums) {
            val next = IntArray(sum * 2 + 1) { 0 }
            for(k in 0 until (sum * 2 + 1)) {
                if(dp[k] != 0) {
                    next[k - num] += dp[k]
                    next[k + num] += dp[k]
                }
            }
            dp = next
        }
        return dp[target + sum]
    }
}
// Solution
/**
 * @Time_Complexity=O(n*sum)
 */