package stringmanipulation
/**
 * [2825. Make String a Subsequence Using Cyclic Increments](https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/)
 *
 * @Difficulty=Medium
 */
class MakeStringASubsequenceUsingCyclicIncrements {

    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        val l1 = str1.length
        val l2 = str2.length
        // You can't make a string a subsequence to a string smaller in length
        if (l2 > l1) return false

        var i = 0
        var j = 0
        while (i < l1 && j < l2) {
            val ch = if (str1[i] == 'z') 'a' else str1[i] + 1
            if (str1[i] == str2[j] || ch == str2[j]) {
                j++
            }
            i++
        }
        return j == l2
    }
}
// Solution
/**
 * @Time_Complexity= O(n) one pass using two strings n = length of str1
 */