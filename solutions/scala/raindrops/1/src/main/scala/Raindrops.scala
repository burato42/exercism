object Raindrops {
  def convert(n: Int): String = {
    var res: Vector[String] = Vector.empty
    if (n % 3 == 0) res = res :+ "Pling"
    if (n % 5 == 0) res = res :+ "Plang"
    if (n % 7 == 0) res = res :+ "Plong"
    if (res.isEmpty) return n.toString
    res.mkString
  }
}

