object Bob {
  val question = "(.*)(\\?)".r
  val yelling = "([0-9,A-Z\\s\\%\\^\\*\\@\\#\\$\\!\\(\\)]*)".r
  val askYelling = "([A-Z\\s]*)(\\?)".r
  val noLetters = "[\\d,\\s]*".r
  val silence = "(\\s)*".r
  def response(statement: String): String = {
    statement.trim match {
      case "" => "Fine. Be that way!"
      case askYelling(_, _) => "Calm down, I know what I'm doing!"
      case question(_*) => "Sure."
      case noLetters(_*) => "Whatever."
      case yelling(_*) => "Whoa, chill out!"
      case _ => "Whatever."
    }
  }
}
