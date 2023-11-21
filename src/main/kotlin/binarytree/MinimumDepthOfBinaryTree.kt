package binarytree

import bst.TreeNode
/**
 * [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)
 *
 * @Difficulty=Easy
 */
class MinimumDepthOfBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        if(root == null) return 0
        var depth = 1
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while(queue.isNotEmpty()) {
            val levelSize = queue.size
            for(i in 0 until levelSize) {
                val node = queue.removeFirst()
                if(node.left == null && node.right == null) return depth

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }

            }
            depth++
        }
        return depth
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */