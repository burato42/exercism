class PhoneNumber(txt: String?) {
    private var res: String?

    init {
        res = txt?.filter { it.isDigit() }.toString()

        require(res?.length!! in 10..11)
        if (res?.length == 11) {
            require(res?.get(0) == '1')
            res = res?.substring(1)
        }
        require(res?.get(0)?.digitToInt() in 2..9)
        require(res?.get(3)?.digitToInt() in 2..9)
    }

    val number: String? = res

}
