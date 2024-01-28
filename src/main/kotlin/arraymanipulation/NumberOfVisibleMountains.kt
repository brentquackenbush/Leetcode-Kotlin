package arraymanipulation

/**
 * [2345. Finding the Number of Visible Mountains](https://leetcode.com/problems/finding-the-number-of-visible-mountains/description)
 *
 * @Difficulty=Medium, more on the hard side due to figuring out how to sort the array.
 */
class NumberOfVisibleMountains {
    fun visibleMountains(peaks: Array<IntArray>): Int {
        if (peaks.size == 1) return 1

        // Step 1: Preprocess the peaks
        peaks.forEach { peak ->
            val (x, y) = peak
            peak[0] = x - y
            peak[1] = x + y
        }

        // Step 2: Sort the peaks
        peaks.sortWith(compareBy({ it[0] }, { -it[1] }))

        // Step 3: Initialize the count
        var count = if (peaks[0][0] == peaks.getOrNull(1)?.get(0) && peaks[0][1] == peaks.getOrNull(1)?.get(1)) 0 else 1
        var maxRight = peaks[0][1]

        // Step 4: Iterate and check for visibility
        for (i in peaks.indices) {
            val next = peaks[i]
            if (next[1] <= maxRight) continue
            maxRight = next[1]
            if (i == peaks.lastIndex || next[0] != peaks.getOrNull(i + 1)?.get(0) || maxRight != peaks.getOrNull(i + 1)?.get(1)) count++
        }

        return count
    }
}
// Solution
/**
 * @Time_Complexity= O(nlogn) due to the sort
 */
