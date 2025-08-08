import kotlin.math.hypot

object Darts {

    fun score(x: Number, y: Number): Int {
        val sqrdRes = hypot(x.toFloat(), y.toFloat())
        return when {
            sqrdRes <= 1 -> 10
            sqrdRes <= 5 -> 5
            sqrdRes <= 10 -> 1
            else -> 0
        }
    }
}
