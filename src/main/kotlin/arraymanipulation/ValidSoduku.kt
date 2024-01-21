package arraymanipulation

/**
 * [36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/description/)
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * @Difficulty=Medium
 */
class ValidSoduku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // Keep track of the rows
        // Keep track of the columns
        // Keep track of the 3 by 3 indexed boxes.

        val rows = Array(9) { HashSet<Char>() }
        val col = Array(9) { HashSet<Char>() }
        val boxes = Array(9) { HashSet<Char>() }

        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                val num = board[i][j]
                if (num != '.') {
                    var boxIndex = (i / 3) * 3 + (j / 3)
                    if (num in rows[i] || num in col[j] || num in boxes[boxIndex]) {
                        return false
                    }

                    rows[i].add(num)
                    col[j].add(num)
                    boxes[boxIndex].add(num)
                }
            }
        }
        return true
    }
}
// Solution
/**
 * @Time_Complexity=O(n^2) This is due to the HashSet lookup being O(1)
 */
