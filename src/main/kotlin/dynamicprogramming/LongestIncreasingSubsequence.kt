package dynamicprogramming

/**
 * [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/)
 *
 * @Difficulty=Medium
 */
class LongestIncreasingSubsequence {
    /**
     * Binary Search
     * Time complexity = O(nlogn) Using binary search
     */
    fun lengthOfLIS(nums: IntArray): Int {
        val tails = IntArray(nums.size)
        var size = 0
        for (x in nums) {
            var i = 0
            var j = size
            while (i != j) {
                val m = (i + j) / 2
                if (tails[m] < x) i = m + 1
                else j = m
            }
            tails[i] = x
            if (i == size) size++
        }
        return size
    }

    /**
     * Dynamic Programming
     * Time complexity = O(n^2)
     */
    fun lengthOfLIS_DP(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n) { 1 } // Initialize all elements to 1
        var maxLength = 1 // To store the length of LIS

        for (i in 1 until n) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
            maxLength = maxOf(maxLength, dp[i]) // Update the maxLength
        }

        return maxLength
    }
}
/**
 * @Time_Complexity=O(nlogn)
 */