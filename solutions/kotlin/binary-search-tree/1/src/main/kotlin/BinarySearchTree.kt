class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null)

    var root: Node<T>? = null

    fun insert(value: T) {
        fun insertHelper(value: T,node: Node<T>?): Node<T>? {
            if (node == null) return Node(value)
            else if (node.data >= value) node.left = insertHelper(value, node.left)
            else node.right = insertHelper(value, node.right)

            return node
        }
        root = insertHelper(value, root)
    }

    fun asSortedList(): List<T> {
        val res = mutableListOf<T>()

        fun traverseHelper(node: Node<T>?) {
            if (node == null) return
            if (node.left != null) traverseHelper(node.left)
            res.add(node.data)
            if (node.right != null) traverseHelper(node.right)
        }

        traverseHelper(root)
        return res
    }

    fun asLevelOrderList(): List<T> {
        val res = mutableListOf<T>()
        var toTraverse = mutableListOf(root)
        var nextLevel = mutableListOf<Node<T>?>()

        if (root == null) return emptyList()

        while (toTraverse.isNotEmpty()) {
            val cur = toTraverse.removeLast()
            res.add(cur?.data!!)

            if (cur.left != null) nextLevel.add(0, cur.left!!)
            if (cur.right != null) nextLevel.add(0, cur.right!!)

            if (toTraverse.isEmpty()) {
                toTraverse = nextLevel
                nextLevel = mutableListOf()
            }
        }

        return res
    }

}
