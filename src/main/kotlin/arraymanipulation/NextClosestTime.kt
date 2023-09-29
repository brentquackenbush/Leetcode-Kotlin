package arraymanipulation

class NextClosestTime {

    fun nextClosestTime(time: String): String {
        val digits = time.filter { it != ':' }.map { it - '0' }.sorted().toSet()
        val M1 = time[4] - '0'
        val M2 = time[3] - '0'
        val H1 = time[1] - '0'
        val H2 = time[0] - '0'

        // "H2H1:M2M1"
        fun getTime(h2: Int = H2, h1: Int = H1, m2: Int = M2, m1: Int = M1) = "$h2$h1:$m2$m1"

        digits.forEach {
            if (it in (M1 + 1)..9)
                return getTime(m1 = it)
        }
        digits.forEach {
            if (it in (M2 + 1)..5)
                return getTime(m2 = it, m1 = digits.first())
        }
        digits.forEach {
            if ((H2 in 0..1 && it in (H1 + 1)..9) || (H2 == 2 && it in (H1 + 1)..3))
                return getTime(h1 = it, m2 = digits.first(), m1 = digits.first())
        }
        digits.forEach {
            if (it in (H2 + 1)..2)
                return getTime(h2 = it, h1 = digits.first(), m2 = digits.first(), m1 = digits.first())
        }
        return getTime(h2 = digits.first(), h1 = digits.first(), m2 = digits.first(), m1 = digits.first())
    }
}
// Solution
/**
 * @Time_Complexity: O(1) constant time because the string is of constant size 5.
 */