object PigLatin {
    private const val VOWELS = "aeiou"
    private const val SUFFIX = "ay"
    private val VOWEL_SOUNDS = setOf("xr", "yt")

    fun translate(phrase: String): String {
        return phrase.split(" ").joinToString(" ") { it.piglatinize() }
    }

    private fun String.piglatinize(): String {
        return when {
            startsWithVowelSound() -> this + SUFFIX
            hasQuConsonantCluster() -> handleQuPattern()
            hasYVowelPattern() -> handleYPattern()
            startsWithConsonants() -> handleConsonantCluster()
            else -> this
        }
    }

    private fun String.startsWithVowelSound(): Boolean {
        return first() in VOWELS ||
                (length >= 2 && take(2) in VOWEL_SOUNDS)
    }

    private fun String.hasQuConsonantCluster(): Boolean {
        val quIndex = indexOf("qu")
        return quIndex != -1 &&
                take(quIndex).all { it !in VOWELS }
    }

    private fun String.hasYVowelPattern(): Boolean {
        val yIndex = indexOf('y')
        return yIndex > 0 &&
                take(yIndex).all { it !in VOWELS }
    }

    private fun String.startsWithConsonants(): Boolean {
        return isNotEmpty() && first() !in VOWELS
    }

    private fun String.handleQuPattern(): String {
        val quIndex = indexOf("qu")
        val consonantCluster = substring(0, quIndex + 2)
        val remainder = substring(quIndex + 2)
        return remainder + consonantCluster + SUFFIX
    }

    private fun String.handleYPattern(): String {
        val yIndex = indexOf('y')
        val consonantCluster = substring(0, yIndex)
        val remainder = substring(yIndex + 1)
        return "y$remainder$consonantCluster$SUFFIX"
    }

    private fun String.handleConsonantCluster(): String {
        val consonantCluster = takeWhile { it !in VOWELS }
        val remainder = drop(consonantCluster.length)
        return remainder + consonantCluster + SUFFIX
    }
}