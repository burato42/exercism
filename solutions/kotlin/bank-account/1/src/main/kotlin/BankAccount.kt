import java.util.concurrent.atomic.AtomicLong

class BankAccount {
    private var internalBalance: Long = 0
    private var isOpen = true

    val balance: Long
        get() {
            if (isOpen) {
                return internalBalance
            } else {
                throw IllegalStateException()
            }
        }

    @Synchronized
    fun adjustBalance(amount: Long) {
        if (!isOpen) throw IllegalStateException()
        internalBalance += amount
    }

    fun close() {
        isOpen = false
    }
}
