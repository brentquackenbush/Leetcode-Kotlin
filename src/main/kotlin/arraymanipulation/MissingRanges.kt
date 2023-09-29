package arraymanipulation

class MissingRanges {

    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        val resultRange = mutableListOf<List<Int>>()
        var current = lower

        if(nums.isEmpty()) {
            resultRange.add(listOf(lower, upper))
            return resultRange
        }

        for(num in nums) {
            if(current < num) {
                if(current == num - 1) {
                    resultRange.add(listOf(current, current))
                } else {
                    resultRange.add(listOf(current, num - 1))
                }
            }
            current = num + 1

            if(current > upper) {
                break
            }
        }

        if(current <= upper) {
            if(current == upper) {
                resultRange.add(listOf(current, current))
            } else {
                resultRange.add(listOf(current, upper))
            }
        }

        return resultRange
    }

}