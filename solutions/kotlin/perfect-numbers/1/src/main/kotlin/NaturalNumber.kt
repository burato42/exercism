import kotlin.math.sqrt

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0)
    val divisors = mutableSetOf<Int>()
    for (i in 1 .. sqrt(naturalNumber.toDouble()).toInt()) {
        if (naturalNumber % i == 0) {
            divisors.add(i)
            if ( naturalNumber / i != naturalNumber) divisors.add(naturalNumber / i)
        }
    }
    val aliqSum = divisors.sum()

    return when {
        divisors.size == 1 -> Classification.DEFICIENT
        aliqSum == naturalNumber -> Classification.PERFECT
        aliqSum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}
