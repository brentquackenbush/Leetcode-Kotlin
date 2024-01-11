package stringmanipulation

/**
 * [394. Decode String](https://leetcode.com/problems/decode-string/description/)
 *
 * @Difficulty=Medium
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
class DecodeString {

    fun decodeString(s: String): String {
        val numStack = ArrayDeque<Int>()
        val stringStack = ArrayDeque<String>()

        var curNum = 0
        var curStr = StringBuilder()

        for(ch in s) {
            when {
                ch.isDigit() -> {
                    curNum = curNum * 10 + (ch - '0')
                }
                ch == '[' -> {
                    numStack.addLast(curNum)
                    stringStack.addLast(curStr.toString())

                    curNum = 0
                    curStr = StringBuilder()
                }
                ch == ']' -> {

                    val repeatCount = numStack.removeLast()
                    val str = curStr.toString().repeat(repeatCount)
                    curStr = StringBuilder(stringStack.removeLast() + str)
                } else -> {
                    curStr.append(ch)
                }

            }
        }
        return curStr.toString()
    }
}
// Solution
/**
 * @Time_Complexity=n * maxK Each time a substring is repeated, it involves creating a new string with length up to
 * maxK times the length of the substring.
 */