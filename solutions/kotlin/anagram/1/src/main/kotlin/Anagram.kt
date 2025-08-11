class Anagram(val word: String) {

    val encodedWord = encode(word)

    private fun encode(word: String): Map<Char, Int> = word.lowercase().groupBy { it }.mapValues { it.value.size }

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter {
            it.lowercase() != word.lowercase() &&
                    encode(it) == encodedWord
        }.toSet()
    }
}
