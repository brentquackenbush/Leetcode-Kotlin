package stack

/**
 * [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/description/)
 *
 * @Difficulty=Medium
 */
class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backtracking(result, n, StringBuilder(""), 0, 0)
        return result
    }

    private fun backtracking(result: MutableList<String>, n: Int, curString: StringBuilder, leftCount: Int, rightCount: Int) {
        if(curString.length == n * 2) {
            result.add(curString.toString())
            return
        }

        if(leftCount < n) {
            curString.append("(")
            backtracking(result, n, curString, leftCount + 1, rightCount)
            curString.deleteAt(curString.length - 1)
        }

        if(leftCount > rightCount) {
            curString.append(")")
            backtracking(result, n, curString, leftCount, rightCount + 1)
            curString.deleteAt(curString.length - 1)
        }
    }
}
// Solution
/**
 * @Time_Complexity=O(2^(2n))
 */
