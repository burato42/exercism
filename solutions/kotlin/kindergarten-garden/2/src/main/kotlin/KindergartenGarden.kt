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
        val studentIdx = children.indexOf(student)
        val result = mutableListOf<String>()
        val locations = listOf(2 * studentIdx, 2 * studentIdx + 1)

        val rows = diagram.split("\n")
        for (row in rows) {
            for (position in locations) {
                val plantName = seeds.getOrDefault(row[position], "unknown")
                result.add(plantName)
            }
        }
        return result
    }
}
