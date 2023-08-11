import dynamicprogramming.CoinChange

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val test = CoinChange()
    val amount = 12
    val coinChange = intArrayOf(3,5,11)

    val result = test.coinChange(coinChange,amount)
    println(result)
}