object Etl {
    type Legacy = Map[Int, Seq[String]]
    type Modern = Map[String, Int]

    def transform(old: Legacy): Modern = {
        old.flatMap { 
            case (k, value) => value.map(_.toLowerCase -> k)
        }
    }
}