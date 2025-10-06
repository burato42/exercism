package armstrong

func IsNumber(n int) bool {

	initialN := n
	digitNumber := 0
	for initialN > 0 {
		initialN /= 10
		digitNumber++
	}
	sum := 0
	initialN = n

	for initialN > 0 {
		num := initialN%10
		temp := 1
		for i := 0; i < digitNumber; i++ {
			temp *= num
		}
		sum += temp
		initialN /= 10
	}
	return sum == n
}
