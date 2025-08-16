object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(n <= s.length)
        return s.toList().windowed(n).map { it -> it.map { it.digitToInt() } }
    }
}
