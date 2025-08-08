class Squares(count: Int) {
    private val cnt = count

    fun sumOfSquares(): Int {
        return (0..cnt).sumOf { it * it }
    }

    fun squareOfSum(): Int {
        return (0..cnt).sum().let { it * it }
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}
