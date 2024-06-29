package low_level_design

/**
 * [1396. Design Underground System](https://leetcode.com/problems/design-underground-system/)
 *
 * @Difficulty=Medium
 */
class UndergroundSystem {

    // Key is the user ID, value is a pair of (check-in station name, check-in time)
    private val currentCheckedIn = mutableMapOf<Int, Pair<String, Int>>()

    // Key is a concatenated string of "startStation_endStation", value is a pair of (total travel time, number of trips)
    private val averageTimes = mutableMapOf<String, Pair<Int, Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        if (currentCheckedIn.containsKey(id)) {
            throw IllegalArgumentException("User $id is already checked in.")
        }
        currentCheckedIn[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val checkInData = currentCheckedIn.remove(id) ?: throw IllegalArgumentException("User $id did not check in.")

        val (startStation, startTime) = checkInData
        val travelTime = t - startTime
        val routeKey = "${startStation}_$stationName"

        val (totalTime, tripCount) = averageTimes.getOrDefault(routeKey, Pair(0, 0))
        averageTimes[routeKey] = Pair(totalTime + travelTime, tripCount + 1)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val routeKey = "${startStation}_$endStation"
        val (totalTime, tripCount) = averageTimes[routeKey] ?: throw IllegalArgumentException("No trips from $startStation to $endStation.")

        return totalTime.toDouble() / tripCount
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

// Solution
/**
 * @Time_Complexity=O(1) for runtime complexity
 */
