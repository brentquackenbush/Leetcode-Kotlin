package arraymanipulation

/**
 * [1762. Buildings With an Ocean View](https://leetcode.com/problems/buildings-with-an-ocean-view/description/)
 *
 * @Difficulty=
 */
class BuildingsWithAnOceanView {
    fun findBuildings(heights: IntArray): IntArray {
        val n = heights.size - 1
        var currentTallestBuilding = heights[n]
        val oceanViews = mutableListOf<Int>()
        oceanViews.add(n)

        if (n == 0) return oceanViews.toIntArray()

        for (i in n - 1 downTo 0) {
            if (heights[i] > currentTallestBuilding) {
                oceanViews.add(i)
                currentTallestBuilding = heights[i]
            }
        }

        return oceanViews.reversed().toIntArray()
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */
