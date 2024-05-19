package twopointers

/**
 * [408. Valid Word Abbreviation](https://leetcode.com/problems/valid-word-abbreviation/description/)
 *
 * 408. Valid Word Abbreviation
 * Solved
 * Easy
 * Topics
 * Companies
 * A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
 *
 * For example, a string such as "substitution" could be abbreviated as (but not limited to):
 *
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * The following are not valid abbreviations:
 *
 * "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 * "s010n" (has leading zeros)
 * "s0ubstitution" (replaces an empty substring)
 * Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
 *
 * A substring is a contiguous non-empty sequence of characters within a string.
 *
 * @Difficulty=Easy
 */
class ValidWordAbbreviation {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var i = 0
        var j = 0

        while(i < word.length && j < abbr.length) {
            if(abbr[j].isDigit()) {
                if(abbr[j] == '0') {
                    return false
                }
                var num = 0
                while(j < abbr.length && abbr[j].isDigit()) {
                    num = num * 10 + (abbr[j] - '0')
                    j++
                }
                i += num
            } else {
                if(word[i] != abbr[j]) return false

                i++
                j++
            }
        }

        return i == word.length && j == abbr.length
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */
