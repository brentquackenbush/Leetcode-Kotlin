package linkedlist

import java.util.PriorityQueue

/**
 * [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/description/)
 * @Difficulty=Hard
 */
class MergeKSortedLists {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty() || lists.all { it == null }) return null

        val heap = PriorityQueue<ListNode>(compareBy { it.`val` })
        lists.filterNotNull().forEach { heap.offer(it) }

        val dummyHead = ListNode(0)
        var current: ListNode? = dummyHead

        while (heap.isNotEmpty()) {
            val node = heap.poll()
            current?.next = node
            current = node
            node.next?.let { heap.offer(it) }
        }

        return dummyHead.next
    }
}
/**
 * @Time_Complexity=O(nlogn)
 */
