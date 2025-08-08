object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        val res = mutableListOf<Any>()
        fun helper(lst: Collection<Any?>) {
            if (lst.isEmpty()) return

            val cur = lst.elementAt(0)

            if (cur is Collection<Any?> && cur.isNotEmpty()) helper(cur)
            else if (cur == null) helper(lst.drop(1))
            else res.add(cur); helper(lst.drop(1))
        }
        helper(source)
        return res
    }
}
