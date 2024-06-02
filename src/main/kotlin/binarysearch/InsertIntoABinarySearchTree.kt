package binarysearch

import bst.TreeNode

/**
 * [701. Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/description/)
 *
 * @Difficulty=Medium
 */
class InsertIntoABinarySearchTree {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) return TreeNode(`val`)

        var node = root

        while(node != null) {
            if(`val` > node.`val`) {
                if(node.right == null) {
                    node.right = TreeNode(`val`)
                    return root
                } else {
                    node = node.right
                }
            } else {
                if(node.left == null) {
                    node.left = TreeNode(`val`)
                    return root
                } else {
                    node = node.left
                }
            }
        }
        return root
    }
}
// Solution
/**
 * @Time_Complexity=O(logn)
 */
