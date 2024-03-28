package binarytree

import bst.TreeNode

/**
 * [366. Find Leaves of Binary Tree](https://leetcode.com/problems/find-leaves-of-binary-tree)
 *
 * @Difficulty=Medium
 */
class FindLeavesOfABinaryTree {

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()

        val solution = mutableListOf<MutableList<Int>>()

        fun getHeight(node: TreeNode?): Int {
            if(node == null) return -1

            val leftHeight = getHeight(node.left)
            val rightHeight = getHeight(node.right)

            val currentHeight = 1 + maxOf(leftHeight, rightHeight)

            if(solution.size == currentHeight) {
                solution.add(mutableListOf())
            }

            solution[currentHeight].add(node.`val`)
            return currentHeight
        }
        getHeight(root)
        return solution
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */
