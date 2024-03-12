package stack

/**
 * [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/description/)
 *
 * @Difficulty=Hard
 */
class LargestRectangleInHistogram {

    fun largestRectangleAreaBruteForce(heights: IntArray): Int {
        var maxArea = 0
        for (i in heights.indices) {
            var minHeight = Int.MAX_VALUE
            for (j in i until heights.size) {
                minHeight = minOf(minHeight, heights[j])
                maxArea = maxOf(maxArea, minHeight * (j - i + 1))
            }
        }
        return maxArea
    }

    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var max = 0
        for (i in heights.indices) {
            while (stack.isNotEmpty() && heights[i] < heights[stack.last()]) {
                val height = heights[stack.removeLast()]
                val width = if (stack.isEmpty()) i else i - stack.last() - 1
                max = maxOf(max, height * width)
            }
            stack.add(i)
        }

        while (stack.isNotEmpty()) {
            val length = heights[stack.removeLast()]
            val width = if (stack.isEmpty()) heights.size else heights.size - stack.last() - 1
            max = maxOf(max, width * length)
        }

        return max
    }
}
// Solution
/**
 * @Time_Complexity=O(n^2) for brute force.
 * The central idea behind the O(n) solution is to efficiently track potential rectangles as we move through the histogram
 * and to finalize their areas when we can confirm they cannot extend any further. This confirmation comes when we
 * encounter a bar shorter than the one we're considering extending (represented by the top of the stack).
 */
