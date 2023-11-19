package math

/**
 * [50. Pow(x,n)](https://leetcode.com/problems/powx-n/description/)
 *
 * @Difficulty=Medium
 */
class Pow {
    fun myPow(x: Double, n: Int): Double {
        var base = x
        var exponent = n.toLong() // To handle edge cases with large negative numbers
        var result = 1.0

        if (exponent < 0) {
            base = 1 / base
            exponent = -exponent
        }

        while (exponent > 0) {
            if (exponent % 2L == 1L) {
                result *= base
            }
            base *= base
            exponent /= 2
        }

        return result
    }
}
// Solution
/**
 * @Time_Complexity=O(logn) because in each iteration of the loop, the exponent is halved, reducing the number of
 * multiplications significantly compared to the naive approach of multiplying x by itself n times.
 */