package summultiples

func SumMultiples(limit int, divisors ...int) int {
	sum := 0
	visited := make(map[int]struct{}, 0)
	cur := 0
	for _, divisor := range divisors {
		if divisor == 0 {
			continue
		}
		for cur < limit {
			if _, ok := visited[cur]; !ok {
				sum += cur
				visited[cur] = struct{}{}
			}
			cur += divisor
		}
		cur = 0
	}
	return sum
}
