package arraymanipulation

/**
 * [1470. Shuffle the Array](https://leetcode.com/problems/shuffle-the-array/description/)
 */
class ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = IntArray(2 * n)
        var j = 0
        for (i in 0 until n) {
            result[j] = nums[i]
            result[j + 1] = nums[i + n]
            j += 2
        }
        return result
    }
}
/**
 * @Time_Complexity:O(n)
 */
