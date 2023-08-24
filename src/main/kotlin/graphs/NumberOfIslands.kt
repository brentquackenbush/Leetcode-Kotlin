package graphs

/**
 * [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
 *
 * @Difficulty=Medium
 */
class NumberOfIslands {

    fun solution(grid: Array<CharArray>): Int {
        val row = grid.size
        val col = grid[0].size
        val visited = Array(row) { BooleanArray(col) }
        var count = 0

        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited)
                    count++
                }
            }
        }
        return count
    }

    fun dfs(grid: Array<CharArray>, row: Int, col: Int, visited: Array<BooleanArray>) {
        if (row < 0 || row >= grid.size || col >= grid[0].size || col < 0 || visited[row][col] || grid[row][col] == '0') return

        visited[row][col] = true

        dfs(grid, row + 1, col, visited)
        dfs(grid, row - 1, col, visited)
        dfs(grid, row, col + 1, visited)
        dfs(grid, row, col - 1, visited)
    }
}
// Solution
/**
 * @Time_Complexity: O(m * n) m = rows, n = cols
 */
