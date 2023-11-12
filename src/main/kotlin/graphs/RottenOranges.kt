package graphs

/**
 * [994. Rotten Oranges](https://leetcode.com/problems/rotting-oranges/description/)
 *
 * @Difficulty=Medium
 */
class RottenOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {

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
}
// Solution
/**
 * @Time_Complexity=O(m*n) where m = rows n = columns
 */