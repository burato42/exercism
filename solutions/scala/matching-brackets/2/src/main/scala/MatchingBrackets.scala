import scala.collection.mutable

object MatchingBrackets {

  private val brackets = Map(
    '{' -> '}',
    '(' -> ')',
    '[' -> ']'
  )

  private val opening = brackets.keySet
  private val closing = brackets.values.toSet

  def isPaired(input: String): Boolean = {
    input
      .foldLeft(Option(List.empty[Char])) {
        case (None, _) => None
        case (Some(stack), char) if opening.contains(char) =>
          Some(char :: stack)
        case (Some(top :: rest), char) if closing.contains(char) && brackets.get(top).contains(char) =>
          Some(rest)
        case (Some(stack), char) if closing.contains(char) =>
          None
        case (acc, _) =>
          acc
      }
      .contains(Nil)
  }
}
