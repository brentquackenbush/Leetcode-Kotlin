package graphs

import bst.TreeNode

/**
 * [2385. Amount of Time for Binary Tree to Be Infected](https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/)
 *
 * @Difficulty=Medium
 */
class AmountOfTimeForBinaryTreeToBeInfected {
    fun amountOfTimDfs(root: TreeNode?, start: Int): Int {
        if (root == null) return 0

        // Build graph from the tree
        val graph = mutableMapOf<Int, MutableList<Int>>()

        fun buildGraph(node: TreeNode?, parent: TreeNode?) {
            if (node == null) return
            if (!graph.containsKey(node.`val`)) {
                graph[node.`val`] = mutableListOf()
            }
            if (parent != null) {
                graph[node.`val`]!!.add(parent.`val`)
                graph[parent.`val`]!!.add(node.`val`)
            }
            buildGraph(node.left, node)
            buildGraph(node.right, node)
        }

        buildGraph(root, null)

        var maxTime = 0
        val visited = mutableSetOf<Int>()

        // Recursive DFS function
        fun dfs(node: Int, time: Int) {
            visited.add(node)
            maxTime = maxOf(maxTime, time)
            graph[node]?.forEach { neighbor ->
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, time + 1)
                }
            }
        }

        // Start DFS from the infected node
        dfs(start, 0)

        return maxTime
    }
    fun amountOfTimeBfs(root: TreeNode?, start: Int): Int {

        val graph = mutableMapOf<Int, MutableList<Int>>()

        fun buildGraph(node: TreeNode?, parent: TreeNode?) {
            if (node == null) return
            if (!graph.containsKey(node.`val`)) {
                graph[node.`val`] = mutableListOf<Int>()
            }
            if (parent != null) {
                graph[node.`val`]!!.add(parent.`val`)
                graph[parent.`val`]!!.add(node.`val`)
            }
            buildGraph(node.left, node)
            buildGraph(node.right, node)
        }

        buildGraph(root, null)

        val visited = mutableSetOf<Int>()
        val queue = ArrayDeque<Pair<Int,Int>>()
        queue.add(start to 0)
        visited.add(start)

        var maxTime = 0
        while(queue.isNotEmpty()) {
            val (current, curTime) = queue.removeFirst()
            maxTime = maxOf(maxTime, curTime)
            graph[current]?.forEach { neighbor ->
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    queue.add(neighbor to curTime + 1)
                }
            }
        }

        return maxTime
    }
}
// Solution
/**
 * @Time_Complexity=O(n) for amount of nodes in binary tree
 */
