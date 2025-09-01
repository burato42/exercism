class School {

    private val students = mutableMapOf<Int, MutableList<String>>()

    fun add(student: String, grade: Int) {
        if (students.containsKey(grade)) students[grade]?.add(student)
        else students[grade] = mutableListOf(student)
    }

    fun grade(grade: Int): List<String> {
        return students.getOrDefault(grade, mutableListOf()).sorted()
    }

    fun roster(): List<String> {
        return students
            .entries
            .sortedBy { it.key }
            .map {
                it.value.sorted()
            }.flatten()
    }
}
