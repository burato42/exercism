object RomanNumerals {

    fun value(n: Int): String {
        val result = mutableListOf<String>()
        var remainder = n
        while (remainder > 0) {
            when {
                 remainder >= 1000 -> {
                    remainder -= 1000
                    result.add("M")
                }
                remainder >= 900 -> {
                    remainder -= 900
                    result.add("CM")
                }
                remainder >= 500 -> {
                    remainder -= 500
                    result.add("D")
                }
                remainder >= 400 -> {
                    remainder -= 400
                    result.add("CD")
                }
                remainder >= 100 -> {
                    remainder -= 100
                    result.add("C")
                }
                remainder >= 90 -> {
                    remainder -= 90
                    result.add("XC")
                }
                remainder >= 50 -> {
                    remainder -= 50
                    result.add("L")
                }
                remainder >= 40 -> {
                    remainder -= 40
                    result.add("XL")
                }
                remainder >= 10 -> {
                    remainder -= 10
                    result.add("X")
                }
                remainder >= 9 -> {
                    remainder -= 9
                    result.add("IX")
                }
                remainder >= 5 -> {
                    remainder -= 5
                    result.add("V")
                }
                remainder >= 4 -> {
                    remainder -= 4
                    result.add("IV")
                }
                else -> {
                    remainder -= 1
                    result.add("I")
                }
            }
        }
        return result.joinToString("")
    }
}
