import kotlin.math.pow

class Allergies(private val score: Int) {

    fun getList(): List<Allergen> {
        return enumValues<Allergen>().filter { isAllergicTo(it)}
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        return (score and allergen.score) == allergen.score
    }
}
