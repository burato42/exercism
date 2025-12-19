import java.time.LocalDate
import java.time.LocalDateTime

object Gigasecond {
  val GIGASECOND = 1000000000

  def add(startDate: LocalDate): LocalDateTime = startDate.atStartOfDay().plusSeconds(GIGASECOND)

  def add(startDateTime: LocalDateTime): LocalDateTime = startDateTime.plusSeconds(GIGASECOND)
}
