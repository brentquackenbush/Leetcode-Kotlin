package graphs

/**
 * [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/description/)
 *
 * @Difficulty=Medium
 */
class SurroundedRegions {
    fun solve(board: Array<CharArray>): Unit {

        val row = board.size
        val col = board[0].size

        // Check first and last column for 'O' and call 'checkRegions'
        for(i in 0 until row) {
            if(board[i][0] == 'O') checkRegions(board, i, 0)
            if(board[i][col - 1] == 'O') checkRegions(board, i, col - 1) // Corrected indices here
        }

        // Check first and last row for 'O' and call 'checkRegions'
        for(j in 0 until col) {
            if(board[0][j] == 'O') checkRegions(board, 0, j)
            if(board[row - 1][j] == 'O') checkRegions(board, row - 1, j)
        }

        // Flip all 'O's to 'X's and all '1's (which represent unchecked 'O's) back to 'O's
        for(i in 0 until row) {
            for(j in 0 until col) {
                if(board[i][j] == 'O') board[i][j] = 'X' // Flip surrounded 'O's to 'X's
                else if(board[i][j] == '1') board[i][j] = 'O' // Flip temporary '1's back to 'O's
            }
        }
    }

    private fun checkRegions(board: Array<CharArray>, row:Int, col: Int) {
        // Base case checks if index is out of bounds or if the cell is not 'O'
        if(row < 0 || col < 0 || row >= board.size || col >= board[0].size || board[row][col] != 'O') return

        // Mark the current region's 'O' as '1' to indicate it's checked and not surrounded
        board[row][col] = '1'
        // Recursively check adjacent cells
        checkRegions(board, row + 1, col)
        checkRegions(board, row - 1, col)
        checkRegions(board, row, col + 1)
        checkRegions(board, row, col - 1)
    }
}
// Solution
/**
 * @Time_Complexity=O(m*n) m = rows n = columns
 */