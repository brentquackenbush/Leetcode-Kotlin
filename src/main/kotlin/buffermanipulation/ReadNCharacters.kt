package buffermanipulation

/**
 * (158. Read N Characters Given Read4 II - Call multiple times)[https://leetcode
 * .com/problems/read-n-characters-given-read4-ii-call-multiple-times/]
 *
 * @Difficulty=Hard
 */
class ReadNCharacters(private var fileContent: String) {

    private val buf4 = CharArray(4) // Internal buffer used by read4
    private var buf4Size = 0 // Number of actual characters in buf4
    private var buf4Index = 0 // Index for the next character to be read from buf4
    private var filePointer = 0 // Simulated file pointer

    /**
     * Simulated read4 method
     */
    fun read4(buf4: CharArray): Int {
        var charsRead = 0
        for (i in 0 until 4) {
            if (filePointer >= fileContent.length) {
                break
            }
            buf4[i] = fileContent[filePointer]
            charsRead++
            filePointer++
        }
        return charsRead
    }

    /**
     * Method to read 'n' characters into 'buf' using read4
     */
    fun read(buf: CharArray, n: Int): Int {
        var totalCharsRead = 0

        (0 until n).takeWhile { _ ->
            // Refill buf4 if empty
            if (buf4Index == buf4Size) {
                buf4Size = read4(buf4)
                buf4Index = 0

                if (buf4Size == 0) return@takeWhile false
            }

            // Copy characters from buf4 to buf
            buf[totalCharsRead] = buf4[buf4Index]
            buf4Index++
            totalCharsRead++

            true
        }

        return totalCharsRead
    }
}
/**
 * @Time_Complexity=O(n)
 *
 * Real-world Relevance
 * In a real-world scenario, this could be part of a library for reading large files in chunks.
 * File reading APIs often provide low-level methods to read a fixed number of bytes or characters at a time
 * (read4 in this case). You may require a higher-level function (read) to read an arbitrary number of characters,
 * retaining any "leftover" characters for future reads.
 *
 * For example, think about streaming large text files over a network; you might read chunks of 4 bytes but need to
 * provide an API that can handle arbitrary sizes to make it easier for other parts of your software to consume the
 * data. You may not always want to read exactly 4 characters; maybe you want 7, or 15, or 200. This class would allow
 * you to do that while optimizing reads under the hood.
 *
 * It also offers an efficient way to read a file as it minimizes the number of times you would need to read from
 * the actual file (fileContent here). The class variables store state, so subsequent reads are quick and don't
 * require "starting over" at the beginning of the file.
 *
 * By using Kotlin's idiomatic features, such as its concise for-loops and its takeWhile function, the code remains
 * clean, maintainable, and easy to understand, meeting your interest in producing high-quality, production-ready code.
 */
