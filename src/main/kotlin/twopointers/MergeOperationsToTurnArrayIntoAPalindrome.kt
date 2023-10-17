package twopointers

/**
 * [2422. Merge Operations to Turn Array Into a Palindrome](https://leetcode.com/problems/merge-operations-to-turn-array-into-a-palindrome/)
 *
 * @Difficulty=Medium
 */
class MergeOperationsToTurnArrayIntoAPalindrome {
    fun minimumOperations(nums: IntArray): Int {
        if(nums.size == 1) return 0

        var left = 0
        var right = nums.size - 1
        var minimumNumOfOperations = 0

        var leftValue = nums[left]
        var rightValue = nums[right]

        while(left < right) {
            if(leftValue == rightValue) {
                left++
                right--
                leftValue += nums[left]
                rightValue += nums[right]
            } else if(leftValue > rightValue) {
                right--
                rightValue += nums[right]
                minimumNumOfOperations++
            } else {
                left++
                leftValue += nums[left]
                minimumNumOfOperations++
            }
        }
        return minimumNumOfOperations
    }
}
/**
 * @Time_Complexity=O(n)
 */