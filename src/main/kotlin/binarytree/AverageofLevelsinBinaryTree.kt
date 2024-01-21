package binarytree

import bst.TreeNode

/**
 * [637. Average of levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/description/)
 *
 * @Difficulty=Easy
 */
class AverageofLevelsinBinaryTree {
    fun averageOfLevelsDfs(root: TreeNode?): DoubleArray {
        val sum = mutableListOf<Long>()
        val count = mutableListOf<Int>()

        fun dfs(node: TreeNode?, level: Int) {
            if (node == null) return

            if (level < sum.size) {
                sum[level] = sum[level] + node.`val`
                count[level] = count[level] + 1
            } else {
                sum.add(node.`val`.toLong())
                count.add(1)
            }

            dfs(node.left, level + 1)
            dfs(node.right, level + 1)
        }
        dfs(root, 0)
        return sum.zip(count) { s, c -> s.toDouble() / c.toDouble() }.toDoubleArray()
    }

    fun averageOfLevelsBfs(root: TreeNode?): DoubleArray {
        val averageValueAtEachLevel = mutableListOf<Double>()
        val queue = ArrayDeque<TreeNode>()

        // Return if root is null
        root ?: return averageValueAtEachLevel.toDoubleArray()

        queue.add(root)
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var sum: Double = 0.0
            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                sum += node.`val`

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            averageValueAtEachLevel.add(sum / levelSize)
        }
        return averageValueAtEachLevel.toDoubleArray()
    }
}
// Solution
/**
 * @Time_Complexity=O(n) We go through every node level by level in order to get the sum of each level for BFS, DFS
 * we use the function argument to contain what level we are at and also a data structure called count to count the
 * number of nodes at each level.
 */
