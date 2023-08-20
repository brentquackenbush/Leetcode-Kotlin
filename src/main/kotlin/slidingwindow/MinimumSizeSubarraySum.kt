package slidingwindow

/**
 * [209. Minimum Size Subarray Sum
 * ](https://leetcode.com/problems/minimum-size-subarray-sum/description/)
 *
 * @Difficulty=Medium
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
class MinimumSizeSubarraySum {

    fun solution(nums: IntArray, target: Int): Int {
        var minimimalSubarrayLength = Int.MAX_VALUE
        var windowStart = 0
        var currentSum = 0
        for(windowEnd in nums.indices) {
            currentSum += nums[windowEnd]

            while(currentSum >= target) {
                minimimalSubarrayLength = minOf(minimimalSubarrayLength, windowEnd - windowStart + 1)
                currentSum -= nums[windowStart++]
            }
        }

        return if(minimimalSubarrayLength == Int.MAX_VALUE) 0 else minimimalSubarrayLength
    }
}
/**
 * @Time_Complexity=O(n)
 */