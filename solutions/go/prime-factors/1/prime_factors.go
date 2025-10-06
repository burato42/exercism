package prime


func Factors(n int64) []int64 {
	factors := make([]int64, 0)


	for n%2 == 0 {
		factors = append(factors, 2)
		n /= 2
	}
	
	var divisor int64 = 3
	for divisor * divisor <= n {
		for n%divisor == 0 {
			factors = append(factors, divisor)
			n /= divisor
		}
		divisor += 2
	}
	if n > 1 {
		factors = append(factors, n)
	}
	return factors
}