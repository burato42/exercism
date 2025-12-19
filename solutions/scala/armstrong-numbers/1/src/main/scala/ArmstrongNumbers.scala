object ArmstrongNumbers {
    def isArmstrongNumber(num: Int): Boolean = {
        val strNum = num.toString
        val len = strNum.length()

        strNum.map(x => Math.pow(x.toString.toInt, len)).sum == num
    }
}