package graphs

class RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val adjList = List(1001) { mutableSetOf<Int>() }
        var redundantEdge = intArrayOf()

        for(edge in edges) {
            val (u, v) = edge
            if(dfs(u,v,0,adjList)) {
                redundantEdge = edge
            } else {
                adjList[u].add(v)
                adjList[v].add(u)
            }
        }

        return redundantEdge
    }

    fun dfs(u: Int, v: Int, pre: Int, adjList: List<MutableSet<Int>>): Boolean {
        if(u == v) return true
        for(w in adjList[u]) {
            if(w != pre && dfs(w,v,u,adjList)) return true
        }

        return false
    }
}
// Solution
/**
 * @Time_Complexity=
 */