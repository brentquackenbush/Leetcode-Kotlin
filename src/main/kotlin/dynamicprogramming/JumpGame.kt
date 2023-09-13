package dynamicprogramming

/**
 * [55. Jump Game](https://leetcode.com/problems/jump-game/description/)
 *
 * @Difficulty=Medium
 */
class JumpGame {
    /**
     * Greedy Solution. Most efficient one pass
     *
     * Dynamic Programming Problem, the most unefficient way would to try every possible jump
     * This would take O(2^n -2) because we have to take a jump and decide not to take the jump
     * at every index besides the first index...because we have to jump.
     */
    fun solution(nums: IntArray): Boolean {
        var lastPos = nums.size - 1
        for(i in lastPos downTo 0) {
            if(i + nums[i] >= lastPos) {
                lastPos = i
            }
        }
        return lastPos == 0
    }
}
// Solution
/**
 * @Time_Complexity: O(n)
 */