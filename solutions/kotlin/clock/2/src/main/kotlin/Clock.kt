class Clock(hours: Int, minutes: Int) {
    private var totalMinutes: Int

    init {
        val minutesInDay = 24 * 60
        val initialMinutes = hours * 60 + minutes
        totalMinutes = initialMinutes.mod(minutesInDay)
    }

    val hours: Int
        get() = (totalMinutes / 60).mod(24)

    val minutes: Int
        get() = totalMinutes.mod(60)

    fun subtract(minutesToSubtract: Int) {
        val minutesInDay = 24 * 60
        totalMinutes = (totalMinutes - minutesToSubtract).mod(minutesInDay)
    }

    fun add(minutesToAdd: Int) {
        val minutesInDay = 24 * 60
        totalMinutes = (totalMinutes + minutesToAdd).mod(minutesInDay)
    }

    override fun toString(): String {
        return pad(hours) + ":" + pad(minutes)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Clock) return false
        return totalMinutes == other.totalMinutes
    }

    override fun hashCode(): Int {
        return totalMinutes
    }

    private fun pad(num: Int): String = num.toString().padStart(2, '0')
}
