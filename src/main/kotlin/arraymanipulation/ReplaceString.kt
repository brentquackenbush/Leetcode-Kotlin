package arraymanipulation

/**
 * [833. Find And Replace in String](https://leetcode.com/problems/find-and-replace-in-string/)
 *
 * @Difficulty=Medium
 */
class ReplaceString {

    fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String {
        val replacements = indices.indices.sortedByDescending { indices[it] }
        val result = StringBuilder(s)

        for (i in replacements) {
            val source = sources[i]
            val target = targets[i]
            val index = indices[i]

            if (s.substring(index).startsWith(source)) {
                result.replace(index, index + source.length, target)
            }
        }

        return result.toString()
    }
}
// Solution
/**
 * @Time_Complexity=O(k⋅log(k)+k⋅(2n+m))
 */
