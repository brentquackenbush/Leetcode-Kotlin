package bst

/**
 * [173. Binary-search-tree-iterator](https://leetcode.com/problems/binary-search-tree-iterator/description/)
 *
 * @Difficulty=Medium
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BSTIterator(root: TreeNode?) {

    private val stack = ArrayDeque<TreeNode>()

    init {
        pushAllLeft(root)
    }

    fun next(): Int {
        val currentNode = stack.removeLast()
        if (currentNode.right != null) {
            pushAllLeft(currentNode.right)
        }
        return currentNode.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

    private fun pushAllLeft(root: TreeNode?) {
        var currentNode = root
        while (currentNode != null) {
            stack.addLast(currentNode)
            currentNode = currentNode.left
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
/**
 * @Time_Complexity=O(1) on average, possible to go up to O(n) if the tree is skewed.
 */
