package arraymanipulation

/**
 * [169. Majority Element](https://leetcode.com/problems/majority-element/description/)
 *
 * @Difficulty=Easy
 */
class MajorityElement {
    /**
     * Boyer-Moore Voting Algorithm
     */
    fun majorityElement(nums: IntArray): Int {

        var candidate = 0
        var count = 0

        for(num in nums) {
            if(count == 0) {
                candidate = num
            }
            count += if(num == candidate) 1 else -1
        }

        return candidate
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 * @Space_Complexity=O(1)
 */
