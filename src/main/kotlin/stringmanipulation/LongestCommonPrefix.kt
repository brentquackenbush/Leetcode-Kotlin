package stringmanipulation

/**
 * [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description/)
 *
 * @Difficulty=Easy
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        strs.sort()
        val firstStr = strs[0]
        val lastStr = strs[strs.size - 1]
        var count = 0
        while (count < firstStr.length && count < lastStr.length) {
            if (firstStr[count] == lastStr[count]) {
                count++
            } else {
                break
            }
        }

        return firstStr.substring(0, count)
    }
}
// Solution
/**
 * @Time_Complexity=O(NMlogN) where N is the number of strings inside the array and M is the longest string length.
 */
