package arraymanipulation

/**
 * [1567. Maximum Length of Subarray With Positive Product](https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/description/)
 *
 * @Difficulty=Medium
 */
class MaximumLengthOfSubarrayWithPositiveProduct {

    fun getMaxLen(nums: IntArray): Int {

        var negCount = 0
        var curLen = 0
        var maxLen = 0

        for(i in nums.indices) {
            if(nums[i] > 0) {
                curLen++
            } else if(nums[i] < 0) {
                curLen++
                negCount++
            } else {
                curLen = 0
                negCount = 0
            }
            if(negCount % 2 == 0) maxLen = maxOf(maxLen, curLen)
        }

        curLen = 0
        negCount = 0

        for(i in nums.indices.reversed()) {
            if(nums[i] > 0) {
                curLen++
            } else if(nums[i] < 0) {
                negCount++
                curLen++
            } else {
                curLen = 0
                negCount = 0
            }
            if(negCount % 2 == 0) maxLen = maxOf(maxLen, curLen)
        }

        return maxLen
    }
}
/**
 * @Time_Complexity=O(n + n) = O(n)
 */