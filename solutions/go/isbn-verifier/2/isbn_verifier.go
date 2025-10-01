package isbn

import (
	"strings"
)

func IsValidISBN(isbn string) bool {
	isbn = strings.ReplaceAll(isbn, "-", "")

	res := 0

	if len(isbn) != 10 {
		return false
	}

	for i, char := range isbn {
		if char >= '0' && char <= '9' {
			res += int(char-'0') * (10 - i)
		} else if i == 9 && char == 'X' {
			res += 10
		} else {
			return false
		}
	}

	return res%11 == 0
}
