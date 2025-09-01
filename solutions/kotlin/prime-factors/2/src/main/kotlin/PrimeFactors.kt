object PrimeFactorCalculator {

    fun primeFactors(number: Int): List<Int> {
        return primeFactors(number.toLong()).map { it.toInt() }
    }

    fun primeFactors(number: Long): List<Long> {
        val factors = mutableListOf<Long>()
        var remainingNumber = number

        while (remainingNumber % 2 == 0L) {
            factors.add(2L)
            remainingNumber /= 2
        }

        var divisor = 3L
        while (divisor * divisor <= remainingNumber) {
            while (remainingNumber % divisor == 0L) {
                factors.add(divisor)
                remainingNumber /= divisor
            }
            divisor += 2
        }

        if (remainingNumber > 1) {
            factors.add(remainingNumber)
        }

        return factors
    }
}