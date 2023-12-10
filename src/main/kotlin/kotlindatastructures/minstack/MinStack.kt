package kotlindatastructures.minstack

/**
 * [155. Min Stack](https://leetcode.com/problems/min-stack/description/)
 *
 * @Difficulty=Medium
 */
class MinStack() {

    // Pair = curValue to min value based off of position
    val stack = ArrayDeque<Pair<Int,Int>>()

    fun push(`val`: Int) {
        if(stack.isEmpty()) {
            stack.addFirst(`val` to `val`)
            return
        }

        if(stack.first().second > `val`) {
            stack.addFirst(`val` to `val`)
        } else {
            stack.addFirst(`val` to stack.first().second)
        }
    }

    fun pop() {
        if(stack.isNotEmpty()) {
            stack.removeFirst()
        }
    }

    fun top(): Int {
        return stack.first().first
    }

    fun getMin(): Int {
        return stack.first().second
    }
}
// Solution
/**
 * @Time_Complexity=O(1) for all functions as the problem requests
 */