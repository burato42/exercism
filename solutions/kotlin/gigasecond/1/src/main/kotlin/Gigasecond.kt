import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond(ldt: LocalDateTime) {
    constructor(lt: LocalDate) : this(lt.atStartOfDay())

    val date: LocalDateTime = ldt.plusSeconds(Math.pow(10.0, 9.0).toLong())
}
