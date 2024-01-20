package binarytree

import bst.TreeNode
/**
 * [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)
 *
 * @Difficulty=Easy
 */
class MinimumDepthOfBinaryTree {
    fun minDepthBfs(root: TreeNode?): Int {
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

//    fun minDepthDfs(root: TreeNode?): Int {
//        if(root == null) return 0
//        var left = minDepth(root.left)
//        var right = minDepth(root.right)
//
//        return if(left == 0 || right == 0) left + right + 1 else minOf(left,right) + 1
//    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */