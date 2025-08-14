object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return phrase.replace(Regex("[^\\w\\d ']"), " ")
            .lowercase()
            .split(" ")
            .filter { it.isNotBlank() }
            .map { it.trim( '\'') }
            .groupBy { it }
            .mapValues { it.value.size }

    }
}
