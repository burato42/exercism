import java.util.Stack

object RunLengthEncoding {

    fun encode(input: String): String {
//        The simplest solution
        var res = ""
        var prev: Char? = null
        var counter = 0
        for (ch in input) {
            if (prev == null) {
                prev = ch
                counter += 1
            } else if (ch != prev) {
                if (counter > 1) res += counter.toString()
                res += prev.toString()
                prev = ch
                counter = 1
            } else {
                counter += 1
            }
        }

        if (counter >= 1 && prev == input.last()) {
            if (counter > 1) res += counter.toString()
            res += prev.toString()
        }
        return res
    }

    fun decode(input: String): String {
        var res = ""
        val stack: Stack<String> = Stack()

        for (ch in input) {
            when {
                !ch.isDigit() && stack.isEmpty() -> {
                    stack.add("1")
                    stack.add(ch.toString())
                }

                ch.isDigit() && stack.isEmpty() -> stack.add(ch.toString())
                ch.isDigit() -> {
                    val top = stack.pop()
                    stack.add(top + ch.toString())
                }

                else -> stack.add(ch.toString())
            }

            while (stack.size >= 2) {
                val letter = stack.pop()
                val cnt = stack.pop().toInt()
                res += letter.repeat(cnt)
            }
        }

        return res
    }
}
