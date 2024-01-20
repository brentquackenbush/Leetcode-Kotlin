package arraymanipulation

import org.junit.jupiter.api.Test

class NextPermutationTest {

    private val subject = NextPermutation()

    @Test
    fun easy_1234() {
        val testArray = intArrayOf(1,2, 4, 3)
        subject.nextPermutation(testArray)
    }
}