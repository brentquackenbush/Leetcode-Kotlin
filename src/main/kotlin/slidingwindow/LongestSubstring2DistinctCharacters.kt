package slidingwindow

/**
 * [159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/)
 * @Difficulty=Medium
 */
class LongestSubstring2DistinctCharacters {

    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        if (s.length == 1) return 1
        val map = mutableMapOf<Char, Int>()

        var left = 0
        var maxLength = 0
        for (right in 0 until s.length) {
            val rc = s[right]
            map[rc] = map.getOrElse(rc) { 0 } + 1

            while (map.size > 2) {
                val lc = s[left]
                map[lc] = map.getOrElse(lc) { 0 } - 1
                if (map[lc] == 0) {
                    map.remove(lc)
                }
                left++
            }
            maxLength = maxOf(maxLength, right - left + 1)
        }
        return maxLength
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 * For Loop
 * The for loop iterates from 0 to n-1, where n is the length of the string. In each iteration,
 * you're doing constant-time operations: accessing characters from the string, inserting or updating
 * elements in the hash map, etc. Therefore, the time complexity of the for loop alone is
 * O(n).
 *
 * While Loop
 * The while loop looks tricky at first glance. It runs whenever the size of the map exceeds 2, removing the
 * leftmost character in the current window from the map and adjusting the left pointer.
 *
 * The key thing to notice is that each character in the string can enter the while loop at most once, and each
 * character can also exit it at most once. When it enters, it's added to the map, and when it exits, it's removed
 * from the map. So even though the while loop is nested inside the for loop, each character in the string only
 * triggers constant-time operations inside the while loop throughout the runtime of the algorithm.
 *
 * Overall Time Complexity
 * Both loops in combination still result in a linear-time complexity because each character in the string is
 * processed a constant number of times. Thus, the overall time complexity of the algorithm is
 *
 * O(n), where n is the length of the string.
 */