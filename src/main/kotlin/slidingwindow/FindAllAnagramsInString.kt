package slidingwindow

/**
 * [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
 *
 * @Difficulty=Medium
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
class FindAllAnagramsInString {

    /**
     * Brute Force Approach
     * The brute force approach involves generating all possible anagrams of the string p and checking each of them
     * in the string s. For each anagram, we search for occurrences in the string s.
     * This can be quite slow, especially when p is long.
     */
    fun bruteForceSolution(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pSorted = p.toCharArray().sorted()

        for (i in 0..s.length - p.length) {
            val sub = s.substring(i, i + p.length).toCharArray().sorted()
            if (sub == pSorted) {
                result.add(i)
            }
        }
        return result
    }

    fun solution(p: String, s: String): List<Int> {
        val result = mutableListOf<Int>()
        val pCounts = IntArray(26)
        val sCounts = IntArray(26)

        for (char in p) {
            pCounts[char - 'a']++
        }

        var windowStart = 0
        for (windowEnd in s.indices) {
            sCounts[s[windowEnd] - 'a']++
            if (windowEnd - windowStart + 1 == p.length) {
                if (pCounts.contentEquals(sCounts)) {
                    result.add(windowStart)
                }
                sCounts[s[windowStart] - 'a']--
                windowStart++
            }
        }
        return result
    }
}
// Solution
/**
 * @Time_Complexity:O(n)
 */
