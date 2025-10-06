package armstrong

import "math"

func IsNumber(n int) bool {
	digits := make([]int, 0)
	initialN := n
	for initialN > 0 {
		digits = append(digits, initialN%10)
		initialN = initialN / 10
	}
	var sum float64 = 0
	power := len(digits)
	for _, number := range digits {
		sum += math.Pow(float64(number), float64(power))
	}
	return int(sum) == n
}
