class RotationalCipher(val key: Int) {
    val CHARS_IN_ALPHABET = 26

    fun encode(text: String): String {
        return text.map {
            when(it) {
                in 'a'..'z' -> 'a' + (it - 'a' + key) % CHARS_IN_ALPHABET
                in 'A'..'Z' -> 'A' + (it - 'A' + key) % CHARS_IN_ALPHABET
                else -> it
            }
        }.joinToString("")
    }
}
