package graph

import graphs.CloneGraph
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Test

class CloneGraphTest {

    private val subject = CloneGraph()

    @Test
    fun testCloneGraph() {
        // Create the original graph
        val node1 = CloneGraph.Node(1)
        val node2 = CloneGraph.Node(2)
        val node3 = CloneGraph.Node(3)
        val node4 = CloneGraph.Node(4)

        node1.neighbors.add(node2)
        node1.neighbors.add(node4)
        node2.neighbors.add(node1)
        node2.neighbors.add(node3)
        node3.neighbors.add(node2)
        node3.neighbors.add(node4)
        node4.neighbors.add(node1)
        node4.neighbors.add(node3)

        // Clone the graph
        val clone = CloneGraph().cloneGraph(node1)

        // Assertions
        assertNotSame(node1, clone)
        assertEquals(node1.`val`, clone?.`val`)
        // Add more assertions to validate the structure and values of the cloned graph
    }
}
