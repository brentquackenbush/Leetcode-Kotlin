package slidingwindow

import java.util.LinkedList

/**
 * [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
 *
 * @Difficulty=Hard
 */
class SlidingWindowMaximum {

    /**
     * This was my initial thought process which takes O(n*k)
     */
    fun nonOptimizedSolution(nums: IntArray, k: Int): IntArray {
        if (nums.size == 1) return nums

        val result = IntArray(nums.size - k + 1)
        for (i in 0..nums.size - k) {
            var max = Int.MIN_VALUE
            for (j in i until i + k) {
                max = max.coerceAtLeast(nums[j])
            }
            result[i] = max
        }

        return result
    }

    fun solution(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf()

        val result = IntArray(nums.size - k + 1)
        val deque = LinkedList<Int>()

        for (i in nums.indices) {
            // Remove elements outside the current window
            while (deque.isNotEmpty() && deque.first() < i - k + 1) {
                deque.removeFirst()
            }

            // Remove elements smaller than the current element
            while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
                deque.removeLast()
            }

            deque.addLast(i)

            // The first element of the deque is the maximum of the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.first()]
            }
        }
        return result
    }
}
// Solution
/**
 * @Time_Complexity: O(n)
 */
