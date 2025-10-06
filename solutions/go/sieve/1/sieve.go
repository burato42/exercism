package sieve

func Sieve(limit int) []int {
	if limit == 1 {
		return []int{}
	}
	numbers := make([]int, limit - 1)
	for i := 2; i <= limit; i++ {
		numbers[i - 2] = i
	}
	result := make([]int, 0)

	
	for _, num := range numbers {
		if len(result) == 0 {
			result = append(result, num)
		} else {
			isPrime := true
			for _, prime := range result {
				if num%prime == 0 {
					isPrime = false
					break
				}
			}
			if isPrime {
				result = append(result, num)
			}
		}
	}
	return result
}
