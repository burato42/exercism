object Atbash {

    fun encode(s: String): String {
        return s
            .filter { it.isLetter() || it.isDigit() }
            .map { if (it.isDigit()) it
                   else Char(25 - it.lowercaseChar().code + 2 * 'a'.code) }
            .chunked(5)
            .joinToString(" ") { it.joinToString("") }
    }

    fun decode(s: String): String{
        return s
            .filter { it.isLetter() || it.isDigit() }
            .map { if (it.isDigit()) it
            else Char(25 - it.lowercaseChar().code + 2 * 'a'.code) }
            .joinToString("")
    }
}
