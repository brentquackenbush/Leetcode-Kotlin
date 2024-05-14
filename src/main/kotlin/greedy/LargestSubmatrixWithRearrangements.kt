package greedy

/**
 * [1727. Largest Submatrix With Rearrangements](https://leetcode
 * .com/problems/largest-submatrix-with-rearrangements/description/)
 *
 * @Difficulty=Medium
 */
class LargestSubmatrixWithRearrangements {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size

        var ans = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                // Only stack if the current cell is 1
                if (matrix[i][j] != 0 && i > 0) {
                    matrix[i][j] += matrix[i - 1][j]
                }
            }

            // Clone and sort the row to simulate column rearrangements
            val curRow = matrix[i].clone()
            curRow.sort()

            // Calculate the max area possible with sorted heights
            for (r in 0 until n) {
                val height = curRow[r]
                val width = n - r  // all columns from index r to n-1 can form the submatrix
                ans = maxOf(ans, height * width)
            }
        }

        return ans
    }
}
// Solution
/**
 * @Time_Complexity=O(m * nlogn)
 */
