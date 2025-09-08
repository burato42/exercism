package strain

type Ints []int
type Lists [][]int
type Strings []string

type Slicer interface {
	int | string | []int
}

// Implement the "Keep" and "Discard" function in this file.
func Keep[T Slicer](seq []T, f func(T) bool) []T {
	var res []T
	for _, elem := range seq {
		if f(elem) {
			res = append(res, elem)
		}
	}
	return res
}

func Discard[T Slicer](seq []T, f func(T) bool) []T {
	return Keep(seq, func(val T) bool { return !f(val) })
}
