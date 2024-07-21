package arraymanipulation

import kotlin.random.Random

/**
 * [380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/)
 *
 * @Difficulty=Medium
 */
class InsertDeleteGetRandomO1 {
    class RandomizedSet() {

        private val valueToIndex = mutableMapOf<Int, Int>()
        private val values = mutableListOf<Int>()

        fun insert(`val`: Int): Boolean {
            if (valueToIndex.containsKey(`val`)) return false

            valueToIndex[`val`] = values.size
            values.add(`val`)

            return true
        }

        fun remove(`val`: Int): Boolean {
            val indexToBeRemoved = valueToIndex[`val`] ?: return false

            // Swap the element to be removed with the last element
            val lastElement = values[values.lastIndex]
            values[indexToBeRemoved] = lastElement
            valueToIndex[lastElement] = indexToBeRemoved

            // Remove the last element
            values.removeAt(values.lastIndex)
            valueToIndex.remove(`val`)

            return true
        }

        fun getRandom(): Int {
            return values[Random.nextInt(values.size)]
        }

    }
}
// Solution
/**
 * @Time_Complexity=O(1)
 */
