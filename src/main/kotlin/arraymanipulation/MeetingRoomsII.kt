package arraymanipulation

import java.util.PriorityQueue

/**
 * [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/description/)
 *
 * @Difficulty=Medium
 */
class MeetingRoomsII {

    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        // Sort the intervals by start time
        val sortedIntervals = intervals.sortedWith(compareBy { it[0] })

        // Priority queue to keep track of meeting end times
        val endTimes = PriorityQueue<Int>()

        for (interval in sortedIntervals) {
            if (endTimes.isNotEmpty() && interval[0] >= endTimes.peek()) {
                // If the meeting room is available (current meeting starts after the previous meeting ends)
                // Reuse the room (remove the earliest ending time)
                endTimes.poll()
            }
            // Allocate a new room (add the ending time of the current meeting)
            endTimes.offer(interval[1])
        }

        // The size of the priority queue is the number of rooms required
        return endTimes.size
    }
}
/**
 * @Time_Complexity=O(nlogn) we sort the array first based on the start time.
 */