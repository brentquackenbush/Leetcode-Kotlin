package binarysearch

/**
 * [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/description/)
 *
 * @Difficulty=Medium
 */
class FindPeakElement {
    // I need to return the index of a peak
    // A peak is if it is bigger than its left and right neighbor. Kind of like a mountain
    // out of bounds is always smaller
    // I can do this by O(logn) by starting at the middle and finding the peak
    // If there is no peak at the middle go to the next biggest number
    // and keep going

    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2 // Solves overflow error
            if (nums[mid] > nums[mid + 1]) {
                // Peak is to the left or at mid
                right = mid
            } else {
                // Peak is to the right
                left = mid + 1
            }
        }
        return left
    }
}
// Solution
/**
 * @Time_Complexity=O(logn)
 */