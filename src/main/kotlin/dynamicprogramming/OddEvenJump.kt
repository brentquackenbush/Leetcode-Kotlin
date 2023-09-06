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
            /**
             * ceilingEntry(key): This returns the smallest key-value mapping whose key is greater than or equal to the
             * specified key. In our problem, we use this method during the odd-numbered jumps to find the next index
             * to jump to. Because the keys are the array values and the values are their indices, we can find the next
             * index to jump to in logarithmic time.
             */
            // Odd-numbered jump
            val oddJump = treeMap.ceilingEntry(arr[i])
            if (oddJump != null) {
                canReachEndOdd[i] = canReachEndEven[oddJump.value]
            }
            /**
             * floorEntry(key): This returns the largest key-value mapping whose key is less than or equal to the
             * specified key. We use this during the even-numbered jumps for the same purpose as ceilingEntry.
             */
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
 * @Time_Complexity=O(nlogn)
 *
 * Understanding the Problem
 * The problem asks for the number of "good starting indices" in a given integer array. A starting index is considered "good" if you can reach the end of the array following a series of "jumps" that alternate between "odd-numbered" and "even-numbered" jumps.
 *
 * Odd-Numbered Jumps: You jump to an index j where the value is greater than or equal to the current value, and among those, the value should be the smallest possible.
 *
 * Even-Numbered Jumps: You jump to an index j where the value is less than or equal to the current value, and among those, the value should be the largest possible.
 *
 * Algorithmic Category
 * This is a Dynamic Programming problem, particularly well-suited for bottom-up dynamic programming. The sequence and decisions to be made at each index make dynamic programming a natural fit for solving this problem.
 *
 * Algorithm to Solve
 * Initialize Data Structures:
 * Create two arrays (canReachEndOdd and canReachEndEven) of boolean values to store if it's possible to reach the end from index i with odd or even jumps respectively.
 * A TreeMap to keep track of the possible jump destinations sorted by their values.
 * Bottom-Up Dynamic Programming:
 * Start from the end of the array and move to the beginning.
 * At each step, use the TreeMap to find the next valid index for both odd and even jumps.
 * Update canReachEndOdd[i] and canReachEndEven[i] based on the values for the next indices.
 * Count Good Starting Indices: Count the number of indices from which you can reach the end of the array with odd-numbered jumps.
 */
