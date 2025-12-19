object NumberType extends Enumeration {
    val Perfect, Abundant, Deficient = Value
}

object PerfectNumbers {
    def classify(num: Int): Either[String, NumberType.Value] = {
        if (num <= 0) {
            return Left("Classification is only possible for natural numbers.")
        }
        
        val res = (1 until num).filter(num % _ == 0).sum

        if (res == num) Right(NumberType.Perfect)
        else if (res > num) Right(NumberType.Abundant) 
        else Right(NumberType.Deficient)
    }
}