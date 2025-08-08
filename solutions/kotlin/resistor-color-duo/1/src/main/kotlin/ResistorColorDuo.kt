object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        return colors.take(2).map { it.ordinal }.joinToString("").toInt()
    }
}
