package stringmanipulation
/**
 * [616. Add Bold Tag in String](https://leetcode.com/problems/add-bold-tag-in-string/description/)
 *
 * @Difficulty=Medium
 */
class AddBoldTagInString {
    fun addBoldTag(s: String, words: Array<String>): String {
        val sb = StringBuilder()
        // Start of bold word
        var lastLog = 0
        // End of bold word
        var end = -1
        for(start in s.indices) {
            for(word in words) {
                if(s.startsWith(word, start)) {
                    end = maxOf(end, start + word.length)
                }
            }

            if(start == end) {
                sb.append("<b>${s.substring(lastLog, end)}</b>")
            }

            if(start >= end) {
                sb.append(s[start])
                lastLog = start + 1
            }
        }

        if(end >= s.length) {
            sb.append("<b>${s.substring(lastLog)}</b>")
        }

        return sb.toString()
    }
}
// Solution
/**
 * @Time_Complexity=O(n * m * k)
 * n is the length of the string s.
 * m is the number of words in the words array.
 * k is the average length of the words in the words array.
 */
