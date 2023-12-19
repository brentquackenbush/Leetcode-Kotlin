package stringmanipulation
/**
 * [271. Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/description/)
 *
 * @Difficulty=Medium
 *
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * You are not allowed to solve the problem using any serialize methods (such as eval).
 */
class EncodeDecode {

    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String {
        return strs.joinToString(separator = "") { "${it.length}#$it"}
    }

    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        val strs = mutableListOf<String>()
        var i = 0
        while(i < s.length) {
            val sharpIndex = s.indexOf("#", startIndex = i)
            val length = s.substring(i,sharpIndex).toInt()
            strs.add(s.substring(sharpIndex + 1, sharpIndex + 1 + length))
            i = sharpIndex + 1 + length
        }
        return strs
    }
}
// Solution
/**
 * @Time_Complexity=O(n) n is the length of s.
 *
 * Probably one of my more favorite problems to understand a protocol to encode and decode a string.
 */