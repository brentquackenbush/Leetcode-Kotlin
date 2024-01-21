package binarysearch

import bst.TreeNode
import kotlin.math.abs

/**
 * [270. Closest Binary Search Tree Value](https://leetcode.com/problems/closest-binary-search-tree-value/description/)
 *
 * @Difficulty=Easy
 */
class ClosetBinarySearchTreeValue {
    fun closestValue(root: TreeNode?, target: Double): Int {
        var closetValue = root?.`val` ?: return -1
        var current = root

        while (current != null) {
            if (abs(target - current.`val`) < abs(target - closetValue) || (abs(target - current.`val`) == abs(target - closetValue) && current.`val` < closetValue)) {
                closetValue = current.`val`
            }

            current = if (current.`val` > target) {
                current.left
            } else {
                current.right
            }
        }
        return closetValue
    }
}
// Solution
/**
 * @Time_Complexity=O(h)
 */
