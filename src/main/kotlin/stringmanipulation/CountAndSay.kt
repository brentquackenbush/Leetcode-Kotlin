package stringmanipulation

/**
 * [38. Count and Say](https://leetcode.com/problems/count-and-say/description/)
 *
 * @Difficulty=Medium
 */
class CountAndSay {
    fun countAndSay(n: Int): String {
        if(n == 1) return "1"
        val previous = countAndSay(n - 1)
        val result = StringBuilder()
        var count = 1
        for(i in 1 until previous.length) {
            if(previous[i] == previous[i-1]) {
                count++
            } else {
                result.append(count).append(previous[i-1])
                count = 1
            }
        }
        result.append(count).append(previous[previous.length - 1])
        return result.toString()
    }
}
// Solution
/**
 * @Time_Complexity=??? O(n * complicated formula)
 */