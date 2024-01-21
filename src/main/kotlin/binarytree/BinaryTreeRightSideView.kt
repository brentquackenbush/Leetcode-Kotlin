package binarytree

import bst.TreeNode

/**
 * [199. Binary Tree Right Side View](https://leetcode.com/problems/closest-binary-search-tree-value/description/)
 *
 * @Difficulty=Medium
 */
class BinaryTreeRightSideView {

    fun rightSideViewBfs(root: TreeNode?): List<Int> {
        val rightSideViewList = mutableListOf<Int>()
        if (root == null) return rightSideViewList

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                if (i == 0) {
                    rightSideViewList.add(node.`val`)
                }

                node.right?.let { queue.add(it) }
                node.left?.let { queue.add(it) }
            }
        }

        return rightSideViewList
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */
