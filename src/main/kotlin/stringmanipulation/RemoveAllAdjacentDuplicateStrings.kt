package stringmanipulation

/**
 * [1047. Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/)
 *
 * @Difficulty=Easy
 */
class RemoveAllAdjacentDuplicateStrings {
    fun removeDuplicates(s: String): String {

        val sb = StringBuilder()
        var sbLength = 0
        for(ch in s) {
            if(sbLength != 0 && sb[sb.lastIndex] == ch) {
                sb.deleteCharAt(sb.lastIndex)
                sbLength--
            } else {
                sb.append(ch)
                sbLength++
            }
        }

        return sb.toString()
    }
}
// Solution
/**
 * @Time_Complexity=O(N)
 */
