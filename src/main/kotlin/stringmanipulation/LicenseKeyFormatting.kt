package stringmanipulation

/**
 *
 * [482. License Key Formatting](https://leetcode.com/problems/license-key-formatting/description/)
 *
 * @Difficulty=Easy (Should be medium I think)
 */
class LicenseKeyFormatting {

    fun formatLicenseKey(s: String, k: Int): String {
        // Step 1: Preprocess the string
        val cleanS = s.replace("-", "").toUpperCase()

        // Step 2: Initialize variables
        val sb = StringBuilder()
        var count = 0

        // Step 3: Group characters
        for (char in cleanS.reversed()) {
            sb.append(char)
            count++

            if (count % k == 0) {
                sb.append('-')
            }
        }

        // Step 4: Handle edge cases and reverse string
        if (sb.isNotEmpty() && sb.last() == '-') {
            sb.deleteCharAt(sb.length - 1)
        }

        return sb.reverse().toString()
    }
}
// Solution
/**
 * @Time_Complexity=O(n)
 */