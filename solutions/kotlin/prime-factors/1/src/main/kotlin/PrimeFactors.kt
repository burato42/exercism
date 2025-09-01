object PrimeFactorCalculator {

    private fun isPrime(n: Long): Boolean {
        if (n <= 1) return false
        if (n <= 3) return true
        if (n.mod(2) == 0 || n.mod(3) == 0) return false

        var i = 5
        while (i * i <= n) {
            if (n.mod(i) == 0 || n.mod(i + 2) == 0) {
                return false
            }
            i += 6
        }
        return true
    }

    fun primeSequence() = sequence {
        var nextNumber = 2L
        while (true) {
            if (isPrime(nextNumber)) {
                yield(nextNumber)
            }
            nextNumber++
        }
    }

    fun primeFactors(int: Int): List<Int> {
        return primeFactors(int.toLong()).map { it.toInt() }
    }

    fun primeFactors(long: Long): List<Long> {
        var cur = long
        val res = mutableListOf<Long>()
        val primeIter = primeSequence().iterator()
        var primeNum = primeIter.next()
        while (cur != 1L) {
            if (cur.mod(primeNum) == 0L) {
                res.add(primeNum)
                cur /= primeNum
            } else {
                primeNum = primeIter.next()
            }
        }
        return res
    }
}
