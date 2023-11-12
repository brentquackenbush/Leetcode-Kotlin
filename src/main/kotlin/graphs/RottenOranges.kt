package graphs

/**
 * [994. Rotten Oranges](https://leetcode.com/problems/rotting-oranges/description/)
 *
 * @Difficulty=Medium
 */
class RottenOranges {
    fun orangesRottingBfs(grid: Array<IntArray>): Int {

        val queue = ArrayDeque<Pair<Int,Int>>()
        var freshOranges = 0
        for(i in grid.indices) { // use grid.indices for better clarity
            for(j in grid[i].indices) { // use grid[i].indices for better clarity
                when (grid[i][j]) {
                    2 -> queue.add(i to j)
                    1 -> freshOranges++
                }
            }
        }
        var time = 0

        // Initialize directions correctly as an array of pairs
        val dirs = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

        // BFS traversal of the grid
        while(queue.isNotEmpty() && freshOranges > 0) { // Check for fresh oranges to avoid unnecessary loops
            val size = queue.size // Fix the current level size

            // Process all rotten oranges on the current level
            repeat(size) {
                val (row, col) = queue.removeFirst() // Use removeFirst for dequeuing
                for ((dx, dy) in dirs) {
                    val newRow = row + dx
                    val newCol = col + dy
                    // Check bounds and if the new cell is a fresh orange
                    if(newRow >= 0 && newCol >= 0 && newRow < grid.size && newCol < grid[0].size && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2 // Make the orange rotten
                        freshOranges--
                        queue.add(newRow to newCol) // Add the new rotten orange to the queue
                    }
                }
            }
            if (queue.isNotEmpty()) time++ // Increment minutes after each level if there are new rotten oranges
        }

        return if(freshOranges == 0) time else -1 // Return the time if no fresh orange left, else -1
    }
    fun orangesRottingDfs(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return -1

        // Start rotting process for each rotten orange found
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 2) rotAdjacent(grid, i, j, 2)
            }
        }

        // Find out the maximum time taken for any orange to rot, starting from 2
        var minutes = 2
        for (row in grid) {
            for (cell in row) {
                if (cell == 1) return -1 // If there's still a fresh orange, return -1
                minutes = maxOf(minutes, cell) // Find the maximum time taken from all cells
            }
        }

        return minutes - 2 // Subtract 2 to get the actual minutes count
    }

    private fun rotAdjacent(grid: Array<IntArray>, i: Int, j: Int, minutes: Int) {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0 || (1 < grid[i][j] && grid[i][j] < minutes)) {
            // If the cell is out of bounds, empty, or the orange is already rotten by another rotten orange, skip it
            return
        } else {
            grid[i][j] = minutes // Mark the current orange as rotten with the current timestamp
            // Recursively rot adjacent oranges with an incremented timestamp
            rotAdjacent(grid, i - 1, j, minutes + 1)
            rotAdjacent(grid, i + 1, j, minutes + 1)
            rotAdjacent(grid, i, j - 1, minutes + 1)
            rotAdjacent(grid, i, j + 1, minutes + 1)
        }
    }

}
// Solution
/**
 * @Time_Complexity=O(m*n) where m = rows n = columns
 */