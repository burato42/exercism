object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        if (leftStrand.length != rightStrand.length) throw IllegalArgumentException("left and right strands must be of equal length")

        return leftStrand.zip(rightStrand)
            .filterNot { it.first == it.second }
            .map { 1 }
            .sum()
    }
}
