package graphs
/**
 * [323. Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/)
 *
 * @Difficulty=Medium
 */
class NumberOfConnectedComponentsInAnUndirectedGraph {

    fun countComponentsNaive(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        var components = n
        for (e in edges) {
            val p1 = findParentNaive(parent, e[0])
            val p2 = findParentNaive(parent, e[1])
            if (p1 != p2) {
                parent[p1] = p2 // Union
                components--
            }
        }
        return components
    }

    private fun findParentNaive(parent: IntArray, i: Int): Int {
        var index = i
        while (index != parent[index]) index = parent[index]
        return index
    }

    fun countComponentsPathCompression(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        var components = n
        for (e in edges) {
            val p1 = findParentPathCompression(parent, e[0])
            val p2 = findParentPathCompression(parent, e[1])
            if (p1 != p2) {
                parent[p1] = p2 // Union
                components--
            }
        }
        return components
    }

    private fun findParentPathCompression(parent: IntArray, i: Int): Int {
        if (i == parent[i]) return i
        parent[i] = findParentPathCompression(parent, parent[i]) // Path compression
        return parent[i]
    }
    fun countComponentsPathCompressionAndUnionBySize(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        var components = n
        for (e in edges) {
            var p1 = findParentPathCompressionAndUnionBySize(parent, e[0])
            var p2 = findParentPathCompressionAndUnionBySize(parent, e[1])
            if (p1 != p2) {
                if (size[p1] < size[p2]) {
                    size[p2] += size[p1]
                    parent[p1] = p2
                } else {
                    size[p1] += size[p2]
                    parent[p2] = p1
                }
                components--
            }
        }
        return components
    }

    private fun findParentPathCompressionAndUnionBySize(parent: IntArray, i: Int): Int {
        if (i == parent[i]) return i
        parent[i] = findParentPathCompressionAndUnionBySize(parent, parent[i]) // Path compression
        return parent[i]
    }

    fun countComponentsDfs(n: Int, edges: Array<IntArray>): Int {
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        val visited = BooleanArray(n)
        return (0 until n).sumOf { dfs(it, graph, visited) }
    }

    private fun dfs(u: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): Int {
        if (visited[u]) return 0
        visited[u] = true
        for (v in graph[u]) dfs(v, graph, visited)
        return 1
    }
    fun countComponentsBfs(n: Int, edges: Array<IntArray>): Int {
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        val visited = BooleanArray(n)
        return (0 until n).sumOf { bfs(it, graph, visited) }
    }

    private fun bfs(src: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): Int {
        if (visited[src]) return 0
        visited[src] = true
        val q = ArrayDeque<Int>()
        q.add(src)
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            for (v in graph[u]) {
                if (!visited[v]) {
                    visited[v] = true
                    q.add(v)
                }
            }
        }
        return 1
    }
}
// Solution
/**
 * @Time_Complexity=
 *
 * Undirected Graph
 *  Whenever we solve for am undirected graph we have to build out an adjacency list, and we have to add the
 *  relationships both ways because there is no direction.
 *
 * BFS
 *  Whenever we utilize BFS for a graph problem, we traverse the closet neighbor and then handle our logic and then
 *  move onto the next neighbor. Also, it usually involves using a queue and looping until it is empty.
 */