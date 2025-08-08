// NB. It's a naive implementation for a custom set

class CustomSet(vararg elements: Int) {
    private val mySet: MutableSet<Int> = mutableSetOf()

    init {
        for (el in elements) {
            mySet.add(el)
        }
    }

    fun isEmpty(): Boolean {
        return mySet.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return when {
            other.isEmpty() and mySet.isEmpty() -> true
            other.isEmpty() -> false
            else -> mySet.all { other.contains(it) }
        }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return when {
            other.isEmpty() and mySet.isEmpty() -> true
            other.isEmpty() -> true
            else -> mySet.all { !other.contains(it) }
        }
    }

    fun contains(other: Int): Boolean {
        return mySet.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        return mySet.filter { other.contains(it) }.toIntArray().let { CustomSet(*it) }
    }

    fun add(other: Int) {
        mySet.add(other)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is CustomSet) {
            return false
        }

        return this.isSubset(other) and other.isSubset(this)
    }

    operator fun plus(other: CustomSet): CustomSet {
        mySet.forEach { other.add(it) }

        return other
    }

    operator fun minus(other: CustomSet): CustomSet {
        val result = mySet.filterNot { other.contains(it) }.toIntArray()

        return CustomSet(*result)
    }
}
