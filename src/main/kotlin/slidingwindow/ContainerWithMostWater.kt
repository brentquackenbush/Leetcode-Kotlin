package slidingwindow

/**
 * [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
 */
class ContainerWithMostWater {

    fun containerWithMostWater(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = 0
        while (left < right) {
            if (height[right] > height[left]) {
                max = maxOf(max, minOf(height[right], height[left]) * right - left)
                left++
            } else {
                max = maxOf(max, minOf(height[right], height[left]) * right - left)
                right--
            }
        }
        return max
    }
}
// Solution
/**
 * @Time_Complexity: O(n)
 *
 * We can use the sliding window algorithm to keep track of the area with the most trapped rain water. We didn't need
 * to use a data structure of any kind so this was memory efficient solution.
 */
