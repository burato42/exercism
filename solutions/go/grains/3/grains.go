package grains

import (
	"errors"
)

func Square(number int) (uint64, error) {
	if number <= 0 || number >= 65 {
		return 0, errors.New("number should be in a range [1, 64]")
	}
	return uint64(1 << (number - 1)), nil
}

func Total() uint64 {
	return (1 << 64) - 1
}
