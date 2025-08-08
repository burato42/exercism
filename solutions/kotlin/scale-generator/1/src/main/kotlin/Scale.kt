class Scale(private val tonic: String) {
    private val scaleMajor = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
    private val scaleMinor = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")

    fun chromatic(): List<String> {
        val scaleNote = tonic.replaceFirstChar { it.uppercase() }
        val scale = if (scaleNote.contains("b")) scaleMinor else scaleMajor
        val idx = scale.indexOf(scaleNote)

        return scale.slice(idx until scale.size) + scale.slice(0 until idx)
    }

    fun interval(intervals: String): List<String> {
        val chromaticTones = this.chromatic()
        var pos = 0
        return intervals.map {
            val note = chromaticTones[pos % chromaticTones.size]
            when (it) {
                'm' -> pos += 1
                'M' -> pos += 2
                else -> pos += 3
            }
            note
        }
    }

}
