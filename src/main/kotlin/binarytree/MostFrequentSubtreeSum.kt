package binarytree

import bst.TreeNode
/**
 * [508. Most Frequent Subtree Sum](https://leetcode.com/problems/most-frequent-subtree-sum/description/)
 *
 * @Difficulty=Medium
 */
class MostFrequentSubtreeSum {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val sumFrequencyMap = mutableMapOf<Int, Int>()

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val leftSubtreeSum = dfs(node.left)
            val rightSubtreeSum = dfs(node.right)

            val curSum = node.`val` + leftSubtreeSum + rightSubtreeSum
            sumFrequencyMap[curSum] = sumFrequencyMap.getOrDefault(curSum, 0) + 1

            return curSum
        }

        dfs(root)

        val maxFrequency = sumFrequencyMap.values.maxOrNull() ?: 0
        return sumFrequencyMap.filter { it.value == maxFrequency }.keys.toIntArray()
    }
}
// Solution
/**
 * @Time_Complexity=O(n) we go through every node once to calculate the sum
 *
 * What did I learn?
 *
 * Usually Binary Tree problems with subtrees use DFS. To calculate the sum of a subtree you calculate toe current
 * nodes value + calling the left and right children as a parameter in the function. You can use a map to keep track
 * of the pairing from sum to number of occurences. you can filter through a map.
 */