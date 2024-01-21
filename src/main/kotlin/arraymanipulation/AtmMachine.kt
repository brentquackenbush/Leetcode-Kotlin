package arraymanipulation

/**
 * [2241. Design an ATM Machine](https://leetcode.com/problems/design-an-atm-machine/description/)
 *
 * @Difficulty=Medium
 */
class AtmMachine {

    private val bankNotes = intArrayOf(20, 50, 100, 200, 500)
    private val atmBanknotesCount = IntArray(5) { 0 }

    fun deposit(banknotesCount: IntArray) {
        for (i in banknotesCount.indices) {
            atmBanknotesCount[i] = atmBanknotesCount[i] + banknotesCount[i]
        }
    }

    fun withdraw(amount: Int): IntArray {
        val result = IntArray(5) { 0 }
        var remainingAmount = amount

        for (i in atmBanknotesCount.indices.reversed()) {
            val count = minOf(remainingAmount / bankNotes[i], atmBanknotesCount[i])
            remainingAmount -= count * bankNotes[i]
            result[i] = count
        }

        return if (remainingAmount > 0) {
            intArrayOf(-1)
        } else {
            for (i in result.indices) {
                atmBanknotesCount[i] = atmBanknotesCount[i] - result[i]
            }

            result
        }
    }
}
// Solution
/**
 * @Time_Complexity=O(1) We only have to go through an array of length 5.
 */
