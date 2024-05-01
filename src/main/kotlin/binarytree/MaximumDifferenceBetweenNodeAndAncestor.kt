package binarytree

import bst.TreeNode

/**
 * [1026. Maximum Difference Between Node and Ancestor](https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/)
 *
 * @Difficulty=Medium
 */
class MaximumDifferenceBetweenNodeAndAncestor {
    fun maxAncestorDiff(root: TreeNode?): Int {
        if(root == null) return -1

        fun dfs(node: TreeNode?, max: Int, min: Int): Int {
            if(node == null) return max - min

            val currentMin = minOf(min, node.`val`)
            val currentMax = maxOf(max, node.`val`)

            val leftSubtree = dfs(node.left, currentMax, currentMin)
            val rightSubtree = dfs(node.right, currentMax, currentMin)

            return maxOf(leftSubtree, rightSubtree)
        }

        return dfs(root, root.`val`, root.`val`)
    }
}
// Solution
/**
 * @Time_Complexity=O(n) as we traverse through every node in the binary tree
 * @Space_Complexity=O(n) where h is the height of tree as are using stack space of h. n is the worst case scenario
 */
