package stringmanipulation

/**
 * [680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/description/)
 *
 * @Difficulty=Easy
 */
class ValidPalindromeII {
    fun validPalindrome(s: String): Boolean {

        var left = 0
        var right = s.length - 1
        var isPalindrome = false
        while(left <= right) {
            if(s[left] == s[right]) {
                left++
                right--
            } else {
                return isPalindrome(left + 1, right, s) || isPalindrome(left,right - 1,s)
            }
        }
        return true
    }

    fun isPalindrome(left: Int, right: Int, s: String): Boolean {
        var pointerLeft = left
        var pointerRight = right
        while(pointerLeft <= pointerRight) {
            if(s[pointerLeft] == s[pointerRight]) {
                pointerLeft++
                pointerRight--
            } else{
                return false
            }
        }
        return true
    }
}
// Solution
/**
 * @Time_Complexity=O(n) due to using two pointers.
 */