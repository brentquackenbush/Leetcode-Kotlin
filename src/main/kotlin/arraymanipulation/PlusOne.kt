package arraymanipulation

/**
 * (66. Plus One)[https://leetcode.com/problems/plus-one/description/]
 *
 * @Difficulty=Easy
 */
class PlusOne {

    fun solution(arr: IntArray): IntArray {
        val n = arr.size

        for(i in n - 1 downTo 0) {
            if(arr[i] < 9) {
                arr[i]++
                return arr
            }
            arr[i] = 0
        }

        val result = IntArray(n + 1)
        result[0] = 1
        return result
    }
}
/**
 * @Time_Complexity=O(n)
 *
 * Java solution:
 * public int[] plusOne(int[] digits) {
 *
 *     int n = digits.length;
 *     for(int i=n-1; i>=0; i--) {
 *         if(digits[i] < 9) {
 *             digits[i]++;
 *             return digits;
 *         }
 *
 *         digits[i] = 0;
 *     }
 *
 *     int[] newNumber = new int [n+1];
 *     newNumber[0] = 1;
 *
 *     return newNumber;
 * }
 */