package dynamicprogramming

/**
 * [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
class ClimbingStairs {

    fun climbStairs(n: Int) : Int {
        if(n == 1) return 1

        var prev1 = 1
        var prev2 = 2

        for(i in 3..n) {
            val newValue = prev1 + prev2
            prev1 = prev2
            prev2 = newValue
        }

        return prev2
    }
}
// Solution
/**
 * @Time_Complexity: O(n) we are saving the summation of the last 2 values f(n-1) and f(n-2) in a linear fashion, by
 * using two variables. This is the fibonacci sequence. 
 */