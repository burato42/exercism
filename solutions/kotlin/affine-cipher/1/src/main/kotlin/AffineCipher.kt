object AffineCipher {
    private const val m = 26

    private fun isCoprime(a: Int, m: Int): Boolean =
        (a downTo 2).all { m % it != 0 || a % it != 0 }

    private fun calcMme(a: Int): Int {
        for (x in 1 until m) {
            if ((a * x) % m == 1) return x
        }
        return 0
    }

    fun encode(input: String, a: Int, b: Int): String {
        require(isCoprime(a, m))
        val groups = input
            .filter { it.isLetter() || it.isDigit() }
            .map {
                if (it.isDigit()) it
                else Char((a * (it.lowercaseChar().code - 'a'.code) + b).mod(m) + 'a'.code)
            }
            .chunked(5)
        return groups.joinToString(" ") { it.joinToString("") }
    }


    fun decode(input: String, a: Int, b: Int): String {
        require(isCoprime(a, m))
        return input
            .filter { it.isLetter() || it.isDigit() }
            .map {
                if (it.isDigit()) it
                else Char(((calcMme(a) * (it.lowercaseChar().code - 'a'.code - b))).mod(m) + 'a'.code)
            }
            .joinToString("")
    }
}
