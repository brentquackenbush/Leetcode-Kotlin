package dynamicprogramming

import java.util.TreeMap

/**
 * [975. Odd Even Jump](https://leetcode.com/problems/odd-even-jump/description/)
 *
 * @Difficulty=Hard
 */
class OddEvenJump {

    fun oddEvenJumps(arr: IntArray): Int {
        val n = arr.size
        val canReachEndOdd = BooleanArray(n)
        val canReachEndEven = BooleanArray(n)
        canReachEndOdd[n - 1] = true
        canReachEndEven[n - 1] = true

        val treeMap = TreeMap<Int, Int>()
        treeMap[arr[n - 1]] = n - 1

        var goodStartingIndices = 1 // Last index is always good

        for (i in n - 2 downTo 0) {
            // Odd-numbered jump
            val oddJump = treeMap.ceilingEntry(arr[i])
            if (oddJump != null) {
                canReachEndOdd[i] = canReachEndEven[oddJump.value]
            }

            // Even-numbered jump
            val evenJump = treeMap.floorEntry(arr[i])
            if (evenJump != null) {
                canReachEndEven[i] = canReachEndOdd[evenJump.value]
            }

            if (canReachEndOdd[i]) {
                goodStartingIndices++
            }

            treeMap[arr[i]] = i
        }

        return goodStartingIndices
    }
}
// Solution
/**
 * @Time_Complexity=
 */