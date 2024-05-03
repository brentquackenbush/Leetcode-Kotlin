package graphs

/**
 * [934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/description/)
 *
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 * @Difficulty=Medium
 */
class ShortestBridge {
    fun shortestBridge(grid: Array<IntArray>): Int {
        val n = grid.size
        val queue = ArrayDeque<Pair<Int,Int>>()
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        fun dfs(row: Int, col: Int) {
            if(row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != 1) return

            grid[row][col] = 2
            queue.add(row to col)
            for((x, y) in directions) {
                dfs(row + x, col + y)
            }
        }

        loop@ for(i in 0 until n) {
            for(j in 0 until n) {
                if(grid[i][j] == 1) {
                    dfs(i, j)
                    break@loop
                }
            }
        }

        var steps = 0
        while(queue.isNotEmpty()) {
            val nextSize = queue.size
            for(i in 0 until nextSize) {
                val (row, col) = queue.removeFirst()

                for((x, y) in directions) {
                    val rowx = row + x
                    val coly = col + y
                    if(rowx < 0  || coly < 0 || rowx >= n || coly >= n || grid[rowx][coly] == 2) continue
                    if(grid[rowx][coly] == 1) return steps
                    if(grid[rowx][coly] == 0) {
                        grid[rowx][coly] = 2
                        queue.add(rowx to coly)
                    }
                }
            }
            steps++
        }

        return -1
    }
}
// Solution
/**
 * @Time_Complexity=O(n^2)
 */