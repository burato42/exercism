class Robot {
    companion object {
        private val usedNames = mutableSetOf<String>()
        private fun generateUniqueName(): String {
            var candidate: String
            do {
                val first = ('A'..'Z').random()
                val second = ('A'..'Z').random()
                val digits = (0..999).random().toString().padStart(3, '0')
                candidate = "$first$second$digits"
            } while (candidate in usedNames)

            usedNames.add(candidate)
            return candidate
        }
    }

    private var name_ = generateUniqueName()
    val name: String get() = name_

    fun reset() {
        name_ = generateUniqueName()
    }
}