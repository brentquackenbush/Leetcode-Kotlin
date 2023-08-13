package kotlindatastructures.tree

class TreeNode<T>(val value: T) {

    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun remove(child: TreeNode<T>) = children.remove(child)

    fun getChildren(): List<TreeNode<T>> = children.toList()

    // In-order traversal for binary trees
    fun inOrderTraversal(visit: (T) -> Unit) {
        if(children.size > 1) children[0].inOrderTraversal(visit)
        visit(value)
        if(children.size > 1) children[1].inOrderTraversal(visit)
    }
    // Pre-order traversal for binary trees
    fun preOrderTraversal(visit: (T) -> Unit) {
        visit(value)
        children.forEach { preOrderTraversal(visit)}
    }
    // Post-order traversal for binary trees
    fun postOrderTrversal(visit: (T) -> Unit) {
        children.forEach { preOrderTraversal(visit)}
        visit(value)
    }
}