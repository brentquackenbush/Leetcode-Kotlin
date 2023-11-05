package dynamicprogramming

/**
 * [62. Unique Paths](https://leetcode.com/problems/unique-paths/)
 *
 * @Difficulty=Medium
 */
class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val line = IntArray(n) { 1 }
        for (i in 0 until m - 1) {
            for (j in 0 until n) {
                if (j == 0) line[j] = 1
                else line[j] = line[j-1] + line[j]
            }
        }

        return line[n - 1]
    }
}
// Solution
/**
 * @Time_Complexity=O(m*n)
 */