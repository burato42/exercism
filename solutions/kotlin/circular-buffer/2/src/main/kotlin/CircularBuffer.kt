class EmptyBufferException: Exception()

class BufferFullException: Exception()

class CircularBuffer<T>(size: Int) {
    var capacity = size
    var buffer: MutableList<T> = mutableListOf()
    var start = 0
    var end = 0
    var curSize = 0

    fun read(): T {
        if (curSize == 0) {
            throw EmptyBufferException()
        }
        val readIdx = start
        curSize -= 1
        start = (start + 1) % capacity
        return buffer[readIdx]
    }

    fun write(value: T) {
        if (curSize >= capacity) {
            throw BufferFullException()
        }

        // TODO It seems that this is buggy
        if (end < start) {
            buffer[end] = value
        } else {
            buffer.add(end, value)
        }
        curSize += 1
        end = (end + 1) % capacity
    }

    fun overwrite(value: T) {
        if (curSize < capacity) {
            write(value)
        } else {
            buffer[start] = value
            start = (start + 1) % capacity
            end = (end + 1) % capacity
        }
    }

    fun clear() {
        buffer.clear()
        curSize = 0
        start = 0
        end = 0
    }
}