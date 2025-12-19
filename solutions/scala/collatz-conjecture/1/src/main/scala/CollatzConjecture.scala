object CollatzConjecture {
    def steps(n: Int): Option[Int] = {
        def internal(number: Int, acc: Int): Option[Int] = {
            number match {
                case 0 => None
                case x if (x < 0) => None
                case 1 => Some(acc)
                case x if (x % 2 == 0) => internal(number / 2, acc + 1)
                case _ => internal(3 * number + 1, acc + 1) 
            }
        } 
        internal(n, 0)
    }
}