package graphs

/**
 * [127. Word Ladder](https://leetcode.com/problems/word-ladder/description/)
 *
 * @Difficulty=Hard
 */
class WordLadder {
    /**
     * Note, you can argue that this is a graph problem with a node representing a word and the edge representing the
     * character difference.
     */
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toMutableSet()
        if (endWord !in wordSet) return 0

        val queue = ArrayDeque<Pair<String, Int>> ()
        queue.add(beginWord to 1)

        while (queue.isNotEmpty()) {
            val (word, length) = queue.removeFirst()
            if (word == endWord) return length

            word.forEachIndexed { index, _ ->
                val wordCharArray = word.toCharArray()
                for (c in 'a'..'z') {
                    wordCharArray[index] = c
                    val newWord = String(wordCharArray)
                    if (newWord in wordSet) {
                        queue.add(newWord to length + 1)
                        wordSet.remove(newWord)
                    }
                }
            }
        }

        return 0
    }
}
// Solution
/**
 * @Time_Complexity=O(N * L^2)
 */