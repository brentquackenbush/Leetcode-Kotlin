package binarytree

import bst.TreeNode

/**
 * [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/description/)
 *
 * @Difficulty=Medium
 */
class BottomLeftValue {
    fun findBottomLeftValueDfs(root: TreeNode?): Int {
        if (root == null) return -1

        var bottomLeftValue = 0
        var maxDepth = -1

        fun dfs(node: TreeNode?, depth: Int) {
            if (node == null) return

            if (depth > maxDepth) {
                maxDepth = depth
                bottomLeftValue = node.`val`
            }

            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)
        }

        dfs(root, 0)
        return bottomLeftValue
    }

    fun findBottomLeftValueBfs(root: TreeNode?): Int {
        if (root == null) return -1

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var current = root

        while (queue.isNotEmpty()) {
            // Remove the first node of this level
            current = queue.removeFirst()

            // Add children to queue: right first, then left
            if (current.right != null) queue.add(current.right!!)
            if (current.left != null) queue.add(current.left!!)
        }

        // The last processed node will be the leftmost of the last level
        return current!!.`val`
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */
