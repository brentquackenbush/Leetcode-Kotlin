package math

/**
 * [1401. Circle and Rectangle Overlapping](https://leetcode.com/problems/circle-and-rectangle-overlapping/description/)
 *
 * @Difficulty=Medium
 */
class CircleAndRectangleOverlapping {
    fun checkOverlap(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        val rangeOfX = x1..x2
        val xClosestToCenter = rangeOfX.findClosest(xCenter)

        val rangeOfY = y1..y2
        val yClosestToCenter = rangeOfY.findClosest(yCenter)

        return square(xClosestToCenter - xCenter) + square(yClosestToCenter - yCenter) <= square(radius)
    }

    private fun IntRange.findClosest(target: Int): Int {
        return when {
            target < first -> first
            target > last -> last
            else -> target
        }
    }

    private fun square(i: Int) = i * i
}
// Solution
/**
 * @Time_Complexity=O(1)
 */
