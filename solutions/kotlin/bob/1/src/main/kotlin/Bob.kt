object Bob {

    fun isQuestion(input: String): Boolean {
        return input.endsWith('?')
    }

    fun isYelling(input: String): Boolean {
        return input.uppercase() == input  && input.matches(Regex("^.*[A-Z]+.*\$"))

    }

    fun hey(input: String): String {
        val cleaned = input.trim()
        return when {
            isQuestion(cleaned) && isYelling(cleaned) -> "Calm down, I know what I'm doing!"
            isQuestion(cleaned) -> "Sure."
            isYelling(cleaned) -> "Whoa, chill out!"
            cleaned.isEmpty() -> "Fine. Be that way!"
            else -> "Whatever."
        }
    }
}
