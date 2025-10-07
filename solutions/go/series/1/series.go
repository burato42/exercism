package series

func All(n int, s string) []string {
	if len(s) < n {
		return []string{}
	}
	res := make([]string, 0)
	for i := 0; i < len(s)-n+1; i++ {
		res = append(res, s[i:i+n])
	}
	return res
}

func UnsafeFirst(n int, s string) string {
	return s[0:n]
}
