class SpaceAge(val seconds: Int) {
    private val timeCoef = 3600 * 365.25 * 24

    fun onEarth(): Double = seconds / (1.0 * timeCoef)
    fun onMercury(): Double = seconds / (0.2408467 * timeCoef)
    fun onVenus(): Double = seconds / (0.61519726 * timeCoef)
    fun onMars(): Double = seconds / (1.8808158 * timeCoef)
    fun onJupiter(): Double = seconds / (11.862615 * timeCoef)
    fun onSaturn(): Double = seconds / (29.447498 * timeCoef)
    fun onUranus(): Double = seconds / (84.016846 * timeCoef)
    fun onNeptune(): Double = seconds / (164.79132 * timeCoef)
}
