package linkedlist

/**
 * [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)
 * @Difficulty=Medium
 */
class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var current: ListNode? = dummyHead
        var carry = 0
        var p: ListNode? = l1
        var q: ListNode? = l2

        while (p != null || q != null || carry != 0) {
            val sum = (p?.`val` ?: 0) + (q?.`val` ?: 0) + carry
            carry = sum / 10
            val value = sum % 10

            current?.next = ListNode(value)
            current = current?.next

            if (p != null) {
                p = p.next
            }
            if (q != null) {
                q = q.next
            }
        }
        return dummyHead.next
    }

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
// Solution
/**
 * @Time_Complexity:O(maxOf(m,n))
 */