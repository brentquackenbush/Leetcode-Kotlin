package binarytree

import bst.TreeNode

/**
 * [1161. Maximum Level Sum of a Binary Tree](https://leetcode
 * .com/problems/maximum-level-sum-of-a-binary-tree/description/)
 *
 * @Difficulty=Medium
 */
class MaximumLevelSumOfBinaryTree {
    fun maxLevelSumBfs(root: TreeNode?): Int {
        var levelCounter = 1

        val queue = ArrayDeque<TreeNode>()
        queue.add(root!!)
        var maxSum = root.`val`
        var maxLevel = levelCounter

        while(queue.isNotEmpty()) {
            val levelSize = queue.size
            var levelSum = 0
            for(i in 0 until levelSize) {
                val node = queue.removeFirst()
                levelSum += node.`val`

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            if(maxSum < levelSum) {
                maxLevel = levelCounter
                maxSum = levelSum
            }
            levelCounter++
        }
        return maxLevel
    }

    // Pre-order traversal
    fun maxLevelSumDfs(root: TreeNode?): Int {
        val levelSums = mutableListOf<Int>()
        dfs(root, 0, levelSums)

        return levelSums.indices.maxByOrNull { levelSums[it] }!! + 1
    }

    fun dfs(node: TreeNode?, level: Int, levelSums: MutableList<Int>) {
        if (node == null) return

        if (levelSums.size <= level) {
            levelSums.add(node.`val`)
        } else {
            levelSums[level] += node.`val`
        }

        dfs(node.left, level + 1, levelSums)
        dfs(node.right, level + 1, levelSums)
    }
}
// Solution
/**
 * @Time_Complexity=O(n) go through every node to get sum of level.
 */