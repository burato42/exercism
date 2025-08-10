class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
    private val sideA = a.toDouble()
    private val sideB = b.toDouble()
    private val sideC = c.toDouble()
    init {
        require(sideA > 0 && sideB > 0 && sideC > 0
                && sideA + sideB > sideC &&
                sideA + sideC > sideB &&
                sideB + sideC > sideA
       )
   }

    val isEquilateral: Boolean = a == b && b == c && a == c
    val isIsosceles: Boolean = a == b || b == c || a == c
    val isScalene: Boolean = a != b && b != c && a != c
}
