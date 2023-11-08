package dynamicprogramming

/**
 * [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/)
 *
 * @Difficulty=Medium
 */
class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        val n = nums.size
        if(n == 1) return nums[0]

        var left = 1
        var right = 1
        var max = nums[0]
        for(i in 0 until n) {

            if(left == 0) left = 1
            if(right == 0) right = 1

            left *= nums[i]
            right *= nums[n - i - 1]

            max = maxOf(max, maxOf(left,right))
        }

        return max
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */