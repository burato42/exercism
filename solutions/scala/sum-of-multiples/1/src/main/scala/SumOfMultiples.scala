object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val res = (1 until limit).filter(x => factors.exists(x % _ == 0)).reduceOption(_ + _)
    res match {
      case Some(value) => value
      case None => 0
    }
  }
}

