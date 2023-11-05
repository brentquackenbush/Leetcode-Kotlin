package twopointers

/**
 * [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)
 *
 * @Difficulty=
 */
class LongestPalindromicString {

    // We need to keep track of the current longest palindrom and the current longest length
    // we can use the current length max to optimize our algorithm to only grab the substring of r and l (right and left points)(two pointers)
    // also checking odd and even palindromes.
    fun longestPalindrome(s: String): String {
        if(s.length == 1) return s

        var result = ""
        var resultLen = 0

        fun findLongest(l: Int, r: Int) {
            var r = r
            var l = l
            while(l >= 0 && r < s.length && s[l] == s[r]) {
                if(r - l + 1 > resultLen) {
                    resultLen = r - l + 1
                    result = s.substring(l, r + 1)
                }
                l--
                r++
            }
        }

        for(i in 0 until s.length) {
            findLongest(i,i)
            findLongest(i, i + 1)
        }

        return result
    }
}
// Solution
/**
 * @Time_Complexity:O(n) 
 */