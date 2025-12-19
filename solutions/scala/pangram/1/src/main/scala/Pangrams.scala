object Pangrams {
  def isPangram(input: String): Boolean = {
    input.map(_.toLower).filter(_.isLetter).toSet.toList.sortWith(_ < _).mkString == "abcdefghijklmnopqrstuvwxyz"
  }
}

