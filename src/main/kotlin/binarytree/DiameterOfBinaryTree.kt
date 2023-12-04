package binarytree

import bst.TreeNode
/**
 * [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/description/)
 *
 * @Difficulty=Easy
 */
class DiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var diameter = 0

        fun depth(root: TreeNode?): Int {
            if(root == null) return 0

            val leftDepth = depth(root.left)
            val rightDepth = depth(root.right)

            diameter = maxOf(diameter, leftDepth + rightDepth)

            return maxOf(leftDepth, rightDepth) + 1
        }

        depth(root)
        return diameter
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */