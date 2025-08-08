fun translate(rna: String?): List<String> {
    val codonToProteinMapping = mapOf(
        "AUG" to "Methionine",
        "UUU" to "Phenylalanine",
        "UUC" to "Phenylalanine",
        "UUA" to "Leucine",
        "UUG" to "Leucine",
        "UCU" to "Serine",
        "UCC" to "Serine",
        "UCA" to "Serine",
        "UCG" to "Serine",
        "UAU" to "Tyrosine",
        "UAC" to "Tyrosine",
        "UGU" to "Cysteine",
        "UGC" to "Cysteine",
        "UGG" to "Tryptophan",
        "UAA" to "STOP",
        "UAG" to "STOP",
        "UGA" to "STOP")

    return (rna?.chunked(3) ?: listOf())
        .takeWhile { codonToProteinMapping[it] != "STOP" }
        .map { el -> codonToProteinMapping[el] ?: throw IllegalArgumentException() }
}
