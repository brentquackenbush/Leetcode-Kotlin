package arraymanipulation

/**
 * [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/description/)
 *
 * @Difficulty=Medium
 */
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        if (matrix.size == 0 || matrix[0].size == 0) return result

        var top = 0
        var left = 0
        var right = matrix[0].size - 1
        var bottom = matrix.size - 1

        while (true) {
            // Go right
            for (i in left..right) result.add(matrix[top][i])
            top++
            if (left > right || top > bottom) break

            // Go down
            for (i in top..bottom) result.add(matrix[i][right])
            right--
            if (left > right || top > bottom) break

            // Go left
            for (i in right downTo left) result.add(matrix[bottom][i])  // corrected the loop
            bottom--
            if (left > right || top > bottom) break

            // Go up
            for (i in bottom downTo top) result.add(matrix[i][left])  // corrected the loop
            left++
            if (left > right || top > bottom) break
        }
        return result
    }
}
/**
 * @Time_Complexity=O(m*n) m = the row size and n is the column size
 * m = matrix.size      row
 * n = matrix[0].size   column
 */