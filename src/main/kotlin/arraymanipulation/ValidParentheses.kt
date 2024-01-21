package arraymanipulation

/**
 * [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/)
 *
 * @Difficulty=Easy
 */
class ValidParentheses {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (ch in s) {
            when (ch) {
                '(', '{', '[' -> stack.addLast(ch)
                ')' -> if (stack.isEmpty() || stack.removeFirst() != '(') return false
                '}' -> if (stack.isEmpty() || stack.removeFirst() != '{') return false
                ']' -> if (stack.isEmpty() || stack.removeFirst() != '[') return false
            }
        }
        return stack.isEmpty()
    }
}
/**
 * @Time_Complexity=O(n)
 */
