package sort

/**
 * [1029. Two City Scheduling](https://leetcode.com/problems/two-city-scheduling/description/)
 *
 * @Difficulty=Medium
 */
class TwoCityScheduling {

    fun twoCitySchedCost(costs: Array<IntArray>): Int {

        val initialCost = costs.sumOf { it[0] }

        val difference = costs.map { it[1] - it[0] }.sorted()

        val adjustments = difference.take(costs.size / 2).sum()

        return initialCost + adjustments
    }
}
// Solution
/**
 * @Time_Complexity=O(nlogn) due to sort
 */
