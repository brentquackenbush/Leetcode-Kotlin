package twopointers

/**
 * [31. Next Permutation](https://leetcode.com/problems/next-permutation/)
 *
 * @Difficulty=Medium
 *
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * NOTE: The replacement must be in place and use only constant extra memory.
 */
class NextPermutation {

    fun solution(nums: IntArray) {
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
 * @Time_Complexity=O(n)
 *
 * Very surprised at this question. It is really tricky unless you have solved this problem before
 * The algorithm to find the next permutation is hard.
 */
