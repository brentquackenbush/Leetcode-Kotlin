package stringmanipulation

/**
 * [43. Multiply Strings](https://leetcode.com/problems/multiply-strings/)
 * @Difficulty=Medium
 */
class MultiplyStrings {

    fun solution(num1: String, num2: String): String {
        val m = num1.length
        val n = num2.length
        val res = IntArray(m + n)

        for(i in m - 1 downTo 0) {
            for(j in n - 1 downTo 0) {
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val sum = mul + res[i + j + 1]
                res[i + j + 1] = sum % 10
                res[i + j] += sum / 10
            }
        }

        return res.joinToString("").trimStart('0').ifEmpty { "0" }
    }
}
// Solution
/**
 * @Time_Complexity=O(m * n)
 * m = length of num1 n = length of num2
 */