object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        val points = mutableSetOf<Int>()
        for (factor in factors) {
            var i = 1
            while (i * factor < limit && i * factor > 0) {
                points.add(i * factor)
                i += 1
            }
        }
        return points.sum()
    }
}
