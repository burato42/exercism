object HandshakeCalculator {
    val mapping = mapOf(
        1 to Signal.WINK,
        2 to Signal.DOUBLE_BLINK,
        3 to Signal.CLOSE_YOUR_EYES,
        4 to Signal.JUMP
    )

    fun calculateHandshake(number: Int): List<Signal> {
        var level = 0
        val res = mutableListOf<Signal>()
        if (number >= 32) return res
        var cur = number

        while (cur > 0) {
            level += 1
            if (cur and 1 == 1 && level != 5) {
                res.add(mapping[level] ?: Signal.WINK) // WTF :)
            } else if (cur and 1 == 1 && level == 5) {
                res.reverse()
            }
            cur = cur shr 1

        }
        return res
    }
}
