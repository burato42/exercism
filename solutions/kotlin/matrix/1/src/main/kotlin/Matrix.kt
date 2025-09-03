class Matrix(private val matrixAsString: String) {

    val matrixStruct: List<List<Int>> = matrixAsString
        .split("\n")
        .map { matrixCol ->
            matrixCol.split(" ").map {
                it.toInt()
            }
        }

    fun column(colNr: Int): List<Int> {
        return matrixStruct.map { it[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return matrixStruct[rowNr - 1]
    }
}
