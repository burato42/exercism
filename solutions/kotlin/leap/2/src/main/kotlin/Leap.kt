import java.time.DateTimeException
import java.time.LocalDate

data class Year(val year: Int) {

//    val isLeap: Boolean = try {
//        val dt = LocalDate.of(year, 2, 29)
//        true
//    } catch (e: DateTimeException) {
//        false
//    }
    val isLeap: Boolean = (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
}
