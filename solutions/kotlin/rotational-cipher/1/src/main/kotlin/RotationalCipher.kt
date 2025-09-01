class RotationalCipher(val key: Int) {

    fun encode(text: String): String {
        return text.map {
            when {
                it.code >= 'a'.code && it.code <= 'z'.code -> (((it.code + key % 26) - 'a'.code) % 26 + 'a'.code).toChar()
                it.code >= 'A'.code && it.code <= 'Z'.code -> (((it.code + key % 26) - 'A'.code) % 26 + 'A'.code).toChar()
                else -> it
            }
        }.joinToString("")
    }
}
