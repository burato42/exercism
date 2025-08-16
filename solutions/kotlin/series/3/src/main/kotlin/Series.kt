object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(n <= s.length)
        return s
            .windowed(n)
            .map { window ->
                window.map { it.digitToInt() } }
    }
}
