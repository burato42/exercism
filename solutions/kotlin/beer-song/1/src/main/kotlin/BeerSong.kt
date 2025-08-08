object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        return (startBottles downTo takeDown).joinToString("\n") {
            when (it) {
                0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
                1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
                2 -> "$it bottles of beer on the wall, $it bottles of beer.\nTake one down and pass it around, ${it - 1} bottle of beer on the wall.\n"
                else -> "$it bottles of beer on the wall, $it bottles of beer.\nTake one down and pass it around, ${it - 1} bottles of beer on the wall.\n"
            }
        }
    }
}
