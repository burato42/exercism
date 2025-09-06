object PigLatin {

    private fun String.piglatinize(): String {
        return when {
            (this[0] in "aeiou") || (this.length >= 2 && this.substring(0, 2) in listOf("xr", "yt")) -> this + "ay"
            ("qu" in this) && this.substring(0, this.indexOf("qu")).all { it !in "aeiou" } -> {
                val quIdx = this.indexOf("qu")
                val first = this.substring(0, quIdx + 2)
                val second = this.substring(quIdx + 2)
                return second + first + "ay"
            }
            ("y" in this) && this[0] != 'y' && this.substring(0, this.indexOf("y")).all { it !in "aeiou" } -> {
                val yIdx = this.indexOf("y")
                val first = this.substring(0, yIdx)
                println(first)
                val second = this.substring(yIdx + 1)
                println(second)
                return "y" + second + first + "ay"
            }
            this.takeWhile { it !in "aeiou" }.isNotEmpty() -> {
                val first = this.takeWhile { it !in "aeiou" }
                val second = this.substring(first.length)
                return second + first + "ay"
            }
            else -> this
        }
    }
    fun translate(phrase: String): String {
        return phrase.split(" ").joinToString(" ") { it.piglatinize() }
    }
}
