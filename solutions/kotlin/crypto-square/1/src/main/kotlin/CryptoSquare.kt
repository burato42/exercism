import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val normalized = plaintext.lowercase().replace(Regex("[^a-z\\d]"), "")

        if (normalized.isEmpty()) {
            return ""
        }

        val normalizedSize = normalized.length
        val c = ceil(sqrt(normalizedSize.toDouble())).toInt()
        val r = if (c * (c - 1) >= normalizedSize) c - 1 else c

        val fullText = normalized + " ".repeat(c * r - normalizedSize)

        val chunked = fullText.chunked(c).take(r)

        var res = ""
        for (idx in 0 until c) {
            for (word in chunked) {
                res += word[idx]
            }
            res += " "
        }

        return res.dropLast(1)
    }
}
