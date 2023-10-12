package bst

/**
 * [814. Binary Tree Pruning](https://leetcode.com/problems/binary-tree-pruning/)
 *
 * @Difficulty=Medium
 */
class BinaryTreePruning {
    fun pruneTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)
        if(root.left==null && root.right==null && root.`val`==0) return null
        return root
    }
}
/**
 * @Time_Complexity:O(n) Using PostOrder.
 */