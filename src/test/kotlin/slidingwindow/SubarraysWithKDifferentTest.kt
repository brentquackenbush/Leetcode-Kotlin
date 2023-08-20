package slidingwindow

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Sliding window
 *
 * Hard problem
 */
class SubarraysWithKDifferentTest {

    val nums = intArrayOf(1, 2, 1, 1, 2, 2)

    val subject = SubarraysWithKDifferent()

    @Test
    fun testEfficientSolution() {
        val result = subject.subarraysWithKDistinct(nums, 2)

        assertEquals(13, result)
    }
}
