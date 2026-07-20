import scala.collection.mutable

object MatchingBrackets {

  val mapping: Map[Char, Char] = Map(
    '{' -> '}',
    '(' -> ')',
    '[' -> ']'
  )

  def isPaired(brackets: String): Boolean = {
    val stack: mutable.Stack[Char] = mutable.Stack()

    for (char <- brackets) {
      if mapping.keys.toSet.contains(char) then stack.push(char)
      else if stack.isEmpty && mapping.values.toSet.contains(char) then stack.push(char)
      else if (stack.nonEmpty) {
        if char == mapping.getOrElse(stack.top, '_') then
          stack.pop()
        else if stack.nonEmpty && char != mapping.getOrElse(stack.top, '_') && mapping.values.toSet.contains(char) then
          stack.push(char)
      }
    }
    stack.isEmpty
  }
}
