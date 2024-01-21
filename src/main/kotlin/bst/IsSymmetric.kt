package bst

class IsSymmetric {

    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetricSolver(root, root)
    }

    fun isSymmetricSolver(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t1 == null && t2 == null) return true
        if (t1 == null || t2 == null) return false

        return if (t1.`val` == t2.`val`) isSymmetricSolver(t1.left, t2.right) && isSymmetricSolver(t1.right, t2.left) else false
    }

    fun isSymmetricIterative(root: TreeNode?): Boolean {
        val q = ArrayDeque<TreeNode?>()
        q.addLast(root)
        q.addLast(root)
        while (q.isNotEmpty()) {
            val t1 = q.removeFirstOrNull() ?: return false
            val t2 = q.removeFirstOrNull() ?: return false
            if (t1 == null && t2 == null) continue
            if (t1 == null || t2 == null || t1.`val` != t2.`val`) return false
            q.addLast(t1.left)
            q.addLast(t2.right)
            q.addLast(t1.right)
            q.addLast(t2.left)
        }
        return true
    }
}
