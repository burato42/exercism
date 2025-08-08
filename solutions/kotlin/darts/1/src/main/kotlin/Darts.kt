object Darts {

    fun score(x: Number, y: Number): Int {
        val sqrdRes = x.toFloat() * x.toFloat() + y.toFloat() * y.toFloat()
        return when {
            sqrdRes <= 1 -> 10
            sqrdRes in 1.0..25.0 -> 5
            sqrdRes in 25.0..100.0 -> 1
            else -> 0
        }
    }
}
