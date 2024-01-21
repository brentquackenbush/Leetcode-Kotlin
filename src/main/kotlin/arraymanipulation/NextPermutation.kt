package arraymanipulation

/**
 * [31. Next Permutation](https://leetcode.com/problems/next-permutation/description/)
 *
 * @Difficulty=Medium
 */
class NextPermutation {
    fun nextPermutation(nums: IntArray) {
        var i = nums.size - 2

        // Step 1: Find the first pair (i, i+1) such that nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--
        }

        // If such a pair exists
        if (i >= 0) {
            // Step 2: Find the smallest number greater than nums[i]
            var j = nums.size - 1
            while (nums[j] <= nums[i]) {
                j--
            }

            // Step 3: Swap nums[i] and nums[j]
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        // Step 4: Reverse the subarray from i+1 to the end
        var left = i + 1
        var right = nums.size - 1
        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }
}
// Solution
/**
 * @Time_Complexity=
 */
