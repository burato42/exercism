object FlattenArray{
    def flatten(list: List[Any]): List[Any] = {
        // list.flatMap {
        //     case i: Int => List(i) 
        //     case l: List[Any] => flatten(l) 
        //     case _ => List() 
        // }
        list.filter(_ != null) match {
            case (head: List[Any]) :: tail => flatten(head) ::: flatten(tail)
            case x :: xs => x :: flatten(xs)
            case _ => List()
        }
    }
}