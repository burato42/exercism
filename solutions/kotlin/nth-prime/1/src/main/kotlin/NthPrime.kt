object Prime {

    fun nth(n: Int): Int {
        require(n >= 1) {"There is no zeroth prime."}
        val primeNumbers = mutableListOf<Int>()
        var curNum = 2
        while (primeNumbers.size < n) {
            if (primeNumbers.all { curNum % it != 0 }) {
                primeNumbers.add(curNum)
            }
            curNum += 1
        }
        return primeNumbers.last()
    }
}
