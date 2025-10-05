package prime

import (
	"errors"
	"math"
)

// Nth returns the nth prime number. An error must be returned if the nth prime number can't be calculated ('n' is equal or less than zero)
func Nth(n int) (int, error) {
	if n < 1 {
		return 0, errors.New("input should be positive")
	}
	if n == 1 {
		return 2, nil
	}

	primeNumbers := make([]int, 1)
	primeNumbers[0] = 2
	curNum := 3

	for len(primeNumbers) < n {
		sqrt := int(math.Sqrt(float64(curNum)))
		isCurPrime := true
		for _, number := range primeNumbers {
			if number > sqrt {
				break
			}
			if curNum%number == 0 {
				isCurPrime = false
				break
			}
		}
		if isCurPrime {
			primeNumbers = append(primeNumbers, curNum)
		}
		curNum += 2
	}

	return primeNumbers[len(primeNumbers)-1], nil
}
