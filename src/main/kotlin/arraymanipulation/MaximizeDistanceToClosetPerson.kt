package arraymanipulation

/**
 * [849. Maximize Distance to Closest Person](https://leetcode.com/problems/maximize-distance-to-closest-person/description/)
 *
 * @Difficulty=Medium
 */
class MaximizeDistanceToClosetPerson {

    fun maxDistToClosest(seats: IntArray): Int {
        var first = 0
        var last = 0
        while (seats[last] != 1) last++
        var maxLength = last
        for (i in 0 until seats.size) {
            if (seats[i] == 1) {
                first = last
                last = i
                maxLength = maxOf(maxLength, (last - first) / 2)
            }
        }
        maxLength = maxOf(maxLength, seats.size - last - 1)
        return maxLength
    }
}
// Solution
/**
 * @Time_Complexity: O(n) because we iterate through the entirety of seats.size which is of length n
 */
