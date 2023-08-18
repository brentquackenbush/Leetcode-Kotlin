package slidingwindow

/**
 * [992. Subarrays with K Different](https://leetcode.com/problems/subarrays-with-k-different-integers/description/)
 *
 * DIFFICULTY=HARD
 *
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A good array is an array where the number of different integers in that array is exactly k.
 *
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 */
class SubarraysWithKDifferent {

    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        if (k == 0) return 0

        var count = 0
        var left = 0
        val frequencyMap = mutableMapOf<Int, Int>()

        for (right in nums.indices) {
            val rightValue = nums[right]
            frequencyMap[rightValue] = frequencyMap.getOrDefault(rightValue, 0) + 1

            while (frequencyMap.size > k) {
                val leftValue = nums[left]
                val updatedFrequency = frequencyMap.getOrDefault(leftValue, 0) - 1
                if (updatedFrequency == 0) {
                    frequencyMap.remove(leftValue)
                } else {
                    frequencyMap[leftValue] = updatedFrequency
                }
                left++
            }

            if (frequencyMap.size == k) {
                var tempLeft = left
                while ((frequencyMap[nums[tempLeft]] ?: 0) > 1) {
                    val tempLeftValue = nums[tempLeft]
                    frequencyMap[tempLeftValue] = frequencyMap.getOrDefault(tempLeftValue, 0) - 1
                    tempLeft++
                }
                count += tempLeft - left + 1

                while (tempLeft > left) {
                    val tempLeftValue = nums[tempLeft - 1]
                    frequencyMap[tempLeftValue] = frequencyMap.getOrDefault(tempLeftValue, 0) + 1
                    tempLeft--
                }
            }
        }

        return count
    }
}
// Solution
/**
 * @Time_Complexity:
 * Brute force is O(n^3) Solve for every single possible subarray and keep track of all subarrays of different integers k.
 */
