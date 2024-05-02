package graphs

/**
 * [694. Number of Distinct Islands](https://leetcode.com/problems/number-of-distinct-islands/description/)
 *
 * @Difficulty=Medium
 */
class NumberOfDirectIslands {
    fun numDistinctIslands(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) { false} }
        val distinctIslands = mutableSetOf<String>()

        fun dfs(row: Int, col: Int, path: StringBuilder, dir: Char) {
            if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || grid[row][col] != 1) return

            visited[row][col] = true
            path.append(dir)

            dfs(row + 1, col, path, 'D') // Move down
            dfs(row - 1, col, path, 'U') // Move up
            dfs(row, col + 1, path, 'R') // Move right
            dfs(row, col - 1, path, 'L') // Move left

            path.append('B')
        }

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    val path = StringBuilder()
                    dfs(i,j, path, 'S')
                    distinctIslands.add(path.toString())
                }
            }
        }

        return distinctIslands.size
    }
}
// Solution
/**
 * @Time_Complexity=O(m*n) m = row n = columns
 */
