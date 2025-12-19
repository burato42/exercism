class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
    list match {
      case head :: tl => f(head) :: accumulate(f, tl)
      case List() => Nil
    }
  }
}
