package stack

/**
 * [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
 *
 * @Difficulty=Medium
 */
class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val answers = IntArray(n) { 0 }
        val stack = ArrayDeque<Int>()
        for(day in 0 until n) {
            val currentTemp = temperatures[day]

            while(stack.isNotEmpty() && temperatures[stack.last()] < currentTemp) {
                var prevDay = stack.removeLast()
                answers[prevDay] = day - prevDay
            }
            stack.addLast(day)
        }
        return answers
    }
}
// Solution
/**
 * @Time_Complexity=O(n) by using a monotonic stack.
 */
