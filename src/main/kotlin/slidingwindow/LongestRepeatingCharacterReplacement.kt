package slidingwindow

/**
 * [424. Longest Repeating Character Replacement
 * ](https://leetcode.com/problems/longest-repeating-character-replacement/description/)
 *
 * @Difficulty=Medium
 */
class LongestRepeatingCharacterReplacement {

    fun characterReplacement(s: String, k: Int): Int {
        val map = mutableMapOf<Char, Int>()
        var windowStart = 0
        var maxCharOf = 0
        var maxLength = 0

        for (windowEnd in s.indices) {
            val currentChar = s[windowEnd]
            map[currentChar] = map.getOrElse(currentChar) { 0 } + 1
            maxCharOf = maxOf(maxCharOf, map[currentChar]!!)

            while (windowEnd - windowStart + 1 - maxCharOf > k) {
                val startChar = s[windowStart]
                map[startChar] = map[startChar]!! - 1
                windowStart++
            }

            maxLength = maxOf(maxLength, windowEnd - windowStart + 1)
        }
        return maxLength
    }
}
/**
 * @Time_Complexity=O(n)
 */
