package dynamicprogramming

/**
 * [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
class MaximumSubarray {

    companion object {
        private val nums = mutableListOf(1, 4, -2, -1, 5)
    }

    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var currentSum = nums[0]
        // iterate through the entire array and using a variable to keep track of the current sum, find the maximum sum
        // by holding checking every value if it is greater than the current maximum sum
        // maxOf I believe is the idiotmatic Kotlin way of Math.max in Java.
        for (i in 1 until nums.size) {
            currentSum = maxOf(nums[i], currentSum + nums[i])
            if (currentSum > maxSum) {
                maxSum = currentSum
            }
        }
        return maxSum
    }
}
// Solution
/**
 * @Time_Complexity: O(n) linear time. We are making one pass through the array with no stops. We are using a variable
 * to keep track of the maximum sum by comparing the maximum sum variable to itself and the current aggregate sum.
 */
