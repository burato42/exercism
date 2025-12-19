object Etl {
    type Legacy = Map[Int, Seq[String]]
    type Modern = Map[String, Int]

    def transform(old: Legacy): Modern = {
        var newMap: Modern = Map.empty

        old.foreach { el: (Int, Seq[String]) =>
            el._2.foreach { newKey: String =>
                newMap += (newKey.toLowerCase -> el._1)
            }
        }
        newMap
    }
}