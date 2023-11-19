package stringmanipulation

/**
 * [227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/description/)
 *
 * @Difficulty=Medium
 */
class BasicCalculatorII {
    fun calculate(s: String): Int {
        val stack = mutableListOf<Int>()
        var operation = '+'
        var currentNumber = 0
        for((index, char) in s.withIndex()) {
            if(char.isDigit()) {
                currentNumber = currentNumber * 10 + (char - '0')
            }
            if(!char.isDigit() && !char.isWhitespace() || index == s.length - 1) {
                when(operation) {
                    '+' -> stack.add(currentNumber)
                    '-' -> stack.add(-currentNumber)
                    '*' -> stack[stack.lastIndex] = stack.last() * currentNumber
                    '/' -> stack[stack.lastIndex] = stack.last() / currentNumber
                }
                operation = char
                currentNumber = 0
            }
        }
        return stack.sum()
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 *
 * withIndex() is cool. If you use it on a string it returns an iterable that returns that index and current char.
 */