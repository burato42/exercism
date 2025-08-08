class DiamondPrinter {

    fun printToList(letter: Char): List<String> {
        val padCnt = letter.code - 'A'.code
        val res = ('A'..letter).mapIndexed { index, c ->
            if (c == 'A') {
                " ".repeat(padCnt - index) + "A" + " ".repeat(padCnt - index)
            } else {
                " ".repeat(padCnt - index) + c.toString() +
                        " ".repeat(index * 2 - 1) +
                        c.toString() + " ".repeat(padCnt - index)
            }
        }

        return res + res.reversed().drop(1)
        }

}
