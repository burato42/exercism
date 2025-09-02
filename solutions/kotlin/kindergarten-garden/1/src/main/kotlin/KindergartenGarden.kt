class KindergartenGarden(private val diagram: String) {
    val children = listOf(
        "Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"
    )
    val seeds = mapOf(
        'V' to "violets",
        'R' to "radishes",
        'C' to "clover",
        'G' to "grass",
    )

    fun getPlantsOfStudent(student: String): List<String> {
        require(student in children)
        val idx = children.indexOf(student)
        val result = mutableListOf<String>()

        val rows = diagram.split("\n")
        for (row in rows) {
            result.add(seeds[row[2 * idx]]!!)
            result.add(seeds[row[2 * idx + 1]]!!)
        }
        return result
    }
}
