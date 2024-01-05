package binarytree

import bst.TreeNode


/**
 * [951. Flip Equivalent binary trees](https://leetcode.com/problems/flip-equivalent-binary-trees/description/)
 *
 * @Difficulty=Medium
 */
class FlipEquivalent {

    fun flipEquivalent(root1: TreeNode?, root2: TreeNode?): Boolean {
        if(root1 == null && root2 == null) return true

        if(root1 == null || root2 == null || root1.`val` != root2.`val`) return false

        val withoutFlip = flipEquivalent(root1.left, root2.left) && flipEquivalent(root1.right, root2. right)
        val withFlip = flipEquivalent(root1.left, root2.right) && flipEquivalent(root1.right, root2.left)

        return withFlip || withoutFlip
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */
