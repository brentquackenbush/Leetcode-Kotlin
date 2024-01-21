package graphs

/**
 * [1136. Parallel Courses](https://leetcode.com/problems/parallel-courses/description/)
 *
 * NOTE: Pretty good problem to learn bfs, dfs, topological sorting.
 *
 * @Difficulty=Medium
 */
class ParallelCourses {
    fun minimumSemestersBfs(n: Int, relations: Array<IntArray>): Int {
        val inDegree = IntArray(n) { 0 }
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }

        for (relation in relations) {
            val (prevCourse, nextCourse) = relation
            // The -1 is to adjust for 0-based indexing
            graph[prevCourse - 1].add(nextCourse - 1)
            inDegree[nextCourse - 1]++
        }

        val queue = ArrayDeque<Int>()
        for (i in 0 until n) {
            if (inDegree[i] == 0) queue.add(i)
        }

        var visitedCount = 0
        var semesters = 0

        while(queue.isNotEmpty()) {
            for(i in 0 until queue.size) {
                val course = queue.removeFirst()

                visitedCount++
                for(next in graph[course]) {
                    inDegree[next]--
                    if(inDegree[next] == 0) queue.add(next)
                }
            }
            semesters++
        }
        return if(visitedCount == n) semesters else -1
    }

    fun minimumSemestersDfs(N: Int, relations: Array<IntArray>): Int {
        val graph = List(N + 1) { mutableListOf<Int>() }
        for (relation in relations) {
            val (prevCourse, nextCourse) = relation
            graph[prevCourse].add(nextCourse)
        }
        val visited = IntArray(N + 1)

        var maxLength = 1
        for (node in 1 until N + 1) {
            val length = dfs(node, graph, visited)
            if (length == -1) { // Cycle detected
                return -1
            }
            maxLength = maxOf(length, maxLength)
        }
        return maxLength
    }

    private fun dfs(node: Int, graph: List<List<Int>>, visited: IntArray): Int {
        if (visited[node] != 0) {
            return visited[node]
        }
        visited[node] = -1 // Mark as visiting
        var maxLength = 1
        for (endNode in graph[node]) {
            val length = dfs(endNode, graph, visited)
            if (length == -1) { // Cycle detected
                return -1
            }
            maxLength = maxOf(length + 1, maxLength)
        }
        visited[node] = maxLength // Mark as visited
        return maxLength
    }

}
// Solution
/**
 * Adjacency List
 * An adjacency list represents a graph as a list of lists (or an array of lists). Each index in the main list corresponds to a vertex in the graph, and each sublist contains the vertices adjacent to that vertex.
 *
 * Pros:
 *
 * Space Efficiency for Sparse Graphs: If the graph is sparse (i.e., the number of edges is much less than the square of the number of vertices), an adjacency list is more space-efficient.
 * Faster Iteration Over Neighbors: Iterating over the neighbors of a vertex is efficient as you only traverse the adjacent vertices.
 *
 * Cons:
 *
 * Slower Edge Lookups: Checking if an edge exists between two vertices can be slower, as it may require a linear search through a vertex's neighbor list.
 * Fixed Vertex IDs: The vertices are often assumed to be numbered from 0 to N-1, which might not always be convenient or applicable.
 * -----------------------------
 * Adjacency Map
 * An adjacency map uses a map (like HashMap in Kotlin), where each key is a vertex, and the value is another map or a list representing the adjacent vertices and possibly the weights of the edges.
 *
 * Pros:
 *
 * Flexible Vertex IDs: You can use more complex or non-sequential types as vertex identifiers.
 * Faster Edge Lookups: Checking for the existence of an edge is faster (often O(1) with a HashMap) since you can directly access the adjacency of the vertex.
 * Cons:
 *
 * More Space for Sparse Graphs: For sparse graphs, an adjacency map can be less space-efficient, especially if the map object overhead is significant.
 * Potential Overhead: The overhead of managing hash tables (in case of HashMaps) can make operations slightly slower, especially for graphs with a small number of vertices or edges.
 *
 * -------------------------------------
 * In the Context of the "Parallel Courses" Problem
 * The problem deals with course prerequisites, which likely forms a sparse graph (not every course is a prerequisite for many others).
 * The primary operations are iterating over the neighbors (to explore course dependencies) and not checking for the existence of specific edges.
 * The courses are numbered from 1 to N, fitting well into a list-based structure where indexing is straightforward
 *
 * @Time_Complexity=O(v + e)
 */