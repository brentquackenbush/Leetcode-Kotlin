package slidingwindow

/**
 * [1151. Minimum Swaps to Group All 1's Together](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together)
 */
class MinNumOfSwapsToGroupAll1s {
    fun minSwaps(data: IntArray): Int {
        var numOfOnes = 0
        for(num in data) {
            if(num == 1) numOfOnes++
        }
        // There are no ones to swap, return as it takes 0 swaps
        if(numOfOnes == 0) return 0

        var left = 0
        var zeros = 0
        var min = data.size

        for(right in 0 until data.size) {
            if(data[right] == 0) zeros++
            if(right - left + 1 > numOfOnes) {
                if(data[left] == 0) zeros--
                left++
            }
            if(right - left + 1 == numOfOnes) {
                min = minOf(min, zeros)
            }
        }
        return min
    }
}
/**
 * @Time_Complexity=O(n)
 * This is a fun problem. Really makes you learn sliding window along with longest substring....
 */