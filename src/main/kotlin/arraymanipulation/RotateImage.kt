package arraymanipulation

/**
 *[48. Rotate Image](https://leetcode.com/problems/rotate-image/description/)
 * @Difficulty=Medium
 */
class RotateImage {

    fun rotate90Degrees(matrix: Array<IntArray>): Unit {

        val n = matrix.size

        for(i in 0 until n) {
            for(j in i until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for(i in 0 until n) {
            matrix[i].reverse()
        }
    }
}
/**
 * @Time_Complexity:O(n^2)
 *
 * The algorithm to rotate a matrix 90 degrees is to transpose it, and then reverse the rows.
 * So then to rotate the mateix counter-clockwise would be to reverse the rows first and then transpose it.
 */