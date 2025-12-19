object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int = (1 to n).map(x => x * x).sum

  def squareOfSum(n: Int): Int = Math.pow((1 to n).sum, 2).toInt

  def differenceOfSquares(n: Int): Int = (sumOfSquares(n) - squareOfSum(n)).abs
}
