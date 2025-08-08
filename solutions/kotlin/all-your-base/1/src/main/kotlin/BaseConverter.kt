import kotlin.math.pow

class BaseConverter(private val oldBase: Int, private val number: IntArray) {

    init {
        if (oldBase < 2) throw IllegalArgumentException("Bases must be at least 2.")
        if (number.isEmpty()) throw IllegalArgumentException("You must supply at least one digit.")
        if (number.size > 1 && number[0] == 0) throw IllegalArgumentException("Digits may not contain leading zeros.")
        if (number.any { it < 0 }) throw IllegalArgumentException("Digits may not be negative.")
        if (number.any { it >= oldBase }) throw IllegalArgumentException("All digits must be strictly less than the base.")
    }

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < 2) throw IllegalArgumentException("Bases must be at least 2.")

        var decNum = number.mapIndexed { ind, el -> el * oldBase.toDouble().pow(number.size - 1 - ind)}
            .map {it.toInt()}.sum()
        val res = mutableListOf<Int>()

        if (decNum == 0) return intArrayOf(0)

        while (decNum > 0) {
            val rem = decNum.mod(newBase)
            decNum /= newBase
            res.add(rem)
        }

        return res.reversed().toIntArray()
    }
}
