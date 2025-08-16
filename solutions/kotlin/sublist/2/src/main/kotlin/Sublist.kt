enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

private fun <T> List<T>.containsList(other: List<T>): Boolean {
    for (idx in 0..this.size - other.size) {
        for (otherIdx in 0 until other.size) {
            if (other[otherIdx] != this[idx + otherIdx]) {
                break
            }
            if (otherIdx == other.size - 1) return true
        }
    }
    return false
}

fun <T> List<T>.relationshipTo(other: List<T>): Relationship {
    return when {
        this == other -> Relationship.EQUAL
        other.isEmpty() || (this.containsAll(other) && this.containsList(other)) -> Relationship.SUPERLIST
        this.isEmpty() || (other.containsAll(this) && other.containsList(this)) -> Relationship.SUBLIST
        else -> Relationship.UNEQUAL
    }
}