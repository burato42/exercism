import Unit
import java.lang.IllegalArgumentException

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        require(input[0].ordinal != 0)
        var zeros = input[2].ordinal
        val begin: String

        if (input[1].ordinal == 0) {
            begin = (input[0].ordinal).toString()
            zeros += 1
        } else {
            begin = (input[0].ordinal * 10 + input[1].ordinal).toString()
        }

        val end = when {
            zeros < 3 -> "${"0".repeat(zeros)} ${Unit.OHMS.name.lowercase()}"
            zeros < 6 -> "${"0".repeat(zeros - 3)} ${Unit.KILOOHMS.name.lowercase()}"
            zeros < 9 -> "${"0".repeat(zeros - 6)} ${Unit.MEGAOHMS.name.lowercase()}"
            zeros < 12 -> "${"0".repeat(zeros - 9)} ${Unit.GIGAOHMS.name.lowercase()}"
            else -> "Oh, this is too much..."
        }


        return begin + end
    }
}
