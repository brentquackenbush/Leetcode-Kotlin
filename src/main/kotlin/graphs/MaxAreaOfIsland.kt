package graphs

import java.util.*

/**
 * [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
 *
 * @Difficulty=Medium
 */
class MaxAreaOfIsland {

    fun maxAreaOfIslandDFS(grid: Array<IntArray>): Int {
        var maxArea = 0
        val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        fun dfs(r: Int, c: Int): Int {
            if (r !in grid.indices || c !in grid[0].indices || grid[r][c] == 0) {
                return 0
            }

            grid[r][c] = 0 // Mark as visited
            var area = 1

            directions.forEach { (dr, dc) ->
                area += dfs(r + dr, c + dc)
            }

            return area
        }

        grid.indices.forEach { i ->
            grid[0].indices.forEach { j ->
                if (grid[i][j] == 1) {
                    maxArea = maxOf(maxArea, dfs(i, j))
                }
            }
        }

        return maxArea
    }

    fun maxAreaOfIslandBFS(grid: Array<IntArray>): Int {
        var maxArea = 0
        val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        fun bfs(r: Int, c: Int): Int {
            var area = 0
            queue.add(r to c)
            grid[r][c] = 0 // Mark as visited

            while (queue.isNotEmpty()) {
                val size = queue.size
                area += size

                repeat(size) {
                    val (row, col) = queue.poll()

                    directions.forEach { (dr, dc) ->
                        val newRow = row + dr
                        val newCol = col + dc

                        if (newRow in grid.indices && newCol in grid[0].indices && grid[newRow][newCol] == 1) {
                            queue.add(newRow to newCol)
                            grid[newRow][newCol] = 0 // Mark as visited
                        }
                    }
                }
            }

            return area
        }

        grid.indices.forEach { i ->
            grid[0].indices.forEach { j ->
                if (grid[i][j] == 1) {
                    maxArea = maxOf(maxArea, bfs(i, j))
                }
            }
        }

        return maxArea
    }
}
// Solution
/**
 * @Time_Complexity=O(m*n)
 * m = rows, n = columns
 *
 * Used local functions for this solution. Is this readable? You decide.
 */
