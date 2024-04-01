package graphs

/**
 * [419. Battleships in a Board](https://leetcode.com/problems/battleships-in-a-board/description/)
 *
 * @Difficulty=Medium
 */
class BattheshipsInABoard {
    fun countBattleships(board: Array<CharArray>): Int {
        val M = board.size
        val N = board[0].size

        var count = 0
        for(i in 0 until M) {
            for(j in 0 until N) {
                if(board[i][j] != 'X') continue
                if(i > 0 && board[i - 1][j] == 'X') continue
                if(j > 0 && board[i][j - 1] == 'X') continue

                count++
            }
        }

        return count
    }
}
// Solution
/**
 * @Time_Complexity=O(m*n) m = rows n = columns.
 */
