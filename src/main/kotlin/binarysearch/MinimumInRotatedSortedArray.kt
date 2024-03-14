package binarysearch

/**
 * [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)
 *
 * @Difficulty=Medium
 */
class MinimumInRotatedSortedArray {

    fun findMin(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]

        var left = 0
        var right = nums.size - 1
        while(left < right) {
            val mid = left + (right - left) / 2
            if(nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return nums[left]
    }
}
// Solution
/**
 * @Time_Complexity=O(logn)
 */
