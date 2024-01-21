package binarytree

import bst.TreeNode

class LowestCommonAncestorOfDeepestLeaves {
    fun lcaDeepestLeavesBFS(root: TreeNode?): TreeNode? {
        var queue = ArrayDeque<TreeNode>()
        var parents = mutableMapOf<TreeNode, TreeNode>()
        var deepestLeaves = mutableListOf<TreeNode>()

        root?.let { queue.add(it) }

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            deepestLeaves.clear()

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                deepestLeaves.add(node)

                node.left?.also {
                    parents[it] = node
                    queue.add(it)
                }

                node.right?.also {
                    parents[it] = node
                    queue.add(it)
                }
            }
        }

        while (deepestLeaves.size > 1) {
            val newLeaves = mutableSetOf<TreeNode>()
            for (leaf in deepestLeaves) {
                parents[leaf]?.also { newLeaves.add(it) }
            }
            deepestLeaves = newLeaves.toMutableList()
        }

        return deepestLeaves.first()
    }
}
