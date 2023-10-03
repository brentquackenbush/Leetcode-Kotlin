package twopointers

/**
 * [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/submissions/)
 *
 * @Difficulty=Hard
 */
class TrappingRainWater {

    fun trap(height: IntArray): Int {

        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        var rain = 0

        while(left < right) {
            if(height[left] <= height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left]
                } else {
                    rain += leftMax - height[left]
                }
                left++
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right]
                } else {
                    rain += rightMax - height[right]
                }
                right--
            }
        }
        return rain
    }

}
// Solution
/**
 * @Time_Complexity=O(n) One pass using two pointers approach
 */