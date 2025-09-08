package collatzconjecture

import "errors"

func CollatzConjecture(n int) (int, error) {
	var helper func(int) int
	if n <= 0 {
		return 0, errors.New("input should be positive")
	}

	var cnt int
	helper = func(num int) int {
		if num == 1 {
			return cnt
		}

		cnt++
		if num%2 == 0 {
			return helper(num / 2)
		}
		return helper(3*num + 1)
	}

	return helper(n), nil
}
