object Transpose {

    fun transpose(input: List<String>): List<String> {
        if (input.isEmpty()) return emptyList()
        if (input.size == 1) {
            return input[0].map { it.toString() }
        }

        val maxLen = input.maxOf { it.length }

        val res = input
            .map { it.padEnd(maxLen, '*') }
            .fold(List(maxLen) { "" }) { acc, str -> acc.mapIndexed { index, s -> s + str[index] } }
            .map { it.trimEnd('*')}
            .map { it.replace('*', ' ')}
        return res
    }
}
