package dynamicprogramming

/**
 * [221. Maximal Square](https://leetcode.com/problems/maximal-square/description/)
 *
 * @Difficulty=Medium
 */
class MaximalSquare {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val row = matrix.size
        val col = matrix[0].size
        val maxSquareMatrix = Array(row + 1) { IntArray(col + 1) }
        var maxSquare = 0
        for(i in 1..row) {
            for(j in 1..col) {
                if(matrix[i-1][j-1] == '1') {
                    maxSquareMatrix[i][j] = minOf(maxSquareMatrix[i][j-1], maxSquareMatrix[i-1][j-1], maxSquareMatrix[i-1][j]) + 1
                    maxSquare = maxOf(maxSquare, maxSquareMatrix[i][j])
                }
            }
        }
        return maxSquare * maxSquare
    }
}
/**
 * @Time_Complexity=
 */