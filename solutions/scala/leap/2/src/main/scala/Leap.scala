import java.time.{LocalDate, Period}

object Leap {
  def leapYear(year: Int): Boolean = {
    //    (year % 400) == 0 || ((year % 100) != 0 && (year % 4) == 0)
    val fromDate = LocalDate.parse(s"$year-01-01")
    val toDate = LocalDate.parse(s"$year-12-31")
    println(toDate.toEpochDay - fromDate.toEpochDay)
    toDate.toEpochDay - fromDate.toEpochDay == 365
  }
}
