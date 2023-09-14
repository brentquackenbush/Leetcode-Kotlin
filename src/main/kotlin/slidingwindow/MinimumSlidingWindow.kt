package slidingwindow

/**
 * (76. Minimum Window Substring)[https://leetcode.com/problems/minimum-window-substring/description/]
 *
 * @Difficulty=Hard
 */
class MinimumSlidingWindow {

    fun minimumSlidingWindow(s: String, t: String): String {

        var right = 0
        var left = 0

        var ansRight = 0
        var ansLeft = 0
        var ans = Int.MAX_VALUE

        val dictT = mutableMapOf<Char, Int>()
        val windowCount = mutableMapOf<Char, Int>()
        for(c in t) dictT[c] = dictT.getOrElse(c) { 0 } + 1

        var formed = 0
        val required = dictT.size

        while(right < s.length) {
            val c = s[right]
            windowCount[c] = windowCount.getOrElse(c) { 0 } + 1
            if(dictT.containsKey(c) && dictT[c]!! == windowCount[c]) {
                formed++
            }

            while(formed == required && left <= right) {
                val leftC = s[left]

                windowCount[leftC] = windowCount[leftC]!! - 1
                if(right - left < ans) {
                    ansLeft = left
                    ansRight = right
                    ans = right - left
                }

                if(dictT[leftC]!! > windowCount[leftC]!! && dictT.containsKey(leftC)) {
                    formed--
                }

                left++
            }
            right++
        }
        // Kotlin substring is exclusive for end pointer
        return if (ans == Int.MAX_VALUE) "" else s.substring(ansLeft, ansRight + 1)
    }

}
// Solution
/**
 * @Time_Complexity: O(m+ n) m is length of s and n is length of t
 */