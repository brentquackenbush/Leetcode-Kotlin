package arraymanipulation

/**
 * [2043. Simple Bank System](https://leetcode.com/problems/simple-bank-system/description/)
 *
 * @Difficulty=Medium (Should be easy)
 */
class SimpleBankSystem(private val balance: LongArray) {

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if(account1 > balance.size || account2 > balance.size) return false
        if(balance[account1 - 1] < money) return false

        balance[account1 - 1] = balance[account1 - 1] - money
        balance[account2 - 1] = balance[account2 - 1] + money

        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        if(account > balance.size) return false

        balance[account - 1] = balance[account - 1] + money

        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if(account > balance.size) return false
        if(balance[account - 1] < money) return false

        balance[account - 1] = balance[account - 1] - money

        return true
    }

    /**
     * Your Bank object will be instantiated and called as such:
     * var obj = Bank(balance)
     * var param_1 = obj.transfer(account1,account2,money)
     * var param_2 = obj.deposit(account,money)
     * var param_3 = obj.withdraw(account,money)
     */
}
// Solution
/**
 * @Time_Complexity=O(n) n = number of bank accounts
 */
