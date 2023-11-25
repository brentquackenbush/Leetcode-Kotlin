package binarytree

import bst.TreeNode

/**
 * [2265. Count Nodes Equal to Average of Subtree](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/)
 *
 * @Difficulty=Medium
 */
class CountNodesEqualToAverageOfSubtree {
    fun averageOfSubtree(root: TreeNode?): Int {
        var count = 0

        fun dfs(node: TreeNode?): Pair<Int, Int> {
            if (node == null) return Pair(0, 0)

            val (leftSum, leftCount) = dfs(node.left)
            val (rightSum, rightCount) = dfs(node.right)

            val totalSum = node.`val` + leftSum + rightSum
            val totalCount = 1 + leftCount + rightCount
            val average = totalSum / totalCount

            if (node.`val` == average) count++

            return Pair(totalSum, totalCount)
        }

        dfs(root)
        return count
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */