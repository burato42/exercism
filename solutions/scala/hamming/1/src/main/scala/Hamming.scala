object Hamming{
    def distance(seq1: String, seq2: String): Option[Int] = {
        if (seq1.length != seq2.length) return None
        val zipped = seq1.toCharArray.zip(seq2.toCharArray())
        Some(zipped.map(x => if (x._1 == x._2) 0 else 1).sum)
    }
}