package arraymanipulation

/**
 * [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/)
 *
 * @Difficulty=Medium
 */
class LongestConsecutiveSequence {

    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val set = nums.toSet()
        var maxCount = 1
        for (num in set) {
            if (!set.contains(num - 1)) {
                var curCount = 1
                var curNum = num
                while (set.contains(curNum + 1)) {
                    curCount++
                    curNum++
                }

                maxCount = maxOf(maxCount, curCount)
            }
        }

        return maxCount
    }
}
// Solution
/**
 * @Time_Complexity=O(n+n) = O(n). The while loop should only at max loop to n. This will only loop for beginning
 * sequences.
 */
