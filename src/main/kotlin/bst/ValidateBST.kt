package bst

/**
 * [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
 *
 * @Difficulty=Medium
 */
class ValidateBST {

    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBSTSolver(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun isValidBSTSolver(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) return true

        if (root.`val` <= min || root.`val` >= max) return false

        return isValidBSTSolver(root.left, min, root.`val`.toLong()) &&
            isValidBSTSolver(root.right, root.`val`.toLong(), max)
    }
}
/**
 * @Time_Complexity= O(n)
 */
