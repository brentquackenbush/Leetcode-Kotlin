package graphs

/**
 * [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/description/)
 *
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string
 * that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer
 * for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
 * and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined
 * for them.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0],
 * queries = [["a","c"],["b","a"],["a","e"],["a","a"], ["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 *
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 *
 * @Difficulty=Medium
 */
class EvaluateDivision {

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = buildGraph(equations, values)
        return queries.map { query -> dfs(query[0], query[1], graph, mutableSetOf()) }.toDoubleArray()
    }

    private fun buildGraph(equations: List<List<String>>, values: DoubleArray): Map<String, MutableMap<String, Double>> {
        val graph = mutableMapOf<String, MutableMap<String, Double>>()
        for ((index, equation) in equations.withIndex()) {
            val (dividend, divisor) = equation
            graph.computeIfAbsent(dividend) { mutableMapOf() }[divisor] = values[index]
            graph.computeIfAbsent(divisor) { mutableMapOf() }[dividend] = 1.0 / values[index]
        }
        return graph
    }

    private fun dfs(src: String, dest: String, graph: Map<String, MutableMap<String, Double>>, visited: MutableSet<String>): Double {
        if (!graph.containsKey(src)) return -1.0
        if (src == dest) return 1.0
        visited.add(src)
        graph[src]?.forEach { (neighbor, value) ->
            if (!visited.contains(neighbor)) {
                val product = dfs(neighbor, dest, graph, visited)
                if (product != -1.0) {
                    return value * product
                }
            }
        }
        return -1.0
    }
}
// Solution
/**
 * @Time_Complexity= Combining graph construction and query processing, the total time complexity is O(N) + O(M * V).
 * In scenarios where the number of equations (N) is roughly proportional to the number of variables (V),
 * this could be simplified to O(M * V).
 */