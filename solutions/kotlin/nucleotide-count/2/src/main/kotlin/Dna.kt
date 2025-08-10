class Dna(val seq: String) {
    init {
        if (seq.uppercase().any { it !in setOf('A', 'C', 'G', 'T') })
            throw IllegalArgumentException("Unexpected nucleotide name")
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            return seq
                .uppercase()
                .fold( mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)) { acc, ch ->
                    acc[ch] = acc[ch]!! + 1
                    acc
                }

        }
}
