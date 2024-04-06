package stringmanipulation

/**
 * [777. Swap Adjacent in LR String](https://leetcode.com/problems/swap-adjacent-in-lr-string)
 *
 * @Difficulty=Medium. Good question to learn more about constraints and using two pointers.
 */
class SwapAdjacentInLRString {
    class Solution {
        // We can transform XL -> LX
        // We can transform RX -> XR
        fun canTransform(start: String, end: String): Boolean {
            var i = 0 // Pointer for start
            var j = 0 // Pointer for end
            val n = start.length

            while (i < n && j < n) {
                // Move i and j forward to skip 'X's
                while (i < n && start[i] == 'X') i++
                while (j < n && end[j] == 'X') j++

                // Check for end of one string but not the other
                if ((i < n) != (j < n)) {
                    return false
                }

                if (i < n && j < n) {
                    if (start[i] != end[j]) {
                        // Different non-X characters at current positions
                        return false
                    }

                    if (start[i] == 'L' && i < j) {
                        // 'L' in start cannot move rightwards to match 'L' in end
                        return false
                    }

                    if (start[i] == 'R' && i > j) {
                        // 'R' in start cannot move leftwards to match 'R' in end
                        return false
                    }

                    i++
                    j++
                }
            }

            // Check for trailing 'X's in either string
            while (i < n) if (start[i++] != 'X') return false
            while (j < n) if (end[j++] != 'X') return false

            return true // Passed all checks
        }
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */
