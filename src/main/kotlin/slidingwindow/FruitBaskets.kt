package slidingwindow

/**
 * [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/description/)
 *
 * @Difficulty=Medium
 *
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 */
class FruitBaskets {
    fun solution(fruits: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var windowStart = 0
        var totalFruit = 0

        for (windowEnd in fruits.indices) {
            map[fruits[windowEnd]] = map.getOrElse(fruits[windowEnd]) { 0 } + 1

            while (map.size > 2) {
                map[fruits[windowStart]] = map[fruits[windowStart]]!! - 1
                if (map[fruits[windowStart]]!! == 0) {
                    map.remove(fruits[windowStart])
                }
                windowStart++
            }
            totalFruit = maxOf(totalFruit, windowEnd - windowStart + 1)
        }
        return totalFruit
    }
}
// Solution
/**
 * @Time_Complexity: O(n)
 *
 * Initialize Variables: Use a mutable map fruitCounts to keep track of the count of each fruit in the current window. windowStart represents the start of the window, and maxFruits will store the result.
 *
 * Expand Window: Iterate through the trees (from left to right) and expand the window to include each tree's fruit, updating fruitCounts accordingly.
 *
 * Shrink Window: If there are more than two types of fruit in the window (i.e., fruitCounts.size > 2), then shrink the window from the left until there are only two types. This simulates picking one fruit from every tree while ensuring that the picked fruits can fit into the two baskets.
 *
 * Update Result: After potentially shrinking the window, update maxFruits if the current window is larger than the previously found largest window.
 *
 * Return Result: Return the maximum number of fruits that can be picked.
 *
 * This solution has a time complexity of O(n), where n is the length of the input array, and a space complexity of O(1), since the fruitCounts map will have at most two entries.
 */
