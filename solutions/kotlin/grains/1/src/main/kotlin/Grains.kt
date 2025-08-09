import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number > 0 && number < 65)
        return 2.toBigInteger().pow(number - 1)

    }

    fun getTotalGrainCount(i: Int): BigInteger {
        return (1..64).map { getGrainCountForSquare(it) }.sumOf { it }
    }
}
