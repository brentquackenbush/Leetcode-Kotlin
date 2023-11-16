package graphs

class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        var result = mutableListOf<Int>()
        val graph = Array<MutableList<Int>>(numCourses) { mutableListOf() }
        val inDegrees = IntArray(numCourses)

        for(preReq in prerequisites) {
            val pre = preReq[1]
            val course = preReq[0]
            graph[pre].add(course)
            inDegrees[course]++
        }

        val queue = ArrayDeque<Int>()
        for(i in 0 until numCourses) {
            if(inDegrees[i] == 0) {
                queue.add(i)
                result.add(i)
            }
        }

        var count = 0
        while(queue.isNotEmpty()) {
            val course = queue.removeFirst()
            count++
            for(adjCourse in graph[course]) {
                if(--inDegrees[adjCourse] == 0) {
                    queue.add(adjCourse)
                    result.add(adjCourse)
                }
            }

        }

        return if(result.size == numCourses) result.toIntArray() else intArrayOf()
    }
}
// Solution
/**
 * @Time_Complexity=O
 */