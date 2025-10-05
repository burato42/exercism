package lsproduct

import (
	"errors"
	"unicode"
)

func multiplyDigits(digits string) (int64, error) {
	if digits == "" {
		return 0, errors.New("input must be not empty") 
	}
	var res int64 = 1
	for _, digit := range digits {
		if !unicode.IsDigit(digit) {
			return 0, errors.New("not a number")
		}
		num:= int64(digit - '0')
		res *= num
	}
	return res, nil
}

func LargestSeriesProduct(digits string, span int) (int64, error) {
	size := len(digits)
	if span > size || span < 0 {
		return 0, errors.New("span must be smaller than string length")
	}
	var maxProduct int64 = 0

	for i := 0; i < size-span+1; i++ {
		cur, err := multiplyDigits(digits[i : i+span])
		if err != nil {
			return 0, err
		}
		if cur > maxProduct {
			maxProduct = cur
		}
	}
	return maxProduct, nil
}
