package slidingwindow

class LengthOfLongestSubstring {

    fun solution(s: String): Int {
        val seen = mutableSetOf<Char>()
        var lengthOfLongestSubstring = 0
        var start = 0

        s.forEachIndexed { index, c ->
            if (seen.contains(c)) {
                while (s[start] != c) {
                    seen.remove(s[start++])
                }
                start++
            }
            seen.add(c)
            lengthOfLongestSubstring = maxOf(lengthOfLongestSubstring, index - start + 1)
        }
        return lengthOfLongestSubstring
    }
}
/**
 * @Time_Complexity: O(n)
 *
 * Sliding window approach
 *
 * This code leverages the forEachIndexed function to iterate over the characters of the string, keeping track of the
 * index. The logic within the loop takes care of adding and removing characters from the seen set, adjusting the start
 * index when a repeating character is found, and updating the longest variable accordingly.
 *
 * start = pointer on the left of window
 * index = pointer on right of window
 */
