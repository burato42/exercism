package grains

import (
	"errors"
	"math"
)

func Square(number int) (uint64, error) {
	if number <= 0 || number >= 65 {
		return 0, errors.New("number should be in a range [1, 64]")
	}
	return uint64(math.Pow(2, float64(number - 1))), nil
}

func Total() uint64 {
	var sum uint64
	for i := 1; i <= 64; i++ {
		addition, _ := Square(i)
		sum += addition
	}
	return sum
}
