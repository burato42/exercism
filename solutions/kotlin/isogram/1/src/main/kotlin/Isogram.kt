object Isogram {

    fun isIsogram(input: String): Boolean {
        return input.lowercase()
            .filter { it.isLetter() }
            .fold(mutableMapOf<Char, Int>() ) { acc, chr ->
                acc[chr] = acc.getOrDefault(chr, 0) + 1
                acc

            }.all { (_, cnt) -> cnt == 1 }

    }
}
