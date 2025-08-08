object Yacht {

    private fun getFourOfKind(dices: IntArray): Int {
        for (dice in (6 downTo 1)) {
            if (dices.count { it == dice } >= 4) {
                return dice * 4
            }
        }
        return 0
    }

    private fun getFullHouse(dices: IntArray): Int {
        val sorted = dices.sorted()
        val left1 = sorted.slice(0..2)
        val right1 = sorted.slice(3..4)
        if (left1.all { it == left1[0] } && right1.all { it == right1[0] }) return sorted.sum()
        val left2 = sorted.slice(0..1)
        val right2 = sorted.slice(2..4)
        if (left2.all { it == left2[0] } && right2.all { it == right2[0] }) return sorted.sum()
        return 0
    }

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when (category) {
            YachtCategory.YACHT -> if (dices.all { it == dices[0] }) 50 else 0
            YachtCategory.CHOICE -> dices.sum()
            YachtCategory.BIG_STRAIGHT -> if (dices.sorted().toIntArray().contentEquals(intArrayOf(2, 3, 4, 5, 6))) 30 else 0
            YachtCategory.LITTLE_STRAIGHT -> if (dices.sorted().toIntArray().contentEquals(intArrayOf(1, 2, 3, 4, 5))) 30 else 0
            YachtCategory.FOUR_OF_A_KIND -> getFourOfKind(dices)
            YachtCategory.FULL_HOUSE -> if (dices.all { it == dices[0] }) 0 else getFullHouse(dices)
            YachtCategory.SIXES -> dices.count { it == 6 } * 6
            YachtCategory.FIVES -> dices.count { it == 5 } * 5
            YachtCategory.FOURS -> dices.count { it == 4 } * 4
            YachtCategory.THREES -> dices.count { it == 3 } * 3
            YachtCategory.TWOS -> dices.count { it == 2 } * 2
            YachtCategory.ONES -> dices.count { it == 1 } * 1
            else -> 0
        }
    }
}
