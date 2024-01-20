package kotlindatastructures.linkedlist

data class Node<T : Any>(
    var value: T,
    var next: Node<T>? = null,
    var neighbors : List<Node<Any>?> = mutableListOf()
) {

    override fun toString(): String {
        return if (next != null) {
            "$value -> $next"
        } else {
            "$value"
        }
    }
}
