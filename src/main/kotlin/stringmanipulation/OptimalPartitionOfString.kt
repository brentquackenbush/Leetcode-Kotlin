package stringmanipulation

/**
 * [2405. Optimal Partition of String](https://leetcode.com/problems/optimal-partition-of-string/description/)
 *
 * @Difficulty=Medium
 */
class OptimalPartitionOfString {

    fun partitionString(s: String): Int {
        // Result
        var minimumNumOfSubStrings = 0
        if(s.length == 0) return minimumNumOfSubStrings

        val seenChars = hashSetOf<Char>()

        for(c in s) {
            if(seenChars.contains(c)) {
                minimumNumOfSubStrings++
                seenChars.clear()
            }
            seenChars.add(c)
        }

        if(seenChars.isNotEmpty()) {
            minimumNumOfSubStrings++
        }

        return minimumNumOfSubStrings
    }
}
/**
 * @Time_Complexity=O(n)
 */