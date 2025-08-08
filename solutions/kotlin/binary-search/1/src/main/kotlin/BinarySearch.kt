object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2
            if (list[mid] >= item) right = mid
            else left = mid + 1
        }

        if (list.isEmpty() || list[left] != item) throw NoSuchElementException()

        return left
    }
}
