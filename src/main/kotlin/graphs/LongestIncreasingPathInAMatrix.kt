package graphs

/**
 * [329. Longest Increasing Path In A Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
 *
 * @Difficulty=Hard
 */
class LongestIncreasingPathInAMatrix {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val cache = Array(m) { IntArray(n) }
        var longestIncreasingPath = 0

        fun dfs(row: Int, col: Int, prevValue: Int): Int {
            if(row !in 0..<m || col !in 0..<n || prevValue >= matrix[row][col]) return 0
            if(cache[row][col] != 0) return cache[row][col]

            val left = dfs(row -1, col, matrix[row][col])
            val right = dfs(row + 1, col, matrix[row][col])
            val top = dfs(row, col - 1, matrix[row][col])
            val down = dfs(row, col + 1, matrix[row][col])

            cache[row][col] = 1 + maxOf(left, right, top, down)
            return cache[row][col]
        }

        for(i in 0 until m) {
            for(j in 0 until n) {
                longestIncreasingPath = maxOf(
                    longestIncreasingPath,
                    dfs(i, j, Int.MIN_VALUE)
                )
            }
        }

        return longestIncreasingPath
    }
}
// Solution
/**
 * @Time_Complexity=O(m*n) because of cache
<<<<<<< HEAD
 */
