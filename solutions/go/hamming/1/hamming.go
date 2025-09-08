package hamming

import "errors"

func Distance(a, b string) (int, error) {
	if len(a) != len(b) {
		return 0, errors.New("inputs should have the same lengths")
	}
	var dist int
	size := len(a)
	for i := 0; i < size; i++ {
		if a[i] != b[i] {
			dist++
		}
	}
	return dist, nil
}
