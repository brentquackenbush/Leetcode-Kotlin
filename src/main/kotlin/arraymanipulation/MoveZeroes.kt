package arraymanipulation

/**
 * [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/description/)
 *
 * @Difficulty=Easy
 */
class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var leftMostZeroIndex = 0
        for(i in 0 until nums.size) {
            if(nums[i] != 0) {
                if(i > leftMostZeroIndex) {
                    nums[leftMostZeroIndex] = nums[i]
                    nums[i] = 0
                }
                leftMostZeroIndex++
            }
        }
    }
}
// Solution
/**
 * @Time_Complexity=
 */