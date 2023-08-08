package dynamicprogramming

/**
 * [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        return dp[m][n]
    }
}
//Solution
/**
 * @Time_Complexity: O(m*n), where m and n are the lengths of text1 and text2 respectively.
 * This is because we are using a 2D dynamic programming (DP) table of size m+1 by n+1,
 * and we have to fill up each cell in the table once. Each operation to fill the cell
 * is a constant time operation, hence the time complexity is proportional to the number
 * of cells, which is m*n.
 *
 * @Space_Complexity: O(m*n), where m and n are the lengths of text1 and text2 respectively.
 * This is due to the usage of the 2D DP table. The space used is proportional to the number
 * of cells in the table, which is m*n.
 */
