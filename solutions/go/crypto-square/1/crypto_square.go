package cryptosquare

import (
	"math"
	"strings"
	"unicode"
)

func Encode(pt string) string {
	builder := strings.Builder{}
	var r int
	// Normalization
	for _, char := range pt {
		if unicode.IsLetter(char) || unicode.IsDigit(char) {
			builder.WriteRune(unicode.ToLower(char))
		}
	}

	normalized := builder.String()
	length := len(normalized)

	c := int(math.Ceil(math.Sqrt(float64(length))))
	if c*(c-1) >= length {
		r = c - 1
	} else {
		r = c
	}

	cipher := make([][]string, c)
	for i := range cipher {
		cipher[i] = make([]string, r+1)
		for j := range cipher[i] {
			cipher[i][j] = " "
		}
	}

	for i, char := range normalized {
		cipher[i%c][i/c] = string(char)

	}
	builder.Reset()
	for i := 0; i < c; i++ {
		for j := 0; j < r+1; j++ {
			builder.WriteString(cipher[i][j])
		}
	}
	res := builder.String()
	if len(res) == 0 {
		return ""
	}
	return res[:len(res)-1]

}
