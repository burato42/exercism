class Series(private val input: String) {
    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0)
        require(span <= input.length)
        require(input.all { it.isDigit() })

        return input.windowed(span).maxOf { window ->
            window
                .map { it.digitToInt() }
                .fold(1L) { acc, number -> acc * number }
        }
    }
}
