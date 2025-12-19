object PhoneNumber {
    def clean(str: String): Option[String] = {
        val cleaned = str
        .stripPrefix("+1")
        .stripPrefix("1")
        .filter(_.isDigit)
        .zipWithIndex
        .filter(x => {
            if (x._2 == 0 || x._2 == 3) ('2' to '9').contains(x._1)
            else ('0' to '9').contains(x._1)
        })
        
        cleaned.length match {
            case 10 => Some(cleaned.map(_._1).mkString)
            case _ => None
        }
    }
}