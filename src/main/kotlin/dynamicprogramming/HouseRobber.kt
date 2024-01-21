package dynamicprogramming

/**
 * [198. House Robber](https://leetcode.com/problems/house-robber/description)
 *
 * @Difficulty=Medium
 */
class HouseRobber {

    // Top-down approach
//    fun rob(nums: IntArray): Int {
//        val memo = IntArray(nums.size) { -1 }
//        return robFrom(nums, nums.size -1, memo)
//    }
//
//    fun robFrom(nums: IntArray, i: Int, memo: IntArray): Int {
//        if(i < 0) return 0
//
//        if(memo[i] > 0) return memo[i]
//
//        val result  = maxOf(robFrom(nums, i-1, memo), robFrom(nums, i - 2, memo) + nums[i])
//        memo[i] = result
//
//        return result
//    }
}
// Solution
/**
 * @Time_Complexity= O(n)
 */
