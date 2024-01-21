package binarysearch

/**
 * [1891. Cutting Ribbons](https://leetcode.com/problems/cutting-ribbons/description/)
 *
 * @Difficulty=Medium
 */
class CuttingRibbons {
    fun maxLength(ribbons: IntArray, k: Int): Int {
        var low = 1
        var high = ribbons.maxOrNull() ?: 0

        while (low <= high) {
            val mid = low + (high - low) / 2
            var count = 0

            for (ribbon in ribbons) {
                count += ribbon / mid
            }

            if (count >= k) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return high
    }
}
// Solution
/**
 * @Time_Complexity=O(log(max_ribbon_length) * n)
 */
