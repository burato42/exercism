object Luhn {

    fun isValid(candidate: String): Boolean {
        var sum = 0
        val digits = candidate.filter { it != ' ' }

        if (digits.length <= 1) return false

        for ((index, char) in digits.reversed().withIndex()) {
            if (!char.isDigit()) return false

            val cur = char.digitToInt()

            sum += if (index % 2 == 0) {
                cur
            } else if (cur * 2 >= 10) {
                cur * 2 - 9
            } else {
                cur * 2
            }
        }

        return sum%10 == 0
    }
}
