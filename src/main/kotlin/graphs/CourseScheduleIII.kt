package graphs

import java.util.*

/**
 * [630. Course Schedule III](https://leetcode.com/problems/course-schedule-iii/description/)
 *
 * @Difficulty=Hard
 */
class CourseScheduleIII {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        // Sort by the lastDay. We need to prioritize courses that need to be taken first.
        courses.sortBy { it[1] }
        // Keeps the largest at the top like a max heap
        val pq = PriorityQueue<Int>(compareByDescending { it } )
        var time = 0

        for(course in courses) {
            val (duration, lastDay) = course
            if(time + duration <= lastDay) {
                pq.add(duration)
                time += duration
            } else if(pq.isNotEmpty() && pq.peek() > duration) {
                time += duration - pq.poll()
                pq.add(duration)
            }
        }

        return pq.size
    }
}
// Solution
/**
 * @Time_Complexity= O(nlogn)
 */