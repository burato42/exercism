class Clock(var hours: Int, var minutes: Int) {
    private val minutesInHour = 60
    private val hoursInDay = 24

    private var minuteTimestamp = hours * minutesInHour + minutes

    init {
        calcHoursAndMinutes(minuteTimestamp)
    }

    private fun calcHoursAndMinutes(minuteTimestamp_: Int) {
        if (minuteTimestamp_ >= 0 || minuteTimestamp_.mod(minutesInHour) == 0) {
            hours = (minuteTimestamp_ / minutesInHour).mod(hoursInDay)
            minutes = minuteTimestamp_.mod(minutesInHour)
        } else {
            hours = ((minuteTimestamp_ - minutesInHour)/ minutesInHour).mod(hoursInDay)
            minutes = minuteTimestamp_.mod(minutesInHour)
        }
    }

    override fun toString(): String {
        return pad(hours) + ":" + pad(minutes)
    }

    override fun equals(other: Any?): Boolean {
        val otherObj = other as Clock
        val otherHours = otherObj.hours
        val otherMinutes = otherObj.minutes
        return hours == otherHours && minutes == otherMinutes
    }

    override fun hashCode(): Int {
        return hours * minutesInHour + minutes
    }

    fun subtract(minutes: Int) {
       minuteTimestamp -= minutes
       calcHoursAndMinutes(minuteTimestamp)
    }

    fun add(minutes: Int) {
        minuteTimestamp += minutes
        calcHoursAndMinutes(minuteTimestamp)
    }

    private fun pad(num: Int): String ="$num".padStart(2, '0')
}
