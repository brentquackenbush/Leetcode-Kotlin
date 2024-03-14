package binarytree

import kotlin.math.ceil

/**
 * [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
 *
 * @Difficulty=Medium
 */
class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 0
        var right = piles.max()

        while(left < right) {
            val mid = left + (right - left) / 2
            var hourSpent = 0.0

            for(pile in piles) {
                hourSpent += ceil((pile.toDouble() / mid))
            }

            if(hourSpent <= h) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return right
    }
}
// Solution
/**
 * @Time_Complexity=O(n(log(m))
 */
