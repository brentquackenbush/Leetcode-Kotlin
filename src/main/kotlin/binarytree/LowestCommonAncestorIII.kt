package binarytree

import bst.TreeNode

/**
 * [1650. Lowest Common Ancestor of a Binary Tree III](https://leetcode
 * .com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/)
 *
 * @Difficulty=Medium
 */
class LowestCommonAncestorIII {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        val ancestors = mutableSetOf<Node>()

        var current = p
        while(current != null) {
            ancestors.add(current)
            current = current.parent
        }

        current = q
        while(current != null) {
            if(ancestors.contains(current)) return current
            current = current.parent
        }

        return null
    }
    // Definition for a Node.
      data class Node(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        var parent: Node? = null
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */