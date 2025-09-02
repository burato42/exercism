class IsbnVerifier {

    fun isValid(number: String): Boolean {
        val digitList = number
            .filter { it.isDigit() || it == 'X' }
            .map { if (it == 'X') 10 else it.digitToInt() }

        if (digitList.size != 10) return false
        if (digitList.subList(0, 9).any { it == 10}) return false

        return digitList.zip(10 downTo 1).fold(0) { acc, pair -> acc + pair.first * pair.second  } % 11 == 0
    }
}
