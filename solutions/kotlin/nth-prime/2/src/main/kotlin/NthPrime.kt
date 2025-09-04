import kotlin.math.sqrt

object Prime {

    fun nth(n: Int): Int {
        require(n >= 1) { "There is no zeroth prime." }
        if (n == 1) return 2

        val primeNumbers = mutableListOf(2)
        var curNum = 3

        while (primeNumbers.size < n) {
            val sqrt = sqrt(curNum.toDouble()).toInt()
            if (primeNumbers.takeWhile { it <= sqrt }.all { curNum % it != 0 }) {
                primeNumbers.add(curNum)
            }
            curNum += 2 // Skip even numbers
        }
        return primeNumbers.last()
    }
}
