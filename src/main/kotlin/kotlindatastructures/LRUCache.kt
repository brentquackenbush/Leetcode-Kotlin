package kotlindatastructures
/**
 * [146. LRU Cache](https://leetcode.com/problems/lru-cache/description/)
 *
 * Long problem, it would honestly suck to get this in an interview.
 * Knowing this and getting asked this will surely get you the job if you can talk through the
 * requirements and how to achieve that using the underlying data structures.
 *
 * @Difficulty=Medium
 */

class LRUCache(private val capacity: Int) {
    private class Node(var key: Int = 0, var value: Int = 0) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node() // Dummy head
    private val tail = Node() // Dummy tail

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        // Move the accessed node to the front (MRU)
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        var node = map[key]
        if (node == null) {
            node = Node(key, value)
            map[key] = node
            addNode(node)
            if (map.size > capacity) {
                // Correctly reference the node to remove
                val lruNode = tail.prev // Node to remove
                removeNode(lruNode!!)
                map.remove(lruNode.key)
            }
        } else {
            // Update the value and move to front
            node.value = value
            moveToHead(node)
        }
    }

    private fun addNode(node: Node) {
        // Always add the new node right after head
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: Node) {
        // Remove an existing node from the linked list
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun moveToHead(node: Node) {
        // Move certain node to the head
        removeNode(node)
        addNode(node)
    }
}
// Solution
/**
 * @Time_Complexity=O(1) requirements for both the get and put.
 */
