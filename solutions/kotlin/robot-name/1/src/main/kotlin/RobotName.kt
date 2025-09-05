class Robot {
    private var name_ = makeUpName()

    val name: String
        get() = name_

    private fun makeUpName(): String {
        val first = ('A'..'Z').random()
        val second = ('A'..'Z').random()
        val digits = (1..999).random().toString().padStart(3, '0')
        return "$first$second$digits"
    }
    fun reset() {
        name_ = makeUpName()
    }
}
