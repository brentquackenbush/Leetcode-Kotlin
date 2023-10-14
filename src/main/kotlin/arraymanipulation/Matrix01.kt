package arraymanipulation

import java.util.*

/**
 * [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)
 *
 * @Difficulty=Medium
 */
class Matrix01 {

    /**
     * Two-Pass algorithm.
     */
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val rows = mat.size
        val cols = mat[0].size
        val result = Array(rows) { IntArray(cols) { Int.MAX_VALUE - 1 } }  // Initialize with large values

        // First pass: check for left and top neighbors
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0
                } else {
                    if (i > 0) result[i][j] = minOf(result[i][j], result[i - 1][j] + 1)
                    if (j > 0) result[i][j] = minOf(result[i][j], result[i][j - 1] + 1)
                }
            }
        }

        // Second pass: check for right and bottom neighbors
        for (i in rows - 1 downTo 0) {
            for (j in cols - 1 downTo 0) {
                if (i < rows - 1) result[i][j] = minOf(result[i][j], result[i + 1][j] + 1)
                if (j < cols - 1) result[i][j] = minOf(result[i][j], result[i][j + 1] + 1)
            }
        }

        return result
    }

    fun updateMatrixBfs(matrix: Array<IntArray>): Array<IntArray> {
        val m = matrix.size
        val n = matrix[0].size
        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        // Enqueue all zeros and mark all ones as unvisited (-1)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    queue.offer(Pair(i, j))
                } else {
                    matrix[i][j] = -1
                }
            }
        }

        // BFS traversal to update distances
        while (queue.isNotEmpty()) {
            val cell = queue.poll()
            val i = cell.first
            val j = cell.second
            for (dir in dirs) {
                val x = i + dir[0]
                val y = j + dir[1]
                if (x in 0 until m && y in 0 until n && matrix[x][y] == -1) {
                    matrix[x][y] = matrix[i][j] + 1
                    queue.offer(Pair(x, y))
                }
            }
        }

        return matrix
    }
}
// Solution
/**
 * @Time_Complexity=O(m*n) Have to go through the entire matrix
 * Matrix.size = m (rows) x n (columns)
 */