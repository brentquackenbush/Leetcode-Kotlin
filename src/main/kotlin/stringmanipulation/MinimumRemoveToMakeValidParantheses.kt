package stringmanipulation

/**
 * [1249. Minimum Remove to Make Valid Parentheses](https://leetcode
 * .com/problems/minimum-remove-to-make-valid-parentheses/description/)
 *
 * @Difficulty=Medium
 */
class MinimumRemoveToMakeValidParantheses {
    fun minRemoveToMakeValid(s: String): String {
        val indexesToRemove = mutableSetOf<Int>()
        val stack = ArrayDeque<Int>()

        for (i in s.indices) {
            when (s[i]) {
                '(' -> stack.addFirst(i)
                ')' -> {
                    if (stack.isEmpty()) {
                        indexesToRemove.add(i)
                    } else {
                        stack.removeFirst()
                    }
                }
            }
        }

        // Add remaining indexes from the stack to the set
        while (stack.isNotEmpty()) indexesToRemove.add(stack.removeFirst())

        val sb = StringBuilder()
        for (i in s.indices) {
            if (i !in indexesToRemove) {
                sb.append(s[i])
            }
        }
        return sb.toString()
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */