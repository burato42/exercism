class School {
  type DB = Map[Int, Seq[String]]

  private var base: DB = Map.empty

  def add(name: String, g: Int): Unit = {
    base.get(g) match {
      case Some(seq) =>
        val newSeq = seq :+ name
        base += (g -> newSeq)
      case None => 
        base += (g -> Seq(name))
    }
  } 

  def db: DB = base

  def grade(g: Int): Seq[String] = base.getOrElse(g, Seq())
  
  def sorted: DB = Map(base.mapValues(_.sorted).toSeq.sortBy(_._1): _*)
}

