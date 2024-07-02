package arraymanipulation

/**
 * [799. Champagne Tower](https://leetcode.com/problems/champagne-tower/description/)
 *
 * @Difficulty=Medium
 */
class ChampangeTower {
    fun champagneTower(
        poured: Int,
        query_row: Int,
        query_glass: Int,
    ): Double {
        if(poured < 1) return poured.toDouble()

        val champagneTowerSimulation = Array(101) { DoubleArray(101) { 0.0 } }

        champagneTowerSimulation[0][0] = poured.toDouble()
        for(row in 0 until 100) {
            var continueOverflow = false
            for(glass in 0..row) {
                if(champagneTowerSimulation[row][glass] > 1.0) {
                    val overflow = (champagneTowerSimulation[row][glass] - 1.0) / 2.0
                    champagneTowerSimulation[row][glass] = 1.0
                    champagneTowerSimulation[row + 1][glass] += overflow
                    champagneTowerSimulation[row + 1][glass + 1] += overflow
                    continueOverflow = true
                }
            }
            if(!continueOverflow) return champagneTowerSimulation[query_row][query_glass]
        }

        return champagneTowerSimulation[query_row][query_glass]
    }
}
// Solution
/**
 * @Time_Complexity=O(R^2) R = row
 */
