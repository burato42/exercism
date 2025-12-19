object SecretHandshake{
    val mapping = Map(0 -> "wink", 1 -> "double blink", 2 -> "close your eyes", 3 -> "jump")
    def commands(number: Int): List[String] = {
        def helper(number: Int, index: Int, list: List[String]): List[String] = {
            number match {
                case number if (number % 2 == 1 && index < 4) => helper(number >> 1, index + 1, mapping(index) :: list)
                case number if (number % 2 == 0 && index < 4) => helper(number >> 1, index + 1, list)
                case number if (number % 2 == 1 && index == 4) => list
                case number if (number % 2 == 0 && index == 4) => list.reverse
            }
        }
        helper(number, 0, List())
    }
}