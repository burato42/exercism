object ArmstrongNumber {

    fun check(input: Int): Boolean {
        var initial = input
        val digits: MutableList<Int> = mutableListOf()

        while (initial > 0) {
            val rem = initial % 10
            digits.add(rem)
            initial /= 10
        }

        var count = 0
        val size = digits.size

        digits.forEachIndexed { idx, digit ->
            count += Math.pow(digit.toDouble(), size.toDouble()).toInt()
        }

        return count == input
    }

}
