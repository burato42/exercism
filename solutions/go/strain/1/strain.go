package strain

// Implement the "Keep" and "Discard" function in this file.
func Keep[T any](seq []T, f func(T) bool) []T {
	var res []T
	for _, elem := range seq {
		if f(elem) {
			res = append(res, elem)
		}
	}
	return res
}

func Discard[T any](seq []T, f func(T) bool) []T {
	var res []T
	for _, elem := range seq {
		if !f(elem) {
			res = append(res, elem)
		}
	}
	return res
}
