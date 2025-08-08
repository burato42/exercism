object ScrabbleScore {

    fun scoreLetter(c: Char): Int = when (c.titlecaseChar()) {
        in listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T') -> 1
        in listOf('D', 'G') -> 2
        in listOf('B', 'C', 'M', 'P') -> 3
        in listOf('F', 'H', 'V', 'W', 'Y') -> 4
        in listOf('K') -> 5
        in listOf('J', 'X') -> 8
        in listOf('Q', 'Z') -> 10
        else -> 0
    }

    fun scoreWord(word: String): Int {
        return word.fold(0) { acc, ch -> acc + scoreLetter(ch) }
    }
}
