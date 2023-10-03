package priorityqueue

import java.util.PriorityQueue

/**
 * [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/)
 */
class FindKthLargest {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>( compareByDescending { it })
        for(num in nums) {
            pq.offer(num)
        }

        for(i in 1 until k) {
            pq.poll()
        }
        return pq.peek()
    }
}
// Solution
/**
 * @Time_Complexity=O(nlogk)
 */