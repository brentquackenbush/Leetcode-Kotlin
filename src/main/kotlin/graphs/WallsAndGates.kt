package graphs

/**
 * [286. Walls and Gates](https://leetcode.com/problems/walls-and-gates/description/)
 *
 * @Difficulty=Medium
 */
class WallsAndGates {
    fun wallsAndGates(rooms: Array<IntArray>) {
        val INF = 2147483647
        val m = rooms.size
        val n = if (m > 0) rooms[0].size else 0
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()

        // Step 1: Enqueue all gates' positions.
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (rooms[i][j] == 0) {
                    queue.add(Pair(i, j))
                }
            }
        }

        // Directions array for up, right, down, left moves.
        val directions = arrayOf(Pair(0, -1), Pair(-1, 0), Pair(0, 1), Pair(1, 0))

        // Step 2: Process queue and propagate distances.
        while (queue.isNotEmpty()) {
            val point = queue.removeFirst()
            val row = point.first
            val col = point.second

            for (dir in directions) {
                val r = row + dir.first
                val c = col + dir.second

                // Continue if it's out of bounds, is a gate, or is not an INF room.
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != INF) continue

                rooms[r][c] = rooms[row][col] + 1 // Update distance.
                queue.add(Pair(r, c)) // Enqueue updated room.
            }
        }
    }
}
// Solution
/**
 * @Time_Complexity=
 */