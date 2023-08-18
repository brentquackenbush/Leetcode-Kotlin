package kotlindatastructures.linkedlist

class LinkedList<T : Any> {

    private var head: Node<T>? = null

    val isEmpty: Boolean
        get() = head == null

    fun append(value: T) {
        if (head == null) {
            head = Node(value)
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = Node(value)
    }
}
