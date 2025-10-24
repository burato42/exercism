package allyourbase

import (
	"errors"
	"slices"
)

func ConvertToBase(inputBase int, inputDigits []int, outputBase int) ([]int, error) {
	if inputBase <= 1 {
		return nil, errors.New("input base must be >= 2")
	}
	if outputBase <= 1 {
		return nil, errors.New("output base must be >= 2")
	}

	res := 0
	for _, digit := range inputDigits {
		if digit >= inputBase || digit < 0 {
			return nil, errors.New("all digits must satisfy 0 <= d < input base")
		}
		res = res*inputBase + digit
	}

	output := make([]int, 0)

	if res == 0 {
		return []int{0}, nil
	}
	for res > 0 {
		digit := res % outputBase
		output = append(output, digit)
		res /= outputBase
	}

	slices.Reverse(output)
	return output, nil

}
