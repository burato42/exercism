object Acronym {
    fun generate(phrase: String) : String {
        val regexSplit = phrase.split(Regex("[ _-]"))
        
        return regexSplit.filter { it.length != 0 }.map { it[0].uppercase() }.joinToString(separator = "")
    }
}
