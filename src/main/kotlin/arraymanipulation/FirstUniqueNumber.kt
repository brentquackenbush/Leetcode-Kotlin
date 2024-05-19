package arraymanipulation

/**
 * [1429. First Unique Number](https://leetcode.com/problems/first-unique-number/description/)
 *
 * @Difficulty=Medium
 */
class FirstUniqueNumber(nums: IntArray) {
    private val set = LinkedHashSet<Int>()
    private val countMap = mutableMapOf<Int, Int>()

    init {
        nums.forEach { add(it) }
    }

    fun showFirstUnique(): Int {
        return set.firstOrNull() ?: -1
    }

    fun add(value: Int) {
        val count = countMap.getOrDefault(value, 0)
        countMap[value] = count + 1

        if(count == 0) {
            set.add(value)
        } else {
            set.remove(value)
        }
    }
}
// Solution
/**
 * @Time_Complexity=O(1) for both implemented methods
 */
