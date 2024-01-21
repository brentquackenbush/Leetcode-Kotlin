package graphs

/**
 * [133. Clone Graph](https://leetcode.com/problems/clone-graph/description/)
 *
 * @Difficulty=Medium
 */
class CloneGraph {

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList()
    }
    fun cloneGraph(node: Node?): Node? {
        val graph = mutableMapOf<Node, Node>()

        fun dfs(node: Node?): Node? {
            if (node == null) return null

            if (graph.containsKey(node)) {
                return graph[node]
            }

            val nodeCopy = Node(node.`val`)
            graph[node] = nodeCopy
            for (neighbor in node.neighbors) {
                nodeCopy.neighbors.add(dfs(neighbor))
            }

            return nodeCopy
        }

        val clone = dfs(node)
        return clone
    }
}
// Solution
/**
 * @Time_Complexity=O(m * n) N is a number of nodes (vertices) and M is a number of edges.
 */
