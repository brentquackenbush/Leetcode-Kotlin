package graphs

/**
 * [207. Course Schedule](https://leetcode.com/problems/course-schedule/)
 *
 * @Difficulty=Medium
 */
class CourseSchedule {

    fun canFinishDfs(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val visited = mutableMapOf<Int, Int>()

        for (prerequisite in prerequisites) {
            graph.computeIfAbsent(prerequisite[1]) { mutableListOf<Int>() }.add(prerequisite[0])
        }

        for (course in 0 until numCourses) {
            if (!dfs(course, visited, graph)) {
                return false
            }
        }

        return true
    }

    fun dfs(node: Int, visited: MutableMap<Int, Int>, graph: MutableMap<Int, MutableList<Int>>): Boolean {
        if (visited[node] == 1) return false
        if (visited[node] == 2) return true

        visited[node] = 1
        graph[node]?.let {
            for (neighbor in it) {
                if (!dfs(neighbor, visited, graph)) return false
            }
        }

        visited[node] = 2

        return true
    }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val matrix = Array(numCourses) { IntArray(numCourses) } // i -> j
        val indegree = IntArray(numCourses)

        for (prerequisite in prerequisites) {
            val ready = prerequisite[0]
            val pre = prerequisite[1]
            if (matrix[pre][ready] == 0) {
                indegree[ready]++ // Handle duplicate case
            }
            matrix[pre][ready] = 1
        }

        var count = 0
        val queue = ArrayDeque<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0) queue.addLast(i)
        }

        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            count++
            for (i in 0 until numCourses) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.addLast(i)
                    }
                }
            }
        }

        return count == numCourses
    }
}
/**
 * @Time_Complexity=O(m*n)
 * m = rows, n = columns
 *
 * Used local functions for this solution. Is this readable? You decide.
 */
